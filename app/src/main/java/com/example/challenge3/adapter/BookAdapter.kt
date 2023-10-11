package com.example.challenge3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge3.data.BookList
import com.example.challenge3.databinding.ItemListBinding

class BookAdapter: RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private val differ = AsyncListDiffer(this, BookDiffUtilCallback())

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(private var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BookList) {
            binding.ivBanner.setImageResource(data.imagePicture)
            binding.listName.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.itemView.setOnClickListener { onItemClickCallback?.onItemClicked(differ.currentList[position]) }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<BookList>) {
        differ.submitList(data)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: BookList)
    }

}