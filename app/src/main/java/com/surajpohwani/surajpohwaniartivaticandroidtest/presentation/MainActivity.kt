package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.surajpohwani.surajpohwaniartivaticandroidtest.R
import com.surajpohwani.surajpohwaniartivaticandroidtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpRecyclerView()
        binding.srList.setOnRefreshListener {

        }
    }

    private fun setUpRecyclerView() {
        binding.rvList.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter()
        binding.rvList.adapter = adapter
    }
}