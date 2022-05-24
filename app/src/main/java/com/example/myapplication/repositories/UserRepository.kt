package com.example.myapplication.repositories

import com.example.myapplication.entities.user.LoginUser
import com.example.myapplication.entities.user.RegUser
import com.example.myapplication.entities.user.SrvAnswerUser
import com.example.myapplication.utils.RetrofitServices

class UserRepository {

    suspend fun createUser(u: RegUser): SrvAnswerUser? {
        return try {
            RetrofitServices.book.registration(u)
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }

    suspend fun login(u: LoginUser): SrvAnswerUser? {
        return try {
            RetrofitServices.book.login(u)
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }

}