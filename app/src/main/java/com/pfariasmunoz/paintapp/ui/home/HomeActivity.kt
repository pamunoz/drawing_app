package com.pfariasmunoz.paintapp.ui.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pfariasmunoz.paintapp.ui.drawing.DrawingActivity
import com.pfariasmunoz.paintapp.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_draw.setOnClickListener({
            val intent = Intent(this, DrawingActivity::class.java)
            startActivity(intent)
        })

    }
}
