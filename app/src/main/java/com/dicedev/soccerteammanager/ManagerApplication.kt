package com.dicedev.soccerteammanager

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ManagerApplication: Application() {
    companion object {
        var accessToken: String? = null
    }
}