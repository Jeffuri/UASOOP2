package com.project.buku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_buku.setOnClickListener{
            val intent = Intent(this, BukuActivity::class.java)
            startActivity(intent)
        }

        btn_pembeli.setOnClickListener{
            val intent = Intent(this, PembeliActivity::class.java)
            startActivity(intent)
        }
    }
}