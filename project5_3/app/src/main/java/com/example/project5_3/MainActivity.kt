package com.example.project5_3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.Dimension

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT) // layout 선언

        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        setContentView(baseLayout , params)

        var editText = EditText(this)

        var textView = TextView(this)
        textView.text = "IT Cookbook. Android"
        textView.setTextColor(Color.MAGENTA)
        textView.setTextSize(Dimension.SP , 20F)

        var btn = Button(this)
        btn.text = "버튼입니다." // 버튼에 텍스트 채우기
        btn.width = baseLayout.width // match_parent 효과
        btn.setBackgroundColor(Color.YELLOW)

        baseLayout.addView(editText)
        baseLayout.addView(btn)
        baseLayout.addView(textView)
    }
}