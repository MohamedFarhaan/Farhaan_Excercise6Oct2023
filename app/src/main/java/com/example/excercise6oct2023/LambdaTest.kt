package com.example.excercise6oct2023


fun main() {

//    println("\n-------------Without Default Param assignment-------------\n")
//    trailing("1stpar") {
//        it + "_Modifed from trailing lambda" // without return keyword, last line of function will return that value
//    }
//
//    println("\n-------------Default Param assignment-------------\n")
//    trailing() {
//        it + "_Modifed from trailing lambda"
//    }

//    trailing2(3, cubeMe);
}

//fun trailing(firstParam: String = "Default first Param Value", funcAsParam: (String) -> String) {
//    println("First Param from Trailing = $firstParam")
//    println("Second Param result of Function= ${funcAsParam("second Param")}")
//}

fun trailing2(firstParam: Int = 0, funcAsParam: (Int, Int) -> Int) {
//    println(funcAsParam(firstParam))
}

//fun cubeMe(value: Int, iteration: Int = 0): Int {
//    if(iteration <= 3) {
//        return value;
//    } else {
//        cubeMe(value*value, iteration+1)
//    }
//}