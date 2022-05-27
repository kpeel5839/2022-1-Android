package com.example.project10_2

import android.app.Activity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView

class ResultActivity : Activity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        var tv = arrayOfNulls<TextView>(imageName!!.size) // null
        var rbar = arrayOfNulls<RatingBar>(imageName!!.size)

        var tvID = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,
                R.id.tv7, R.id.tv8, R.id.tv9)

        var rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3,
            R.id.rbar4, R.id.rbar5, R.id.rbar6,
            R.id.rbar7, R.id.rbar8, R.id.rbar9)

        var imageFileId = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)

        var firstTitle = findViewById<TextView>(R.id.firstTitle)
        var firstImage = findViewById<ImageView>(R.id.firstImage)

        var max = 0

        for (i in voteResult!!.indices) {
            if (voteResult[max] < voteResult[i]) { // 최대값 찾고
                max = i
            }
        }

        firstTitle.text = imageName[max]
        firstImage.setImageResource(imageFileId[max]) // 등록

        for (i in voteResult!!.indices) {
            tv[i] = findViewById(tvID[i])
            rbar[i] = findViewById(rbarID[i])
        }

        for (i in voteResult!!.indices) {
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.setRating(voteResult[i].toFloat())
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}