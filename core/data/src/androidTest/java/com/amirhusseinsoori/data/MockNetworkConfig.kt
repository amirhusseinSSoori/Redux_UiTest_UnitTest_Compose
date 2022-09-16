package com.amirhusseinsoori.data

import java.net.HttpURLConnection

object MockNetworkConfig {
    /**
     * This is the status of the call that is expected from server
     */
    var status = HttpURLConnection.HTTP_OK

    var productDetailFakeUrl =
        "https://api.themoviedb.org/3/"
}