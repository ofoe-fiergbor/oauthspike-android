package io.iamofoe.oauthspike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import io.iamofoe.oauthspike.databinding.ActivityHomeBinding
import io.iamofoe.oauthspike.databinding.ActivityMainBinding

class Home : AppCompatActivity() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        googleSignInClient = SignInClient.googleSignInClient(this)

        binding.logout.setOnClickListener {
            signOut()
        }

    }

    private fun signOut() {
        googleSignInClient.signOut()
            .addOnCompleteListener(this) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
    }
}