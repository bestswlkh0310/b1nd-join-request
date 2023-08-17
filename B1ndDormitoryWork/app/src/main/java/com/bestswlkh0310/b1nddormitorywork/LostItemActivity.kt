package com.bestswlkh0310.b1nddormitorywork

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil.setImageLoader
import coil.ImageLoader
import coil.Coil;
import coil.request.ImageRequest
import com.bestswlkh0310.b1nddormitorywork.databinding.ActivityMainBinding
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.time.LocalDateTime
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong


class LostItemActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: LostItemAdapter
    private lateinit var clickedLostItem: LostItem

    private val dummyList: List<LostItem> = run {
        val items = arrayListOf<LostItem>()
        val imageList = arrayListOf(
            R.drawable.img_lostitem1 to "잃어버린 제갈을 찾습니다",
            R.drawable.img_lostitem2 to "잃어버린 제 안경 알을 찾습니다",
            R.drawable.img_lostitem3 to "잃어버린 제 허리를 찾습니다",
            R.drawable.img_lostitem4 to "잃어버린 제 맥북을 찾습니다",
            R.drawable.img_lostitem5 to "잃어버린 제 애완용 사마귀를 찾습니다",
            R.drawable.img_lostitem6 to "잃어버린 제 동찬이를 찾습니다",
            R.drawable.img_lostitem7 to "잃어버린 제 기타를 찾습니다",
        )

        repeat(100) {
            val idx = Random.nextInt(0 until imageList.size)
            items.add(LostItem(
                idx = it.toLong(),
                thumbnail = imageList[idx].first,
                title = imageList[idx].second,
                content = imageList[idx].second,
                author = "이강현",
                createdTime = LocalDateTime.now().minusDays(Random.nextLong(0L .. 20L))
            ))
        }
        items.sortedBy { it.createdTime }.reversed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        initAddLostItemFab()
    }

    private fun initRecyclerView() {
        adapter = LostItemAdapter(dummyList) {
            clickedLostItem = it
            toLostItemDetail()
        }
        with(binding) {
            rvLostItem.adapter = adapter
            rvLostItem.layoutManager = LinearLayoutManager(this@LostItemActivity)
        }
    }

    private fun initAddLostItemFab() {
        binding.fabAddLostItem.setOnClickListener {
            // Todo
            Log.d("TAG", "LostItemActivity - initAddLostItemFab() called")
        }
    }

    private fun toLostItemDetail() {
        val intent = Intent(this, LostItemDetailActivity::class.java)
        Log.d("TAG", "$clickedLostItem - toLostItemDetail() called")
        intent.putExtra("lostItem", Json.encodeToString(clickedLostItem))
        startActivity(intent)
    }
}