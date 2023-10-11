package com.example.challenge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge3.adapter.ListAdapter
import com.example.challenge3.data.AlphabetList
import com.example.challenge3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRv()

    }

    private fun setRv(){
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.setHasFixedSize(true)
        binding.rvList.adapter = adapter
        this.adapter.updateData(generateDummyData())
    }

    private fun generateDummyData(): List<AlphabetList> {
        val data = mutableListOf<AlphabetList>()
        for(i in 0 until 10) {
            val imageId = resources.getIdentifier("img_${i + 1}", "drawable", "com.example.challenge3")
            data.add(AlphabetList(i+1, ('A' + i).toString(), imageId))
        }
        return data
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}