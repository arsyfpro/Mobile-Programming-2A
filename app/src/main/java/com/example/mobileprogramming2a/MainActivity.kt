package com.example.mobileprogramming2a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLatihan = findViewById<Button>(R.id.btn_activity_latihan)
        val btnHitung = findViewById<Button>(R.id.btn_activity_hitung)
        val btnClose = findViewById<Button>(R.id.btn_close)

        btnLatihan.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanActivity::class.java))
        }

        btnHitung.setOnClickListener {
            startActivity(Intent(this@MainActivity, HitungActivity::class.java))
        }

        btnClose.setOnClickListener {
            finish()
        }
    }
}