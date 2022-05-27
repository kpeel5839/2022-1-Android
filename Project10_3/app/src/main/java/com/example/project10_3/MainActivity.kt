package com.example.project10_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        var operation = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "메인 엑티비티"

        var rdGroup = findViewById<RadioGroup>(R.id.rdGroup)

        rdGroup.setOnCheckedChangeListener { group, checkedId ->
            when(rdGroup.checkedRadioButtonId) {
                R.id.rdAdd -> {
                    operation = 1
                }

                R.id.rdSub -> {
                    operation = 2
                }

                R.id.rdMul -> {
                    operation = 3
                }

                R.id.rdDiv -> {
                    operation = 4
                }
            }
        }

        var btnCal = findViewById<Button>(R.id.btnCal)

        btnCal.setOnClickListener {
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)
            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
            intent.putExtra("Operation", operation)
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap", 0) // hap 으로 넘어온 거 받아서 출력
            Toast.makeText(applicationContext, "합계 : $hap", Toast.LENGTH_SHORT).show()
        }
    }
}