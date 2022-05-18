package com.example.project9_1

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }

    private class MyGraphicView(context : Context) : View(context) {

        override fun onDraw(canvas : Canvas) {
            super.onDraw(canvas)
            val paint = Paint() // 페인트 객체 선언

            paint.color = Color.BLACK // 색깔 줌
            paint.strokeWidth = 50f // 선 굵기

            canvas.drawLine(70f, 70f, 370f, 70f, paint) // line 을 해당 좌표로 그린다.

            paint.strokeCap = Paint.Cap.ROUND // round 하게 strokeCap 을 설정하고
            canvas.drawLine(60f, 150f, 380f, 150f, paint) // 둥근 라인 그림

            canvas.drawOval(RectF(70f, 210f, 70f + 300f, 210f + 140f), paint)  // 원 그리기

            canvas.drawArc(RectF(70f, 280f, 70f + 300f, 280f + 210f), 35f, 100f, true, paint) // arc 원 그리기

            val rect1 = Rect(100, 600, 100 + 200, 600 + 200) // 겹쳐서 그리기
            paint.color = Color.BLUE
            canvas.drawRect(rect1, paint)

            val rect2 = Rect(100 + 60, 600 + 60, 100 + 60 + 200, 600 + 60 + 200) // 겹쳐서 그리기
            paint.color = Color.argb(120, 255, 0, 0) // 투명도 있게 그리기
            canvas.drawRect(rect2, paint)
        }
    }
}