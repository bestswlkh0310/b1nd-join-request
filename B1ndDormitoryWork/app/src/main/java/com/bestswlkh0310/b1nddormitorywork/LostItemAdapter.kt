package com.bestswlkh0310.b1nddormitorywork

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bestswlkh0310.b1nddormitorywork.databinding.ListLostItemBinding

class LostItemAdapter(
    private val lostItemList: List<LostItem>,
    private val onClickLostItem: (LostItem) -> Unit,
): RecyclerView.Adapter<LostItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListLostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lostItem = lostItemList[position]
        val image = lostItem.thumbnail
        with(holder) {
            thumbnail.setImageResource(image)
            title.text = lostItem.title
            author.text = lostItem.author
            root.setOnClickListener {
                onClickLostItem(lostItem)
            }
        }
    }

    override fun getItemCount() = lostItemList.size

    inner class ViewHolder(binding: ListLostItemBinding): RecyclerView.ViewHolder(binding.root) {
        val thumbnail = binding.imgThumbnail
        val title = binding.tvTitle
        val author = binding.tvAuthor
        val root = binding.root
    }
}