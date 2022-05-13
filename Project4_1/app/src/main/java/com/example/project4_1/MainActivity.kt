package com.example.project4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var btnMod : Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Float ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "초간단 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        btnMod = findViewById<Button>(R.id.BtnMod)
        textResult = findViewById<TextView>(R.id.TextResult)

        btnAdd.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (!(num1.isBlank() || num2.isBlank())) { // Blank 처리해야지 아무것도 안들어왔을 떄 처리 가능
                result = num1.toFloat() + num2.toFloat()
                textResult.text = "계산 결과 : " + result.toString()
            } else Toast.makeText(this@MainActivity, "값을 입력하시오", Toast.LENGTH_SHORT).show()
        }

        btnSub.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(!(num1.isBlank() || num2.isBlank())) { // Blank 처리해야지 아무것도 안들어왔을 떄 처리 가능
                result = num1.toFloat() - num2.toFloat()
                textResult.text = "계산 결과 : " + result.toString()
            }
            else Toast.makeText(this@MainActivity, "값을 입력하시오", Toast.LENGTH_SHORT).show()
        }

        btnMul.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(!(num1.isBlank() || num2.isBlank())) { // Blank 처리해야지 아무것도 안들어왔을 떄 처리 가능
                result = num1.toFloat() * num2.toFloat()
                textResult.text = "계산 결과 : " + result.toString()
            }
            else Toast.makeText(this@MainActivity, "값을 입력하시오", Toast.LENGTH_SHORT).show()
        }

        btnDiv.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(!(num1.isBlank() || num2.isBlank())) { // Blank 처리해야지 아무것도 안들어왔을 떄 처리 가능
                result = num1.toFloat() / num2.toFloat()
                textResult.text = "계산 결과 : " + result.toString()
            }
            if(!num2.isBlank() && num2.toFloat() == 0f){
                Toast.makeText(this@MainActivity , "0으로 나눌 수 없습니다." , Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(this@MainActivity, "값을 입력하시오", Toast.LENGTH_SHORT).show()
        }

        btnMod.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(!(num1.isBlank() || num2.isBlank())) { // Blank 처리해야지 아무것도 안들어왔을 떄 처리 가능
                result = num1.toFloat() % num2.toFloat()
                textResult.text = "계산 결과 : " + result.toString()
            }
            else Toast.makeText(this@MainActivity, "값을 입력하시오", Toast.LENGTH_SHORT).show()
        }
    }
}