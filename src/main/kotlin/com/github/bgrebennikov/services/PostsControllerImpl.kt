package com.github.bgrebennikov.services

import com.github.bgrebennikov.controllers.PostsController
import com.github.bgrebennikov.controllers.UserController
import com.github.bgrebennikov.data.models.PostsModel
import io.ktor.server.application.*
import org.kodein.di.*
import org.kodein.di.ktor.closestDI

class PostsControllerImpl(application: Application): PostsController, DIAware {

    override val di by closestDI { application }
    private val usersController: UserController by instance()

    override fun addPost(fromUser: String, body: String): Boolean {
        return true
    }

    override fun getPosts(): PostsModel {
        return PostsModel(
            usersController.getUser("Edrica Azaza").username,
            "Something post body"
        )
    }


}