package com.example.project10_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class SecondActivity : Activity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "Second 액티비티"

        var inIntent = intent
        var num1 = inIntent.getIntExtra("Num1", 0)
        var num2 = inIntent.getIntExtra("Num2", 0)
        var operation = inIntent.getIntExtra("Operation", 1) // default value == 1 로 받음
        var hapValue = 0;

        if (operation == 1) {
            hapValue = num1 + num2
        } else if (operation == 2) {
            hapValue = num1 - num2
        } else if (operation == 3) {
            hapValue = num1 * num2
        } else {
            hapValue = num1 / num2
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", hapValue) // hap 에다가 결과를 담는다.
            setResult(Activity.RESULT_OK, outIntent) // result 200 으로 반환
            finish()
        }
    }
}
