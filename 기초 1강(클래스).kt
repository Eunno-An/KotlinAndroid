package com.example.myapplication

//생성자 하는건 클래스 이름 뒤에 constructor(변수이름: 자료형, ...)
//이런 방식 말고도, class Human constructor(val name: String) <- 이렇게 해도 된다! 이럼 name이 프로퍼티로 있는 것과 마찬가지임.
//아니면 constructor라는 키워드를 생략해도 된다.
//프로퍼티에 디폴트 값을 줄 수도 있다. 이렇게 하면 안에 변수는 딱히 안넣어줘도 된다.
open class Human (name: String="Anonymous"){

    var name = name

    //init은 처음 Human이라는 코드블록이 생성되었을 때 가장 먼저 하는 행동들을 선언할 수 있는 곳이다.
    //constructor가 아무리 많아도 init부터 실행이 된다.

    init{
        println("New human has been born!")
    }

    //코틀린에서 overloading을 이용하고 싶으면? constructor라는 키워드를 사용하면 된다.
    //이렇게 생성된 생성자는 부 생성자라고 이름짓는다.
    //부 생성자는 반드시 주 생성자의 위임을 받아야 하는데, 이는 this로 해결 가능하다.
    //만약 주 생성자로부터 위임 받을게 없다고 가정하자. class Human{}일 때!
    //이때는 this(name)을 없애야 한다. 하면 에러뜸.
    constructor(name: String, age: Int): this(name){
        println("My name is $name , $age years")
    }

    fun eatingcake(){
        println("Ah 더워")
    }

    //오버라이딩 할 때, 부모의 입장에서 자식에게 열어주어야 함.
    open fun singASong(){
        println("lalala")
    }
}
//상속
//class Korean : Human()이라고 하면 에러가 뜨는 이유?
//코틀린의 클래스는 기본적으로 파일 클래스! 아무리 같은 파일에 있더라도 접근을 못함.
//해결 방법은 Human class 앞에 open 키워드를 붙이는 것.
class Korean : Human(){
    override fun singASong() {//overriding 할 때는 부모의 함수에도 open을 해주어야 한다!!!!
        println("랄랄라")
        println("My name is $name")
    }
}
fun main(){
    val human = Human("eunno")
    human.eatingcake()
    val mom = Human("Lee", 49)

    val kor = Korean()
    kor.singASong()
}
