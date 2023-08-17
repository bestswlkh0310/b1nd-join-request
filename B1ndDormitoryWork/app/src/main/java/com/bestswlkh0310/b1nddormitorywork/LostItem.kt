package com.bestswlkh0310.b1nddormitorywork

import android.graphics.Bitmap
import java.time.LocalDateTime

data class LostItem(
    val idx: Long,
    val thumbnail: Int,
    val title: String,
    val content: String,
    val author: String,
    var createdTime: LocalDateTime,
)
