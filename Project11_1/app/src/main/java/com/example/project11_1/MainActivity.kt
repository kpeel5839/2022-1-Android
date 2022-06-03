package com.example.project11_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import java.util.function.ToDoubleBiFunction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "그리드뷰 영화 포스터"

        var gv = findViewById<View>(R.id.gridView1) as GridView
        var gAdapter = MyGridAdapter(this)
        gv.adapter = gAdapter
    }

    inner class MyGridAdapter(var context: Context) : BaseAdapter() {
        var posterId = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10, R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10, R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
        )

        var posterTitle = arrayOf(
            "백두산", "스파이더맨", "기생충", "조커", "코로나", "더 랍스터", "1917", "Yak ICE", "부산행", "엑시트",
            "백두산", "스파이더맨", "기생충", "조커", "코로나", "더 랍스터", "1917", "Yak ICE", "부산행", "엑시트",
            "백두산", "스파이더맨", "기생충", "조커", "코로나", "더 랍스터", "1917", "Yak ICE", "부산행", "엑시트",
            "백두산", "스파이더맨", "기생충", "조커", "코로나", "더 랍스터", "1917", "Yak ICE", "부산행", "엑시트"
        )

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageView = ImageView(context)
            imageView.layoutParams = ViewGroup.LayoutParams(200, 300)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(5, 5, 5, 5)

            imageView.setImageResource(posterId[p0])

            imageView.setOnClickListener {
                var dialogView = View.inflate(this@MainActivity, R.layout.dialog, null)
                var dlg = AlertDialog.Builder(this@MainActivity)
                var ivPoster = dialogView.findViewById<ImageView>(R.id.ivPoster)
                ivPoster.setImageResource(posterId[p0])
                dlg.setTitle(posterTitle[p0])
                dlg.setIcon(R.drawable.movie_icon)
                dlg.setView(dialogView)
                dlg.setNegativeButton("닫기", null)
                dlg.show()
            }
            return imageView
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return posterId.size
        }
    }
}