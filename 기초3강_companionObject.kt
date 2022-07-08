package com.example.myapplication

//companion object?(https://www.bsidesoft.com/8187 참조!!!! <- 여기 되 게 좋 다 !)
//java의 static method, value와 비슷 하지만 명백히 다르다!!!!
//자바의 static을 없애고 kotlin에서는 Companion Object라는 동반 객체를 사용하여 정적 멤버를 정의합니다.
//또한, Companion에 이름을 설정하여 커스텀한 Companion Object를 만들 수 있습니다.
//Q. 코틀린(Kotlin)의 Companion object는 단순히 자바(Java)의 static 키워드를 대체하기 위해서 탄생했을까요?
//A.  static이 붙은 변수와 메소드를 각각 클래스 변수, 클래스 메소드라 부릅니다.
// 반면, static이 붙지 않은 클래스 내의 변수와 메소드는 각각 인스턴스 변수, 인스턴스 메소드라 합니다.
// ★static이 붙은 멤버는 "클래스가 메모리에 적재될 때 자동으로 함께 생성"되므로 인스턴스 생성 없이도 클래스명 다음에 점(.)을 쓰면 바로 참조할 수 있습니다.


//Q. companion object와 static의 차이?
//A. Companion object는 class가 메모리에 적재되면서 같이 올라온다! 따라서 우리가 class에 있는 companion object의 변수 또는 함수에 접근할 때,
//   CLASS_NAME.Companion.(함수 or 변수) 이런 식으로 접근할 수 있다는 것!
//   사실 Companion object는 객체이다!!하지만 클래스 내 정의된 companion object는 클래스 이름 만으로 참조가 가능하다! 이게 static과의 차이이다

//Q. 한 클래스에 두개의 companion object를 선언할 수 있을까?
//A. No! 지금까지 배운 것으로 유추해봤을 때, companion object는 클래스 이름만으로 참조가 가능하다. 만약 companion object가 두개가 선언 되어 있다면
//   클래스 이름으로 두개의 companion object를 참조해야 하는데, 이는 설계와 맞지 않는다..


//static? 자바에서, 클래스 내에서 선언하지만, 다른 멤버 변수처럼 객체가 생성될 때마다 생성되는 변수가 아니다.
//      다른 지역변수는 stack 영역에 쌓이는 것과 달리 static은
//      data 영역에 저장된다.
//프로그램이 실행되어 메모리에 올라갔을 때 딱 한 번 메모리에 공간이 할당 된다.
//예를 들어, 게임의 최고기록은 static 변수를 통해 선언한 적이 있다.


//private constructor?
//다른 곳에서 객체를 생성하지 못하게 함.
class Book private constructor(val id : Int, val name: String){
    companion object BookFactory: IdProvider{//Companion object인 BookFactory를 통해 Book 객체를 생성. BookFactory는 생략 가능./
        override fun getId(): Int{
            return 444
        }

        val myBook = "new Book"

        fun create() = Book(0, myBook)
    }
}

interface IdProvider{
    fun getId() : Int
}
fun main(){
    //val book = Book()  -> companion object를 선언 안하였다면 Error 발생

    val book = Book.create() // Book.Companion.create()로 해도 되는데 Companion은 생략 가능
    //Q.만약 Book  class를 data class로 선언한다면 어떻게 될까?
    //A.data class 가 제공하는 copy 메소드를 통해 private이 보장되지 않는다. 결국 의미가 없어진다.

    val bookId = Book.getId()

    println("${book.id} and ${book.name}")
    println(bookId)
}
