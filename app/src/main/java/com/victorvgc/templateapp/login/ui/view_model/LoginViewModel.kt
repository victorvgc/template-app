package com.victorvgc.templateapp.login.ui.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.victorvgc.templateapp.core.ui.view_model.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : BaseViewModel() {

    val name = MutableLiveData("")
    val username = MutableLiveData("")
    val password = MutableLiveData("")

    private val _state = MutableStateFlow<LoginState>(LoginState.Initial)
    val state: StateFlow<LoginState> = _state

    private var isLoginForm: Boolean = false
    private var isRegisterForm: Boolean = false

    fun doLogin() {
        if (isLoginForm) {
            _state.tryEmit(LoginState.Loading)

            // do login logic
        } else {
            isLoginForm = true
            isRegisterForm = false

            _state.tryEmit(LoginState.LoginForm)
        }
    }

    fun doRegister() {
        if (isRegisterForm) {
            _state.tryEmit(LoginState.Loading)

            // do register logic
        } else {
            isLoginForm = false
            isRegisterForm = true

            _state.tryEmit(LoginState.RegisterForm)
        }
    }

    fun forgotPassword() {
        _state.tryEmit(LoginState.ForgotPassword)
    }
}