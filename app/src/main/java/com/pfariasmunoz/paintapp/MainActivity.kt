package com.pfariasmunoz.paintapp

import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        paintView.init(metrics)
        paintView.isDrawingCacheEnabled = true
        btn_clear.setOnClickListener({
            paintView.clear()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.normal -> {
                paintView.blur()
                return true
            }
        }
        return true
    }

    override fun onPause() {
        super.onPause()
//        val imgSave: String = MediaStore.Images.Media.insertImage(contentResolver, paintView.drawingCache, "${UUID.randomUUID()}.png", "drawing")
//
//        if (imgSave != null) {
//            Toast.makeText(this, "Drawing saved to Gallery", Toast.LENGTH_SHORT).show()
//            Log.i("SAVED", "This image was saved")
//        } else {
//            Toast.makeText(this, "Ooops!, Image could not be saved", Toast.LENGTH_SHORT).show()
//            Log.i("NOT SAVE", "THIS IMAGE WAS NOT SAVED")
//        }
//
//        paintView.destroyDrawingCache()
    }

}
