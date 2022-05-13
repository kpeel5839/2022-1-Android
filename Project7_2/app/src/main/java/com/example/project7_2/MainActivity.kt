package com.example.project7_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout : RelativeLayout
    lateinit var editText : EditText
    lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "이미지 회전"
        baseLayout = findViewById(R.id.baseLayout)
        editText = findViewById(R.id.editText1)
        imageView = findViewById(R.id.imageView1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menu!!.add(0, 1, 0, "그림 회전")
        menu!!.add(0, 2, 0, "한라산")
        menu!!.add(0, 3, 0, "추자도")
        menu!!.add(0, 4, 0, "범섬")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                if (!editText.text.toString().isBlank()
                        && editText.text.toString().length != 0) { // blank 가 아니면서 길이가 0이 아닐때에 같은 거 아닌가?
                    imageView.rotation = editText.text.toString().toFloat()
                    return true
                }
            }

            2 -> {
                imageView.setImageResource(R.drawable.hanla)
                return true
            }

            3 -> {
                imageView.setImageResource(R.drawable.chuzado)
                return true
            }

            4 -> {
                imageView.setImageResource(R.drawable.bumsum)
                return true
            }
        }

        return false
    }
}