package com.github.bgrebennikov.controllers

import com.github.bgrebennikov.data.models.PostsModel

interface PostsController {

    fun addPost(fromUser: String, body: String) : Boolean

    fun getPosts() : PostsModel

}