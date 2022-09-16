package com.amirhusseinsoori.data


import com.amirhusseinsoori.data.Remote.getValidJsonResponse
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

/**
 * Routes the request based on the path
 */
internal class RequestDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            MockNetworkConfig.productDetailFakeUrl -> {
                MockResponse().setResponseCode(MockNetworkConfig.status)
                    .setBody(getValidJsonResponse())
            }

            else -> throw IllegalArgumentException("Unable to find ${request.path}")
        }
    }



}
object Remote {
    /**
     * This returns a valid response from server
     */
    fun getValidJsonResponse(): String {
        val fileInputStream = javaClass.classLoader?.getResourceAsStream("json/validData.json")
        return fileInputStream?.bufferedReader()?.readText().toString()
    }
}
