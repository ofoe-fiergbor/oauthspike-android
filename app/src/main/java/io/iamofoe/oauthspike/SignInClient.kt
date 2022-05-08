package io.iamofoe.oauthspike

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

object SignInClient {


    private const val web_token = "813872802455-kigot0d5l07fvb8gn65kmvbjtiqad1om.apps.googleusercontent.com"


    /** Configure sign-in to request the user's ID, email address, and basic
    profile. ID and basic profile are included in DEFAULT_SIGN_IN.**/
    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(web_token)
        .requestEmail()
        .build()

    fun googleSignInClient(activity: AppCompatActivity): GoogleSignInClient {
        return GoogleSignIn.getClient(activity, gso)
    }
}