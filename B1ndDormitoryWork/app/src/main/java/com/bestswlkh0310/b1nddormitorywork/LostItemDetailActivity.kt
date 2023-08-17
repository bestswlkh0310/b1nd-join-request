package com.bestswlkh0310.b1nddormitorywork

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bestswlkh0310.b1nddormitorywork.Gson.gson
import com.bestswlkh0310.b1nddormitorywork.databinding.ActivityLostItemDetailBinding
import com.google.gson.Gson
import java.time.LocalDateTime

class LostItemDetailActivity : AppCompatActivity() {

    private val binding: ActivityLostItemDetailBinding by lazy { ActivityLostItemDetailBinding.inflate(layoutInflater) }
    private lateinit var lostItem: LostItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadLostItem()
        initView()
        initToolBar()
        initButton()
        setContentView(binding.root)
    }

    private fun loadLostItem() {
        val intent = intent
        lostItem = gson.fromJson(intent.getStringExtra("lostItem"), LostItem::class.java)
    }

    private fun initView() {
        with(binding) {
            title.text = lostItem.title
            imgThumbnail.setImageResource(lostItem.thumbnail)
            author.text = lostItem.author
            content.text = lostItem.content
            val t = lostItem.createdTime
            val createdTimeText= "${t.year}-${t.month.value}-${t.dayOfMonth}"
            createdTime.text = createdTimeText
        }
    }

    private fun initToolBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initButton() {
        binding.btnFoundItem.setOnClickListener {
            show("찾았어요!")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}