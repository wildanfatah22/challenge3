package com.example.challenge3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge3.data.AlphabetList
import com.example.challenge3.databinding.ItemListBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val differ = AsyncListDiffer(this, RecyclerDiffUtilCallback())

    inner class ViewHolder(private var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AlphabetList) {
            binding.ivBanner.setImageResource(data.imagePicture)
            binding.listName.text = data.charAlphabet
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<AlphabetList>) {
        differ.submitList(data)
    }
}