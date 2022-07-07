package com.example.myapplication

//1. lambda
//람다식은 우리가 마치 value 처럼 다룰 수 있는 익명 함수.
//1)메소드의 파라미터로 넘겨줄 수 있다.
//2)리턴값으로 사용할 수 있다.
//3)Type 추론이 가능하다.
//람다의 기본 정의
//val lambdaName: (Input Type) -> Output Type = {argumentList -> codeBody}

//흔히 함수로 쓰이는데, 선언형이 val이나 var로 하는게 좀 특이하다!!!
val square = {number: Int -> number * number}

val nameAge = {name: String, age: Int -> "$name and $age"}
fun main(){
    println(square(16))
    println(nameAge("안은노", 25))

    val a = "eunno said "
    val b = "noeun said "
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(pizzaIsGreat)

    println(extendString("eunno", 25))
    println(calculate(97))

    val lamda = {number:Double ->
        number == 4.234
    }
    println(invokeLambda(lamda))
    println(invokeLambda({it > 3.22}))

    //함수의 마지막 파라미터가 람다일 때는 이런 표현식이 가능하다.
    //코틀린에서 굉장히 많이 나오는 표현임!!
    println(invokeLambda{it>3.22})
}
//확장 함수
//기존 Class에 어떤 걸 추가하고 싶을 때
val pizzaIsGreat: String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name: String, age: Int): String{

    //it이란?
    //String.(Int)와 같이 매개변수가 하나일 때 쓰일 수 있는 예약어.
    //여기서 this는 확장함수가 불러줄 오브젝트. 즉 String.(Int)에서 String에 해당됨.
    val introduceMySelf: String.(Int) -> String = {"I an $this and $it years old"}
    return name.introduceMySelf(age)
}

//람다의 Return
//마지막 표현식이 리턴의 밸류 타입을 지정을 한다.
val calculate: (Int) -> String = {
    when(it){
        in 0..40 -> "Fail"
        in 41..70 -> "Pass"
        in 71..100 -> "Perfect"
        else -> "Error!"
    }
}

//람다를 표현하는 여러가지 방법 4가지 중 두가지
//1)메소드의 파라미터
fun invokeLambda(lambda: (Double)->Boolean) : Boolean{
    return lambda(5.2343)
}
