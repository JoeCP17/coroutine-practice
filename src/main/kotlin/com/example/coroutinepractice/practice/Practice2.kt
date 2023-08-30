package com.example.coroutinepractice.practice

import com.example.coroutinepractice.printWithThreadName
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        val job1 = launch {
            delay(1_000L)
            printWithThreadName("JOB1")
        }

        val job2 = launch {
            delay(1_000L)
            printWithThreadName("JOB2")
        }
    }
}

fun example3() {
    runBlocking {
        val job = launch {
            (1..5).forEach {
                printWithThreadName("HELLO $it")
                delay(500L)
            }
        }

        delay(1_000L)
        job.cancel()
    }
}


fun example2() {
    runBlocking {
        val job = launch(start = CoroutineStart.LAZY) {
           printWithThreadName("HELLO LAUNCH")
        }

        delay(1_000L)
        job.start()
    }
}

fun example1() {
    runBlocking {
        printWithThreadName("START")

        launch {
            delay(2_000L) // yield()
            printWithThreadName("LAUNCH END")
        }
    }
    // 여기로 코드가 넘어오지 않는다.
    printWithThreadName("END")
}

fun printWithThreadName(message: String) {
    println("${Thread.currentThread().name}: $message")
}