package com.bestswlkh0310.b1nddormitorywork

import android.app.Activity
import android.widget.Toast

fun Activity.show(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
