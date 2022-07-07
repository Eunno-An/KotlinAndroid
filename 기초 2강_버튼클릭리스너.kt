//람다 심화편
package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?){

            }
        })
        //버튼에 람다식을 사용하기 위한 조건
        //1. 코틀린 인터페이스가 아닌 자바 인터페이스여야 한다.
        //2. 그 인터페이스는 딱 하나의 메소드만 가져야 한다.

        //익명 내부 함수를 저 두가지 조건만 만족한다면 람다식을 이용해 정말 간단히 표현할 수 있다.
        //결과:
        button.setOnClickListener{

        }
    }
}
