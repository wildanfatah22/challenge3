package com.example.challenge3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.challenge3.R
import com.example.challenge3.databinding.ActivityRegisterBinding
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegisterClicked()
        btnLoginClicked()
        btnBackClicked()
    }

    private fun btnRegisterClicked() {
        binding.btnRegister.setOnClickListener {
            val name = binding.edtNameInput.text.toString()
            val email = binding.edtEmailInput.text.toString()
            val password = binding.edtPasswordInput.text.toString()

            when {
                name.isEmpty() -> showErrorAndFocus(binding.edtName, "Name cannot be empty")
                email.isEmpty() -> showErrorAndFocus(binding.edtEmail, "Email cannot be empty")
                password.isEmpty() -> showErrorAndFocus(binding.edtPassword, "Password cannot be empty")
                else -> {
                    val intent = Intent(this, MainActivity::class.java)
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

    private fun btnLoginClicked() {
        binding.goLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun btnBackClicked() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}