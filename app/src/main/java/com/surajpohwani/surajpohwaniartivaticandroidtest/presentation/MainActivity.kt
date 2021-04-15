package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.surajpohwani.surajpohwaniartivaticandroidtest.R
import com.surajpohwani.surajpohwaniartivaticandroidtest.databinding.ActivityMainBinding
import com.surajpohwani.surajpohwaniartivaticandroidtest.presentation.di.Injector
import javax.inject.Inject

const val countryId = "c4ab4c1c-9a55-4174-9ed2-cbbe0738eedf"

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainViewModelFactory

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
            fetchDataAndShowOnList()
        }

        binding.progressBar.visibility = View.VISIBLE
        fetchDataAndShowOnList()
    }

    private fun fetchDataAndShowOnList() {
        mainViewModel.getThingsToDo(countryId).observe(this, Observer {

            supportActionBar?.setTitle(it.title)

            adapter.setList(it.rows)
            adapter.notifyDataSetChanged()

            binding.progressBar.visibility = View.GONE
            if (binding.srList.isRefreshing)
                binding.srList.isRefreshing = false
        })

    }

    private fun setUpRecyclerView() {
        binding.rvList.setItemViewCacheSize(10)
        binding.rvList.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter()
        binding.rvList.adapter = adapter
    }
}