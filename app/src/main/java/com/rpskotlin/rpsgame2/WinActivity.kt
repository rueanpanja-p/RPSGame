package com.rpskotlin.rpsgame2

import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class WinActivity : AppCompatActivity() {
    //Create by Pattanayu Rueanpanja 13580223
    var btn_end: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)

        btn_end = findViewById(R.id.btn_end)

        btn_end?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
