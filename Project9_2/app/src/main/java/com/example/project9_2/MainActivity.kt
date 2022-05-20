package com.example.project9_2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val LINE = 1
        const val CIRCLE = 2
        const val RECT = 3
        var curShape = LINE
        var color = Color.RED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this)) // class 이기 때문에 this 를 붙혀준다.
        title = "간단 그림판"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menu!!.add(0, 1, 0, "선 그리기")
        menu!!.add(0, 2, 0, "원 그리기")
        menu!!.add(0, 3, 0, "사각형 그리기")
        var sMenu : SubMenu = menu.addSubMenu("색상 변경 >>")
        sMenu.add(0, 4, 0, "빨간색")
        sMenu.add(0, 5, 0, "파란색")
        sMenu.add(0, 6, 0, "초록색")
        return true
    }

    override fun onOptionsItemSelected(item : MenuItem) : Boolean {
        when (item.itemId) {
            1 -> {
                curShape = LINE // itemId 가 1 이면 선
                return true
            }

            2 -> {
                curShape = CIRCLE // item Id 가 2 이면 원
                return true
            }

            3 -> {
                curShape = RECT
                return true
            }

            4 -> { // 빨간색
                color = Color.RED
                return true
            }

            5 -> { // 파란색
                color = Color.BLUE
                return true
            }

            6 -> { // 초록색
                color = Color.GREEN
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
    private class MyGraphicView(context : Context) : View(context) { // 여기서만 쓸 거니까
        var startX = -1f
        var startY = -1f
        var stopX = -1f
        var stopY = -1f // 실제로는 이 값들을 다 0으로 해도 상관 없음 (-1 로 왜했을까?)

        override fun onTouchEvent(event: MotionEvent?): Boolean {
            when (event!!.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x
                    startY = event.y
                }
                MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> { // 눌렸을 때 혹은 움직였을 떄
                    stopX = event.x
                    stopY = event.y
                    this.invalidate()
                }
            }
            return true
        }

        override fun onDraw(canvas : Canvas) {
            super.onDraw(canvas)
            var paint = Paint()
            paint.isAntiAlias = true // 부드럽게
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE // 외곽선만 그리는 것
            paint.color = color

            when (curShape) {
                LINE -> canvas.drawLine(startX, startY, stopX, stopY, paint)
                CIRCLE -> {
                    var radius = Math.sqrt(Math.pow((stopX - startX).toDouble(), 2.0)
                            + Math.pow((stopY - startY).toDouble(), 2.0)).toFloat()

                    canvas.drawCircle(startX, startY, radius, paint)
                }
                RECT -> {
                    canvas.drawRect(startX, startY, stopX, stopY, paint)
                }
            }
        }
    }
}