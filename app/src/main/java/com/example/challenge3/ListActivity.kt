package com.example.challenge3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
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
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val selectedAlphabet = intent.getCharExtra(KEY_LETTER, 'A')
        val filteredBooks = generateDummyData().filter { it.name.firstOrNull() == selectedAlphabet }
        setRv()
        adapter.updateData(filteredBooks)
    }

    private fun setRv() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.setHasFixedSize(true)
        binding.rvList.adapter = adapter

        adapter.setOnItemClickCallback(object : BookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BookList) {
                navigateToGoogle(data)
            }
        })
    }

    private fun navigateToGoogle(data: BookList) {
        val intent = Intent(this@ListActivity, GoogleActivity::class.java)
        intent.putExtra(GoogleActivity.EXTRA_SEARCH_QUERY, data.name)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun generateDummyData(): List<BookList> {
        val dummyData = mutableListOf<BookList>()
        // Buku yang dimulai dengan huruf A
        dummyData.add(BookList(1, R.drawable.img_a, "All We Had by Annie Weatherwax"))
        dummyData.add(BookList(2, R.drawable.img_a1, "Airman by Eoin Colfer"))
        dummyData.add(BookList(3, R.drawable.img_a2, "Absolute Brightness by James Lecesne"))

        // Buku yang dimulai dengan huruf B
        dummyData.add(BookList(4, R.drawable.img_b, "Beauty and the Beast by The (MinaLima Edition)"))
        dummyData.add(BookList(5, R.drawable.img_b1, "Baby Brains by Simon James"))
        dummyData.add(BookList(6, R.drawable.img_b2, "Brown Bear, Brown Bear, What Do You See? by Eric Carle"))

        // Buku yang dimulai dengan huruf C
        dummyData.add(BookList(7, R.drawable.img_c, "Calling Me Home by Julie Kibler"))
        dummyData.add(BookList(8, R.drawable.img_c1, "California by Edan Lepucki"))
        dummyData.add(BookList(9, R.drawable.img_c2, "Cupcake by Charise Mericle Harper"))

        // Buku yang dimulai dengan huruf D
        dummyData.add(BookList(10, R.drawable.img_d, "Dune by Frank Herbert"))
        dummyData.add(BookList(11, R.drawable.img_d1, "Damnation Spring by Ash Davidson"))
        dummyData.add(BookList(12, R.drawable.img_d2, "Daisy Jones & The Six : A Novel by Taylor Jenkins Reid"))

        // Buku yang dimulai dengan huruf E
        dummyData.add(BookList(13, R.drawable.img_e, "Eleanor Oliphant Is Completely Fine by Gail Honeyman"))
        dummyData.add(BookList(14, R.drawable.img_e1, "Edgar and Lucy by Victor Lodato"))
        dummyData.add(BookList(15, R.drawable.img_e2, "Educated : A Memoir by Tara Westover"))

        // Buku yang dimulai dengan huruf F
        dummyData.add(BookList(16, R.drawable.img_f, "Frankenstein by Mary Shelley"))
        dummyData.add(BookList(17, R.drawable.img_f1, "Fall of Giants : Book One of the Century Trilogy by Ken Follett"))
        dummyData.add(BookList(18, R.drawable.img_f2, "Fallen Land by Taylor Brown"))

        // Buku yang dimulai dengan huruf G
        dummyData.add(BookList(19, R.drawable.img_g, "Grave's End by William Shaw"))
        dummyData.add(BookList(20, R.drawable.img_g1, "Galileo's Daughter : A Historical Memoir of Science, Faith, and Love by Dava Sobel"))
        dummyData.add(BookList(21, R.drawable.img_g2, "Galore by Michael Crummey"))

        // Buku yang dimulai dengan huruf H
        dummyData.add(BookList(22, R.drawable.img_h, "Harry Potter and the Sorcerer's Stone by J.K. Rowling"))
        dummyData.add(BookList(23, R.drawable.img_h1, "Harry Potter and The Chamber of Secrets by J.K. Rowling"))
        dummyData.add(BookList(24, R.drawable.img_h2, "Harry Potter and the Prisoner of Azkaban by J.K. Rowling"))

        // Buku yang dimulai dengan huruf I
        dummyData.add(BookList(25, R.drawable.img_i, "I Let You Go by Clare Mackintosh"))
        dummyData.add(BookList(26, R.drawable.img_i1, "I Must Betray You by Ruta Sepetys"))
        dummyData.add(BookList(27, R.drawable.img_i2, "I Will Die in a Foreign Land by Kalani Pickhart"))

        // Buku yang dimulai dengan huruf J
        dummyData.add(BookList(25, R.drawable.img_j, "Jurassic Park by Michael Crichton"))
        dummyData.add(BookList(26, R.drawable.img_j1, "Jackie & Me by Louis Bayard"))
        dummyData.add(BookList(27, R.drawable.img_j2, "Jim The Boy by Tony Earley"))


        return dummyData
    }

    companion object {
        const val KEY_LETTER = "extra_name"
    }
}