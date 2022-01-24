package com.example.socket_new

import android.app.Application
import io.socket.client.IO
import io.socket.client.Socket

/**
 * Created by Brandon Quintanilla on January/23/2022.
 */
class App :Application(){

    lateinit var mSocket: Socket

    override fun onCreate() {
        super.onCreate()
        try {
            mSocket = IO.socket(getString(R.string.midominio))
            mSocket.connect()
        } catch (e: Exception) {
        }
    }
}