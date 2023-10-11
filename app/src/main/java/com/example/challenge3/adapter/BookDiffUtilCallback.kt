package com.example.challenge3.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.challenge3.data.BookList

class BookDiffUtilCallback : DiffUtil.ItemCallback<BookList>() {
    override fun areItemsTheSame(oldItem: BookList, newItem: BookList): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BookList, newItem: BookList): Boolean {
        return oldItem.id == newItem.id && oldItem.name == newItem.name
    }

}