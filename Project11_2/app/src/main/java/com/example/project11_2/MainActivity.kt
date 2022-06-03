package com.example.project11_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "갤러리 영화 포스터"

        var gallery = findViewById<Gallery>(R.id.gallery1)
        var galAdapter = MyGalleryAdapter(this)
        gallery.adapter = galAdapter
    }

    inner class MyGalleryAdapter(var context: Context) : BaseAdapter() {
        var posterId = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10
        )

        var posterTitle = arrayOf(
            "백두산", "스파이더맨", "기생충", "조커", "코로나",
            "더랍스터", "1917", "Yak ICE", "부산,", "엑시트"
        )

        override fun getCount(): Int {
            return posterId.size
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageview = ImageView(context)
            imageview.layoutParams = Gallery.LayoutParams(200, 300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5, 5, 5, 5)
            imageview.setImageResource(posterId[p0])

            imageview.setOnTouchListener { v, event ->
                var ivPoster = findViewById<ImageView>(R.id.ivPoster)
                ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                ivPoster.setImageResource(posterId[p0])

                var toast = Toast(this@MainActivity)
                var toastView = View.inflate(this@MainActivity, R.layout.toast1, null)
                var toastText = toastView.findViewById<TextView>(R.id.toastText1)
                toastText.text = posterTitle[p0]
                toast.view = toastView
                toast.show() // 보여주기까지 완료

                false
            }

            return imageview
        }

    }
}