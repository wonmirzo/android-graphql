package com.wonmirzo.android_graphql.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.exception.ApolloException
import com.wonmirzo.android_graphql.R
import com.wonmirzo.android_graphql.UsersListQuery
import com.wonmirzo.android_graphql.network.GraphQL
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        getUserList()
    }

    private fun getUserList() {
        lifecycleScope.launch {
            val response = try {
                GraphQL.get().query(UsersListQuery(10)).execute()
            } catch (e: ApolloException) {
                Log.d("MainActivity", e.toString())
            }
        }
    }
}