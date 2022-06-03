package com.github.bgrebennikov.services

import com.github.bgrebennikov.controllers.UserController
import com.github.bgrebennikov.data.models.UserModel

class UserControllerImpl : UserController {
    override fun addUser(username: String, password: String): Boolean {
        return true
    }

    override fun getUser(username: String): UserModel {
        return UserModel(
            username,
            "3f2se3f513"
        )
    }
}