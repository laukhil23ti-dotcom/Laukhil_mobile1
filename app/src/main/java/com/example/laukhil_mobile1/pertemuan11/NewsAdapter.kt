package com.example.laukhil_mobile1.pertemuan11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.laukhil_mobile1.databinding.ItemNewsBinding

class NewsAdapter(
    private val newsList: List<NewsModel>,
    private val onItemClick: (NewsModel) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]
        with(holder.binding) {
            tvTitle.text = item.title
            tvDescription.text = item.description

            Glide.with(root.context)
                .load(item.imageUrl)
                .centerCrop()
                .into(ivNewsImage)

            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int = newsList.size
}
