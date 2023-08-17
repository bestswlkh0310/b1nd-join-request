package com.bestswlkh0310.b1nddormitorywork

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Matrix
import android.widget.Toast

fun Activity.show(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun resizeBitmap(bitmap: Bitmap, maxWidth: Int, maxHeight: Int): Bitmap {
    val originalWidth = bitmap.width
    val originalHeight = bitmap.height
    val scaleWidth = maxWidth.toFloat() / originalWidth
    val scaleHeight = maxHeight.toFloat() / originalHeight

    val scaleFactor = if (scaleWidth < scaleHeight) scaleWidth else scaleHeight

    val newWidth = (originalWidth * scaleFactor).toInt()
    val newHeight = (originalHeight * scaleFactor).toInt()

    val matrix = Matrix()
    matrix.postScale(scaleFactor, scaleFactor)

    return Bitmap.createBitmap(bitmap, 0, 0, originalWidth, originalHeight, matrix, true)
}