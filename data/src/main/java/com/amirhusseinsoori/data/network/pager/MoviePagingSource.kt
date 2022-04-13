package com.amirhusseinsoori.data.network.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.amirhusseinsoori.data.mapper.mapListMovieToDomain
import com.amirhusseinsoori.data.network.response.Movie

import com.amirhusseinsoori.data.network.services.MovieApi
import com.amirhusseinsoori.domain.entity.MovieEntity

class MoviePagingSource(
    private val api: MovieApi
) : PagingSource<Int, MovieEntity>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieEntity> {
        val currentPage = params.key ?: 1
        return try {
            val response = api.getMovie(page = 1).mapListMovieToDomain()
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