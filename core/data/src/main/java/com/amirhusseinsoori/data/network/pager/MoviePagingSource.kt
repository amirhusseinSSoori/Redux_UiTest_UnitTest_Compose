package com.amirhusseinsoori.data.network.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.amirhusseinsoori.common.Urls
import com.amirhusseinsoori.data.mapper.mapListMovieToDomain
import com.amirhusseinsoori.data.network.response.Movie

import com.amirhusseinsoori.domain.entity.MovieEntity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class MoviePagingSource @Inject constructor(
    private val api: HttpClient
) : PagingSource<Int, MovieEntity>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieEntity> {
        val currentPage = params.key ?: 1
        return try {
            val response = api.get {
                parameter("page", 1)
                url(Urls.Movies.endPoint)
            }.body<List<Movie>>().mapListMovieToDomain()

            val endOfPaginationReached = response.isEmpty()
            if (response.isNotEmpty()) {
                LoadResult.Page(
                    data = response,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieEntity>): Int? {
        return state.anchorPosition
    }

}