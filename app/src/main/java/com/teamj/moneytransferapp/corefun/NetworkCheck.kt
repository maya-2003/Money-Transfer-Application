package com.teamj.moneytransferapp.corefun

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberConnectivityState(): State<Boolean> {

    val context = LocalContext.current
    val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val connectionState = remember { mutableStateOf(false) }

    DisposableEffect(Unit) {

        val initialNetwork = connectionManager.activeNetwork
        val initialNetworkCapabilities = connectionManager.getNetworkCapabilities(initialNetwork)

        val networkCallBack = object : ConnectivityManager.NetworkCallback() {


            override fun onUnavailable() {

                connectionState.value = false
            }
            override fun onLost(network: Network) {
                connectionState.value = false
            }

            override fun onAvailable(network: Network) {
                connectionState.value = true
            }

            override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {

                val hasWifi = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                connectionState.value = hasWifi
            }


        }

        val networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()

        connectionManager.registerNetworkCallback(networkRequest, networkCallBack)
        onDispose {
            connectionManager.unregisterNetworkCallback(networkCallBack)
        }

    }

    return connectionState
}
