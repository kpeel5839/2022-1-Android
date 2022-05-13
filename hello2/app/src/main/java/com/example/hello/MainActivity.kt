package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var button1 : Button
    lateinit var button2 : Button
    override fun onCreate(savedInstanceState: Bundle?) { // program 의 시작점은 여기임 , java 의 main이랑 같음
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // view 를 어느것을 반환하냐 인 것 같다.

        button1 = findViewById<Button>(R.id.button1) // 옛날에는 제네릭 형식으로 Button 임을 명시했었어야 했는데 지금은 아니다.
        button2 = findViewById(R.id.button2) // findByViewId button2 라는 id 로 해당 객체를 얻어옴(xml로)

        button1.setOnClickListener {
            Toast.makeText(applicationContext , "버튼을 눌렀습니다." , Toast.LENGTH_SHORT).show()
            // 잠깐 떴다가 사라지는 것을 Toast message라고 칭한다.
            // 그래서 makeText 를 이용해서 , applicationContext 에다가 등록한다는 느낌으로 값을 넣어준다음에 , 표시하고 싶은 메세지를 입력하면 된다.
            // 그리고 Toast.LENGTH_SHORT 라고 입력하여서 , 잠깐동안 보여준다 라고 지정해주고 , show() 를 통해서 결과적으로 출력을 시켜준다.
        }

        button2.setOnClickListener{ // 임의로 내가 만든 버튼 리스너
            Toast.makeText(applicationContext , "버튼을 눌르지 않았습니다." , Toast.LENGTH_LONG).show()
        }
    }
}