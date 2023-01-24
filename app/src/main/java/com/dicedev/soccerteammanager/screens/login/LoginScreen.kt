package com.dicedev.soccerteammanager.screens.login

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.dicedev.soccerteammanager.ManagerApplication
import com.dicedev.soccerteammanager.R

@Composable
fun LoginScreen(navController: NavController) {
    val clientId: String = stringResource(id = R.string.com_auth0_client_id)
    val domain: String = stringResource(id = R.string.com_auth0_domain)
    val context = LocalContext.current

    Button(onClick = {
        WebAuthProvider.login(
            Auth0(clientId, domain)
        ).withScheme("demo").withScope("daniel.melo42@outlook.com").start(context, object :
            Callback<Credentials, AuthenticationException> {
            override fun onSuccess(result: Credentials) {
                ManagerApplication.accessToken = result.accessToken
            }

            override fun onFailure(error: AuthenticationException) {
                Log.d("AUth0", "onFailure: authentication went wrong")
            }
        })
    }) {
        Text(text = "Login")
    }
}
