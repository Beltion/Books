package com.example.myapplication.reg

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entities.user.RegUser
import com.example.myapplication.repositories.UserRepository
import com.example.myapplication.utils.isEmailValid
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {

    var name: String = ""
    var email: String = ""
    var pass: String = ""

    val regMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val regSuccessEvent:  MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun onSave() {
        if (name.isNotEmpty() && pass.isNotEmpty() && email.isEmailValid()) {
            viewModelScope.launch {
                val u = RegUser(name, email, pass)
                UserRepository().createUser(u)?.let {
                    if (it.accessToken.isNotEmpty()){
                        regSuccessEvent.value = true
                        regMsg.value = it.message
                    } else {
                        regMsg.value = "Не удалось зарегистрировать пользователя"
                    }
                } ?: run {
                    regMsg.value = "Не удалось зарегистрировать пользователя"
                }
            }
        } else {
            regMsg.value ="Данные введены некорректно"
        }
    }

}