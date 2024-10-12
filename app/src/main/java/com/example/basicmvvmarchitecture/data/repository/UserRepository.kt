package com.example.basicmvvmarchitecture.data.repository

import com.example.basicmvvmarchitecture.data.model.User

class UserRepository {
    // Fake data source for demonstration purposes
    fun getUsers(): List<User> {
        return listOf(
            User("Samar Singh", 25),
            User("Sarvesh Singh", 30),
            User("Emily Johnson", 22)
        )
    }
}