package com.example.myapplication

//object
//CarFactory라는 object는
//모든 앱을 실행할 때, 단 한번만 만들어 진다.
//이를 싱글톤 패턴이라고 한다!!
//Singleton Pattern
object CarFactory{
    val cars  = mutableListOf<Car>()
    fun makeCar(horsePower: Int): Car{
        val car = Car(horsePower)
        cars.add(car)
        return car
    }


}

data class Car(val horsePower: Int)

fun main(){
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(20)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}
