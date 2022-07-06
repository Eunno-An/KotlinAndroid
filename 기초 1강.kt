package com.example.myapplication

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun main(){

    //helloWorld()
    //println(add(4, 5))

    //3. String template
    //$, {} 사용

//    val firstName = "Eunno"
//    val lastName = "An"
//
//    println("My name is ${firstName + lastName} I`m 25")
//    println("${1==0}")
//    //그냥 $를 쓰고 싶으면 escape 문자 사용해도 된다.
//    println("2\$ dollars")

    //4. 조건식
    //checkNum(1)

    //forAndWhile()

    //nullcheck()

    ignoreNulls("eunno")
}

//1. 함수

fun helloWorld(): Unit{//Unit = void와 같음.
    println("Hello World!")
}
//변수 명을 type보다 먼저!
fun add(a: Int, b: Int): Int{
    return a + b
}

//2. val, var
//val = value, 값. 바뀌지 않음.
//var = variable, 변할 수 있는 값
fun hi(){
    val a: Int = 10
    var b: Int = 10
    //a = 100 에러
    b = 100
    println(b)

    val c = 100
    var d = 100
    
}

//4. condition
fun maxBy(a: Int, b: Int): Int{
    if(a > b) return a
    else return b
}
//삼항 연산자와 매우 비슷하다
fun maxBy2(a: Int, b: Int) = if(a>b) a else b

fun checkNum(score: Int){
    when(score){
        0 -> println("This is 0")
        1 -> println("This is 1")
        2, 3 -> println("This is 2 or 3")
        else -> println("I don`t know")
    }
    //리턴형으로 사용 할 때는 else 가 꼭 있어야함.
    var b = when(score){
        1->1
        2->2
        else -> 3
    }
    println(b)

    when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("Not bad")
        else -> println("okay")
    }
}

// Expression vs Statement
//위에서 when이 실행을 하도록 쓰였으면 Statement, 리턴을 하는 용도로 쓰이면 Expression
//따라서 코틀린의 모든 함수는 Expression이다!!!
//Expression: 먼가 해서 값을 반환.
//Statement: 명령 지시.
//질문: 반환형이 없는 함수는 리턴이 없는데요?
//답변: Unit 형을 리턴한다.(Void와 역할 같음), 하지만 java에서는 unit이 아니고 void이기 때문에 Statement라고 할 수 있다.

//6. Array vs List
//Array: 메모리가 이미 할당이 되어있음.
//List: 1. List(UnMutable) 2.Mutable
//List는 Interface이다!
fun array(){
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)

    val array2 = arrayOf(1, "d", 3.4f)//Array<Any>
    val list2 = listOf(1, "d", 3.4f)//List<Any>

    array[0] = 3
    //list[0] = 2 <- 에러. why? list는 unmutable임. 따로 mutable list로 선언해야 한다.
    var k = list.get(2)

    var arrayList = arrayListOf<Int>()
    //val arrayList와 val arrayList의 차이?
    //둘 다 상관없다. arrayList의 참조값 자체가 바뀌지 않기 때문에
    //메모리 상에 listA가 있고 listB가 있다고 하자. arrayList는 listA를 가르키는 주소이다. listB를 갑자기 가르키지는 않는다.
    //추가적으로, val arrayList라고 선언했다면, 추후에 arrayList = arrayListOf()를 했을 때 에러가 발생했을 거임.
    arrayList.add(10)
    arrayList.add(20)


}

//7. For/While
fun forAndWhile(){
    val students = arrayListOf("eunno", "sunju", "jenny", "jennifer")
    for (name in students){
        println(name)
    }

    for((index, name) in students.withIndex()){//index를 같이 사용하고 싶을 때, withIndex()를 붙인다.
        println("${index+1} 번째 학생 : $name")
    }

    var sum = 0
    for (i in 1..10){
        sum += i
    }
    println(sum)

    sum = 0
    for(i in 1..10 step 2){
        sum += i
    }
    println(sum)

    sum=0
    for(i in 10 downTo  1){
        sum += i
    }
    println(sum)

    sum=0
    //until과 1..100의 차이? until은 100을 포함하지 않는다.
    for(i in 1 until 100){
        sum += i
    }
    println(sum)

    var index = 0
    while(index < 10){
        println("current index :  ${index++}")
    }


}

//8. NonNull과 Nullable
//자바와 다른 코틀린 만의 큰 특징이다.
fun nullcheck(){
    //NPE: Null Pointer Exception
    //왜 코틀린에서는 이렇게 Null 처리를 까다롭게 할까?
    //Null Pointer Exception은 compile time이 아닌, runtime에 잡을 수 있다.
    //이러면 여간 불편한게 한두가지가 아님. 그래서 compile time에 잡아주고자 이런 처리를 만든 것이다.

    var name: String = "eunno"//NonNull
    //var nullName: String = null -> error
    //var nullName: String? = null
    //nullable 설정할 때, 반드시 자료형을 선언해주어야 한다.

    var nameInUpperCase = name.uppercase()


    //null이면 null 반환, 아니면 값 반환
    //var nullNameInUpperCase = nullName?.uppercase()

    //?:
    //위에는 엘비스 프레슬리 연산자

    val lastName: String? = null
    val fullName = name + " " + (lastName ?: "No lastName")
    //근데 fullName = name + " " + {lastName ?: "No lastName"}으로 하면 실행 결과가 다르다! 이건 왜그럴까??
    //lambda function 때문이다!! {}은 람다표현식으로 정의된다! {}의 반환형을 변수에 넣을 수 있다. {}의 반환 스타일로 나오는 것.

    var mLastName = lastName?: throw IllegalArgumentException("No last name")


    println(fullName)



}
//!! 연산자
//컴파일러에게, 이건 절대 null일 리가 없어! 라고 알려주는 것.
//지양 하는 방법이다. 혹시나 null이 들어갈 경우 NPE가 떠버린다.

//let 함수
//자신의 리시버 객체를 람다식 내부로 옮겨서 실행하는 부분
//여기서는 email을 lambda식으로 옮김.
fun ignoreNulls(str : String?){
    val mNotNull : String = str!!
    println(mNotNull)
    val upper = mNotNull.uppercase()

    val email: String ?= null
    email?.let{//email이 null이 아니면?? 실행하는 것!! 굉장히 safe한 방법이다.
        println("my email is $email")
    }
}
