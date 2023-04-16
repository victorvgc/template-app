package com.victorvgc.templateapp.login.ui.view_model

import com.victorvgc.templateapp.core.error.UiFailure
import java.lang.Exception

sealed class LoginState {
    object Initial: LoginState()
    object Loading : LoginState()
    object LoginForm: LoginState()
    object RegisterForm: LoginState()
    object ForgotPassword: LoginState()
    object Success: LoginState()
    class Failure(val failure: UiFailure, val error: Exception? = null): LoginState()
}