package com.example.project4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var switchAgree : Switch
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoOreo : RadioButton
    lateinit var rdoPie : RadioButton
    lateinit var rdoQ : RadioButton
    lateinit var btnExit : Button
    lateinit var btnInit : Button
    lateinit var imgAndroid : ImageView
    // 각 변수들 선언완료 (위젯)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "안드로이드 사진 보기"

        text1 = findViewById(R.id.Text1)
        switchAgree = findViewById(R.id.switchAgree)

        // 제네릭 타입 안써도 된다 , 왜냐하면 , 변수에 다 타입이 매겨져 있기 때문이다.
        text2 = findViewById(R.id.Text2)
        rGroup1 = findViewById(R.id.Rgroup1)
        rdoOreo = findViewById(R.id.RdoOreo)
        rdoPie = findViewById(R.id.RdoPie)
        rdoQ = findViewById(R.id.RdoQ)

        btnExit = findViewById(R.id.BtnExit)
        btnInit = findViewById(R.id.BtnInit)
        imgAndroid = findViewById(R.id.ImgAndroid)

        switchAgree.setOnCheckedChangeListener { compoundButton , b ->
            if(switchAgree.isChecked == true){
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                imgAndroid.visibility = android.view.View.VISIBLE
                btnExit.visibility = android.view.View.VISIBLE
                btnInit.visibility = android.view.View.VISIBLE
            }
            else{
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                imgAndroid.visibility = android.view.View.INVISIBLE
                btnExit.visibility = android.view.View.INVISIBLE
                btnInit.visibility = android.view.View.INVISIBLE
            }
        }

        rGroup1.setOnCheckedChangeListener { RadioGroup , b ->
            // 람다식으로 하는 것이 가장 편한듯 , 인자로 넘겨줄 것들 정하고 넘기니까 됐음
            when(rGroup1.checkedRadioButtonId){
                R.id.RdoOreo -> imgAndroid.setImageResource(R.drawable.oreo)
                R.id.RdoPie -> imgAndroid.setImageResource(R.drawable.pie)
                R.id.RdoQ -> imgAndroid.setImageResource(R.drawable.q)
            }
        }

        btnExit.setOnClickListener{
            // 이거하면 프로그램 종료
            finish()
        }

        btnInit.setOnClickListener{
            // init 시킴
            switchAgree.isChecked = false
            text2.visibility = android.view.View.INVISIBLE
            rGroup1.visibility = android.view.View.INVISIBLE
            imgAndroid.visibility = android.view.View.INVISIBLE
            btnExit.visibility = android.view.View.INVISIBLE
            btnInit.visibility = android.view.View.INVISIBLE
        }
    }
}