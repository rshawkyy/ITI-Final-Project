package com.example.itiprojectfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.itiprojectfinal.DB.AppDatabase
import com.example.itiprojectfinal.R


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    // Initialize the database and userDao
//    val db = AppDatabase.getDatabase(requireContext())
  //  userDao = db.userDao()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val usernameText: EditText = view.findViewById(R.id.Username)
        val passwordText: EditText = view.findViewById(R.id.Password)
        val loginButton: Button = view.findViewById(R.id.loginButton)
        val registerLink : TextView = view.findViewById(R.id.registerLink)
        loginButton.setOnClickListener {
            val  username = usernameText.text.toString()
            val  password = passwordText.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Please enter both username and password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (authenticateUser(username, password)) {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                Toast.makeText(context, "Account Not Register", Toast.LENGTH_SHORT).show()
            }
        }
        registerLink.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun authenticateUser(username: String, password: String): Boolean { // should updated this fun when connected to DB
        return username == "user" && password == "pass"
        //return userDao.authenticateUser(username, password)
    }
}