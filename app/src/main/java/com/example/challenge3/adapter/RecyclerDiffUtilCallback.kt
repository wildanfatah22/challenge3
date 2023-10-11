package com.example.challenge3.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.challenge3.data.AlphabetList

class RecyclerDiffUtilCallback : DiffUtil.ItemCallback<AlphabetList>() {
    override fun areItemsTheSame(oldItem: AlphabetList, newItem: AlphabetList): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: AlphabetList, newItem: AlphabetList): Boolean {
        return oldItem.id == newItem.id && oldItem.charAlphabet == newItem.charAlphabet
    }

}