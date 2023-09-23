package es.unex.giiis.asee.tiviclones02.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

import es.unex.giiis.asee.tiviclones02.databinding.ActivityLoginBinding
import es.unex.giiis.asee.tiviclones02.model.User
import es.unex.giiis.asee.tiviclones02.utils.CredentialCheck

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val responseLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
               //TODO get data from result and update IU
                val name = ""
                val password = ""
                Toast.makeText(
                    this@LoginActivity,
                    "New user ($name/$password) created",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //view binding and set content view
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //views initialization and listeners
        setUpUI()
        setUpListeners()
    }

    private fun setUpUI() {
        //get attributes from xml using binding
    }

    private fun setUpListeners() {
        with(binding) {

            btLogin.setOnClickListener {
                val check = CredentialCheck.login(etUsername.text.toString(), etPassword.text.toString())

                if (check.fail) notifyInvalidCredentials(check.msg)
                else navigateToHomeActivity(User(etUsername.text.toString(), etPassword.text.toString()), check.msg)
            }

            btRegister.setOnClickListener {
                navigateToJoin()
            }

            btWebsiteLink.setOnClickListener {
                navigateToWebsite()
            }
        }
    }

    private fun navigateToHomeActivity(user: User, msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        //TODO go to home activity
    }

    private fun navigateToJoin() {
        //TODO go to join activity
    }

    private fun navigateToWebsite() {
        //TODO go to website "https://trakt.tv/"
    }

    private fun notifyInvalidCredentials(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}