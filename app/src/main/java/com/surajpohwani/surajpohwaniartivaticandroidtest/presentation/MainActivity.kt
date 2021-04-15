package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.surajpohwani.surajpohwaniartivaticandroidtest.R
import com.surajpohwani.surajpohwaniartivaticandroidtest.databinding.ActivityMainBinding
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    private lateinit var factory: MainViewModelFactory

    private lateinit var mainViewModel: MainViewModel

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as Injector).createMainActivitySubComponent().inject(this)
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

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