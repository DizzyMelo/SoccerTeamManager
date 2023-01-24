package com.dicedev.soccerteammanager.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dicedev.soccerteammanager.ManagerApplication
import com.dicedev.soccerteammanager.data.DataOrException
import com.dicedev.soccerteammanager.models.TeamList

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {

    val data = produceState<DataOrException<TeamList, Boolean, Exception>>(
        initialValue = DataOrException(loading = true),
        producer = { value = homeViewModel.getTeams(ManagerApplication.accessToken!!) }
    ).value

    if (data.loading == true) {
        CircularProgressIndicator()
    } else if (data.data != null) {
        Text(text = "hi")
//        LazyColumn(content = {
//            items(items = data.data!!.teams) { item ->
//                Text(text = item.name)
//            }
//        })
    } else {
        Text(text = "something went wrong trying to load the data: ${data.exception!!.message}")
    }
}