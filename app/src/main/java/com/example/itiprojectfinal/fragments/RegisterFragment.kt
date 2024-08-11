package com.example.itiprojectfinal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.itiprojectfinal.R


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val usernameEditText: EditText = view.findViewById(R.id.RUsername)
        val passwordEditText: EditText = view.findViewById(R.id.RPassword)
        val confirmPassEditText: EditText = view.findViewById(R.id.ConfirmPassword)
        val loginText: TextView = view.findViewById(R.id.loginLink)
        val regisetButton: Button = view.findViewById(R.id.registerButton)

        loginText.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

        }

        super.onViewCreated(view, savedInstanceState)
        regisetButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPassEditText.text.toString()
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (password != confirmPassword) {
                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG).show()
                return@setOnClickListener

            }
            if(registerUser(username,password)){
                findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            }
        }
    }


    private fun registerUser(username: String, password: String): Boolean {
        return username == "user" && password == "pass"
    }

}
