package com.dicedev.soccerteammanager.screens.home

import androidx.lifecycle.ViewModel
import com.dicedev.soccerteammanager.data.DataOrException
import com.dicedev.soccerteammanager.models.TeamList
import com.dicedev.soccerteammanager.repository.TeamManagerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: TeamManagerRepository) :
    ViewModel() {

        suspend fun getTeams(auth: String): DataOrException<TeamList, Boolean, Exception> {
            return repository.getTeams(auth)
        }
}