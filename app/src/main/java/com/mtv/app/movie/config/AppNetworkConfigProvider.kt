package com.mtv.app.movie.config

import com.mtv.app.movie.BuildConfig
import com.mtv.based.core.network.utils.NetworkConfig
import com.mtv.based.core.network.utils.NetworkConfigProvider

class AppNetworkConfigProvider : NetworkConfigProvider {
    override fun provide(): NetworkConfig =
        AppNetworkConfig(
            baseUrl = BuildConfig.BASE_URL,
            useKtor = BuildConfig.USE_KTOR
        )
}
