package com.rpskotlin.rpsgame2

import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    //Create by Pattanayu Rueanpanja 13580223
    var btn_start: Button? = null
    var btn_exit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start = findViewById(R.id.btn_start)
        btn_exit = findViewById(R.id.btn_exit)

        btn_start?.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        btn_exit?.setOnClickListener {
            finish()
        }

    }
}
