package com.example.coroutinepractice

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    runBlocking {
        printWithThreadName("START")
        launch {
            newRoutine()
        }
        yield()
        printWithThreadName("END")
    }
}

suspend fun newRoutine() {
    val num1 = 1
    val num2 = 2

    yield()
    printWithThreadName("num1 + num2 = ${num1 + num2}")
}

fun printWithThreadName(message: String) {
    println("${Thread.currentThread().name}: $message")
}