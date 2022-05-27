package com.example.project10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    companion object {
        var activityNumber = 2
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(radioGroup.checkedRadioButtonId) {
                R.id.radioSecondActivity -> {
                    activityNumber = 2
                }

                R.id.radioThirdActivity -> {
                    activityNumber = 3
                }
            }
        }

        btnNewActivity.setOnClickListener {
            var intent: Intent

            if (activityNumber == 2) {
                intent = Intent(applicationContext, SecondActivity::class.java)
            } else {
                intent = Intent(applicationContext, ThirdActivity::class.java)
            }

            startActivity(intent)
        }
    }
}