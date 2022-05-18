package com.example.project8_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButtonToggleGroup
import java.io.FileInputStream
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var dp : DatePicker
    lateinit var edtDiary : EditText
    lateinit var btnWrite : Button
    lateinit var fileName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 일기장"

        dp = findViewById(R.id.datePicker1)
        edtDiary = findViewById(R.id.edtDiary)
        btnWrite = findViewById(R.id.btnWrite)

        edtDiary.setText(readDiary(Integer.toString(dp.year) + "_"
                + Integer.toString(dp.month + 1) + "_"
                + Integer.toString(dp.dayOfMonth) + ".txt")) // 값을 받음과 동시에 setText
        btnWrite.isEnabled = true // 값을 받음과 동시에 true

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)

        dp.init(cYear, cMonth, cDay) { view, year, monthOfYear, dayOfMonth ->
            fileName = (Integer.toString(year) + "_"
                    + Integer.toString(monthOfYear + 1) + "_"
                    + Integer.toString(dayOfMonth) + ".txt")

            var str = readDiary(fileName)
            edtDiary.setText(str)
            btnWrite.isEnabled = true
        }

        btnWrite.setOnClickListener {
            var outFs = openFileOutput(fileName, Context.MODE_PRIVATE)
            var str = edtDiary.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()

            Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
        }
    }

    fun readDiary(fName: String) : String? {
        var diaryStr : String? = null
        var inFs : FileInputStream

        try {
            print(fName)
            inFs = openFileInput(fName)
            var txt = ByteArray(500)
            inFs.read(txt) // txt 파일에서 읽어옴
            inFs.close()
            diaryStr = txt.toString(Charsets.UTF_8).trim()
            btnWrite.text = "수정하기"
        } catch (e: IOException) {
            edtDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
        }

        return diaryStr
    }
}
