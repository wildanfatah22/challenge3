package com.example.challenge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge3.adapter.BookAdapter
import com.example.challenge3.data.BookList
import com.example.challenge3.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    private val adapter = BookAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
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

    private fun generateDummyData(): List<BookList> {
        val dummyData = mutableListOf<BookList>()
        // Buku yang dimulai dengan huruf A
        dummyData.add(BookList(1, resources.getIdentifier("img_1", "drawable", "com.example.challenge3") , "All We Had by Annie Weatherwax"))
        dummyData.add(BookList(1, resources.getIdentifier("img_1a", "drawable", "com.example.challenge3") , "Airman by Eoin Colfer"))
        dummyData.add(BookList(1, resources.getIdentifier("img_1b", "drawable", "com.example.challenge3") , "Absolute Brightness by James Lecesne"))

        return dummyData
    }

    companion object {
        const val KEY_NAME = "extra_name"
        const val KEY_ID = "extra id"

    }
}