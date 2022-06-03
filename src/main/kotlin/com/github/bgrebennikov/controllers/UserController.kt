package com.github.bgrebennikov.controllers

import com.github.bgrebennikov.data.models.UserModel

interface UserController {

    fun addUser(username: String, password: String) : Boolean

    fun getUser(username: String) : UserModel

}