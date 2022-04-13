package com.amirhusseinsoori.data

import java.net.HttpURLConnection

object MockNetworkConfig {
    /**
     * This is the status of the call that is expected from server
     */
    var status = HttpURLConnection.HTTP_OK

    var productDetailFakeUrl =
        "/catalog/v4/products/productId/?apikey=D55EFE39C4EB4E04A50A65D2932C6127&format=json"
}