package com.example.challenge3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.challenge3.R
import com.example.challenge3.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnLoginClicked()
        btnRegisterClicked()
    }

    private fun btnLoginClicked() {
        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmailInput.text.toString()
            val password = binding.edtPasswordInput.text.toString()

            when {
                email.isEmpty() -> showErrorAndFocus(binding.edtEmail, "Email cannot be empty")
                password.isEmpty() -> showErrorAndFocus(binding.edtPassword, "Password cannot be empty")
                else -> {
                    val intent = Intent(this, FragmentActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun showErrorAndFocus(view: View, errorMessage: String) {
        if (view is TextInputLayout) {
            view.error = errorMessage
            view.editText?.requestFocus()
        }
    }

    private fun btnRegisterClicked() {
        binding.goRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}