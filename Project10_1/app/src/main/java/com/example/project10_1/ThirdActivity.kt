package com.example.project10_1

import android.app.Activity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : Activity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third)

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish() // 끝내는 것인듯
        }
    }
}
