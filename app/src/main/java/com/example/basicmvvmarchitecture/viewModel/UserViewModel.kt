package com.example.basicmvvmarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicmvvmarchitecture.data.model.User
import com.example.basicmvvmarchitecture.data.repository.UserRepository

class UserViewModel : ViewModel() {

    private val userRepository = UserRepository()

    // LiveData that holds the list of users
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    // Function to fetch users
    fun fetchUsers() {
        _users.value = userRepository.getUsers()
    }
}
