package com.example.basicmvvmarchitecture.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicmvvmarchitecture.R
import com.example.basicmvvmarchitecture.view.adapter.UserAdapter
import com.example.basicmvvmarchitecture.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    // Initialize ViewModel using the viewModels delegate
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val userAdapter = UserAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        // Observe LiveData from ViewModel
        userViewModel.users.observe(this, Observer { users ->
            // Update RecyclerView when the user list changes
            userAdapter.submitList(users)
        })

        // Fetch users when activity is created
        userViewModel.fetchUsers()
    }
}
