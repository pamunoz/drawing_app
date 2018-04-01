package com.pfariasmunoz.paintapp.util

import android.content.Context
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import java.util.*


fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.savePng(paintView: View): String? {
    return MediaStore.Images.Media.insertImage(this.contentResolver, paintView.rootView.drawingCache, "${UUID.randomUUID()}.png", "drawing")
}