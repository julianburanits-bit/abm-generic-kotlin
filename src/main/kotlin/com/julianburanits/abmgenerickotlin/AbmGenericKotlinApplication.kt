package com.julianburanits.abmgenerickotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AbmGenericKotlinApplication

fun main(args: Array<String>) {
    runApplication<AbmGenericKotlinApplication>(*args)
}
