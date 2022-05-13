package com.example.project7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import kotlin.math.min

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
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuRotate -> {
                if (!editText.text.toString().isBlank() &&
                        editText.text.toString().length != 0) { // blank 가 아니면서 길이가 0이 아닐때에 같은 거 아닌가?
                    imageView.rotation = editText.text.toString().toFloat()
                    return true
                }
            }

            R.id.hanlaMenu -> {
                imageView.setImageResource(R.drawable.hanla)
                return true
            }

            R.id.chuzadoMenu -> {
                imageView.setImageResource(R.drawable.chuzado)
                return true
            }

            R.id.bumsumMenu -> {
                imageView.setImageResource(R.drawable.bumsum)
                return true
            }
        }

        return false
    }
}