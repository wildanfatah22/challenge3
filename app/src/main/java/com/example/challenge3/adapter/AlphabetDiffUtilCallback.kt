package com.example.challenge3.adapter

import androidx.recyclerview.widget.DiffUtil

class AlphabetDiffUtilCallback : DiffUtil.ItemCallback<Char>() {
    override fun areItemsTheSame(oldItem: Char, newItem: Char): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Char, newItem: Char): Boolean {
        return oldItem == newItem
    }
}

