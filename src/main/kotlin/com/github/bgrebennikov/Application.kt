package com.github.bgrebennikov

import com.github.bgrebennikov.controllers.PostsController
import com.github.bgrebennikov.controllers.UserController
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import com.github.bgrebennikov.plugins.*
import com.github.bgrebennikov.services.PostsControllerImpl
import com.github.bgrebennikov.services.UserControllerImpl
import io.ktor.server.application.*
import org.kodein.di.bind
import org.kodein.di.ktor.di
import org.kodein.di.singleton


fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {

        di {
            bind<UserController> { singleton { UserControllerImpl() } }
            bind<PostsController> { singleton { PostsControllerImpl(this@embeddedServer) } }
        }

        configureRouting()
        configureSerialization()
        configureMonitoring()
    }.start(wait = true)
}
