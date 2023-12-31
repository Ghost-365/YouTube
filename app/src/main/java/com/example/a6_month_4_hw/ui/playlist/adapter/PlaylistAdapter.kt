package com.example.a6_month_4_hw.ui.playlist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a6_month_4_hw.R
import com.example.a6_month_4_hw.databinding.ItemPlaylistsBinding
import com.example.a6_month_4_hw.model.Item

class PlaylistAdapter(private val onClick: (Item) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(liste: List<Item>) {
        this.list = liste as ArrayList<Item>
        notifyDataSetChanged()
    }

    private var list = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class PlaylistViewHolder(private val binding: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")

        fun bind(item: Item?) {
            with(binding) {
                image.load(item?.snippet?.thumbnails?.standard?.url)
                tvTitle.text = item?.snippet?.title
                tvVideo.text = item?.contentDetails?.itemCount.toString()

                itemView.setOnClickListener {
                    onClick.invoke(item!!)
                }
            }
        }
    }
}