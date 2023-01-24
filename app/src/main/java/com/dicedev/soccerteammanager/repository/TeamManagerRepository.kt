package com.dicedev.soccerteammanager.repository

import com.dicedev.soccerteammanager.data.DataOrException
import com.dicedev.soccerteammanager.models.TeamList
import com.dicedev.soccerteammanager.network.TeamManagerApi
import javax.inject.Inject

class TeamManagerRepository @Inject constructor(private val api: TeamManagerApi) {
    suspend fun getTeams(auth: String): DataOrException<TeamList, Boolean, Exception> {
        val response = try {
            api.getTeams(auth)
        } catch (exception: Exception) {
            return DataOrException(exception = exception)
        }
        return DataOrException(data = response)
    }
}