package com.example.preparedtoexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.view.View
import android.widget.EditText

// Toast 도 widget 아래에 있네
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(saveInstanceState : Bundle ?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_main)

        // R 이 resource 의 줄임말 -> res -> R 로 이런식의 flow로 수정되었다고 생각하자.
        var edit = findViewById<EditText>(R.id.edit)
        var btn1 = findViewById<Button>(R.id.btn1)
        var radio = findViewById<RadioButton>(R.id.radioBtn1)

        // TouchListener 의 기본적인 폼
        btn1.setOnTouchListener { view, motionEvent ->
            false
        }

        btn1.setOnClickListener {
            // Toast.LEGNTH_LONG 이 훨씬 길긴 한 듯
            Toast.makeText(applicationContext , "hello" , Toast.LENGTH_LONG).show()
        }

        // setOnCheckedListener 는 compoundButton, b 를 람다로 넘긴다.
        radio.setOnCheckedChangeListener { compoundButton, b ->

        }
    } // onCreate Override

}