package com.example.myapplication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entities.user.LoginUser
import com.example.myapplication.entities.user.RegUser
import com.example.myapplication.repositories.UserRepository
import com.example.myapplication.utils.isEmailValid
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var email: String = ""
    var pass: String = ""

    val loginMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val loginSuccessEvent: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun onLogin(){
        if (pass.isNotEmpty() && email.isEmailValid()) {
            viewModelScope.launch {
                val u = LoginUser(email, pass)
                UserRepository().login(u)?.let {
                    if (it.accessToken.isNotEmpty()){
                        loginSuccessEvent.value = true
                        loginMsg.value = it.message
                    } else {
                        loginMsg.value = "Не удалось авторизоваться"
                    }
                } ?: run {
                    loginMsg.value = "Не удалось авторизоваться"
                }
            }
        } else {
            loginMsg.value ="Данные введены некорректно"
        }

    }
}