package com.bestswlkh0310.b1nddormitorywork

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bestswlkh0310.b1nddormitorywork.databinding.ActivityLostItemDetailBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

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
//        Log.d("TAG", "${intent.getStringExtra("lostItem")} - loadLostItem() called")
        lostItem = Json.decodeFromString(intent.getStringExtra("lostItem")!!)
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