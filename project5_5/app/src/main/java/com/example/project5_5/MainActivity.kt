package com.example.project5_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit internal var edit1 : EditText
    lateinit internal var edit2 : EditText
    lateinit internal var btnAdd : Button
    lateinit internal var btnSub : Button
    lateinit internal var btnMul : Button
    lateinit internal var btnDiv : Button
    lateinit internal var textResult : TextView
    lateinit internal var num1 : String
    lateinit internal var num2 : String
    internal var result : Int ? = null
    internal var numButtons = ArrayList<Button>(10)
    internal var numBtnIDs = arrayOf(R.id.BtnNum0 , R.id.BtnNum1
            ,R.id.BtnNum2 , R.id.BtnNum3 , R.id.BtnNum4 , R.id.BtnNum5 ,
        R.id.BtnNum6 , R.id.BtnNum7 , R.id.BtnNum8 ,R.id.BtnNum9)
    internal var I : Int = 0 // 증가값 용도

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "그리드레이아웃 계산기"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)

        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtnDiv)

        textResult = findViewById(R.id.TextResult)

        btnAdd.setOnTouchListener {view , motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = num1.toInt() + num2.toInt()
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnSub.setOnTouchListener {view , motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = num1.toInt() - num2.toInt()
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnMul.setOnTouchListener {view , motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = num1.toInt() * num2.toInt()
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnDiv.setOnTouchListener {view , motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = num1.toInt() / num2.toInt()
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        for(i in 0..9 step 1){
            numButtons.add(findViewById(numBtnIDs[i])) // numButtons 에다가 다 포함시켜준다.
        }

        for(i in 0..numBtnIDs.size - 1 step 1){
            numButtons[i].setOnClickListener{
                if(edit1.isFocused){
                    num1 = edit1.text.toString() + numButtons[i].getText().toString()
                    edit1.setText(num1)
                }
                else if(edit2.isFocused){
                    num2 = edit2.text.toString() + numButtons[i].getText().toString()
                    edit2.setText(num2)
                } else{
                    Toast.makeText(applicationContext,"먼저 에디트텍스트를 선택하세요" , Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}