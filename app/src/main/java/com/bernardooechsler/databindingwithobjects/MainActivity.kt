package com.bernardooechsler.databindingwithobjects

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.bernardooechsler.databindingwithobjects.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    private val saveUser: SharedPreferences by lazy {
//        getSharedPreferences("user", MODE_PRIVATE)
//    }

//    private val gson = Gson()

    private val viewModel = SavingDataViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var u1 = User(1, "Bernardo", "1234")
//        val userJson = gson.toJson(u1)
        viewModel.initializeSharedPreferences(this)
        viewModel.savingUser()
//        binding.user = viewModel.u1

//        binding.apply {
//            textviewUserid.text = u1.id.toString()
//            textviewName.text = u1.name
//            textviewPassword.text = u1.password
//            button.setOnClickListener {
//                getUser()
//            }
//        }
        binding.apply {
            user = viewModel.u1
            button.setOnClickListener {
                savedUsername.text = viewModel.getUser()
            }
        }

//        binding.button.setOnClickListener {
//                binding.savedUsername.text = viewModel.getUser()
//        }
    }

//    private fun savingUser(userJson: String) {
//        saveUser.edit {
//            putString("user", userJson)
//            apply()
//        }
//    }

//    private fun getUser() {
//        val userJson = saveUser.getString("user", null)
//        val user = gson.fromJson(userJson, User::class.java)
//
//        binding.savedUsername.text = user.name
//    }
}