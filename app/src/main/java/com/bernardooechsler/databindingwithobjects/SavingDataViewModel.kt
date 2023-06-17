package com.bernardooechsler.databindingwithobjects

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class SavingDataViewModel : ViewModel() {

    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    var u1 = User(1, "Bernardo", "1234")
    private val userJson = gson.toJson(u1)

    fun initializeSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
    }

    fun savingUser() {
        sharedPreferences.edit {
            putString("user", userJson)
            apply()
        }
    }

    fun getUser(): String {
        val userJson = sharedPreferences.getString("user", null)
        val user = gson.fromJson(userJson, User::class.java)
        return user.name
    }
}