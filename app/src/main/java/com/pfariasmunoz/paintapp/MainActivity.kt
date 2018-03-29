package com.pfariasmunoz.paintapp

import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.MenuItem
import com.pfariasmunoz.paintapp.extensions.savePng
import com.pfariasmunoz.paintapp.extensions.toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        paintView.init(metrics)
        btn_clear.setOnClickListener({
            paintView.clear()
        })
        btn_save.setOnClickListener({
            paintView.isDrawingCacheEnabled = true
            val imgSave = savePng(paintView)
            if (imgSave != null)
                toast("Drawing saved to gallery")
            else toast("oop´s image coud not be saved!")
            paintView.destroyDrawingCache()
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

}
