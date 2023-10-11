package com.example.challenge3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge3.databinding.ItemListBinding

class AlphabetAdapter : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {

    private val differ = AsyncListDiffer(this, AlphabetDiffUtilCallback())
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Char) {
            val imageId = binding.root.resources.getIdentifier("img_${data.toLowerCase()}", "drawable", binding.root.context.packageName)
            binding.ivBanner.setImageResource(imageId)
            binding.listName.text = data.toString()
            binding.root.setOnClickListener { onItemClickCallback?.onItemClicked(data) }
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
    fun updateData(data: List<Char>) {
        differ.submitList(data)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Char)
    }
}
