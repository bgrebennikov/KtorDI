package com.github.bgrebennikov.plugins

import com.github.bgrebennikov.controllers.PostsController
import com.github.bgrebennikov.controllers.UserController
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI
import org.kodein.di.ktor.di

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/getUser"){


            val users by call.closestDI().instance<UserController>()

            call.respond(
                users.getUser("Test")
            )
        }

        get("/posts"){

            val posts by call.closestDI().instance<PostsController>()

            call.respond(
                posts.getPosts()
            )
        }

    }
}
