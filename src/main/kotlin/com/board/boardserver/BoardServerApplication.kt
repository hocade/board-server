package com.board.boardserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class BoardServerApplication

fun main(args: Array<String>) {
    runApplication<BoardServerApplication>(*args)
}
