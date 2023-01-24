package com.dicedev.soccerteammanager.network

import com.dicedev.soccerteammanager.models.Team
import com.dicedev.soccerteammanager.models.TeamList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TeamManagerApi {

    @GET("teams/")
    suspend fun getTeams(): TeamList

    @GET("teams/{id}")
    suspend fun getTeam(@Path("id") id: String): Team

    @POST("teams/")
    suspend fun addTeam(@Body team: Team)

    @PUT("teams/{id}")
    suspend fun updateTeam(@Path("id") id: String)

    @DELETE("teams/{id}")
    suspend fun deleteTeam(@Path("id") id: String)
}