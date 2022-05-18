package com.example.project8_2

import android.app.Activity
import android.content.Context
import android.media.audiofx.EnvironmentalReverb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var btnPrev : Button
    lateinit var btnNext : Button
    lateinit var myPicture : myPictureView
    lateinit var textView : TextView
    var curNum : Int = 0
    var imageFiles : Array<File>? = null
    lateinit var imageFname : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 이미지 뷰어"

        ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        btnPrev = findViewById(R.id.btnPrev)
        btnNext = findViewById(R.id.btnNext)
        myPicture = findViewById(R.id.myPictureView1)
        textView = findViewById(R.id.text1)

        imageFiles = File(Environment.getExternalStorageDirectory().absolutePath + "/Pictures").listFiles()
        imageFname = imageFiles!![0].toString()
        myPicture.imagePath = imageFname

        btnPrev.setOnClickListener {
            curNum--

            if (curNum < 0) { // curNum 이 0보다 작거나 같아지면
                curNum = imageFiles!!.size - 1
            }

            imageFname = imageFiles!![curNum].toString()
            myPicture.imagePath = imageFname
            textView.text = (curNum + 1).toString() + "/" + imageFiles!!.size.toString()
            myPicture.invalidate()

        }

        btnNext.setOnClickListener {
            curNum++

            if (curNum > (imageFiles!!.size - 1)) {
                curNum = 0
            }

            imageFname = imageFiles!![curNum].toString()
            myPicture.imagePath = imageFname
            textView.text = (curNum + 1).toString() + "/" + imageFiles!!.size.toString()
            myPicture.invalidate()
        }
    }
}