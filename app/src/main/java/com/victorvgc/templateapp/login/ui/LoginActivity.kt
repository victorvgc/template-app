package com.victorvgc.templateapp.login.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import com.victorvgc.templateapp.R
import com.victorvgc.templateapp.core.error.UiFailure
import com.victorvgc.templateapp.core.extensions.gone
import com.victorvgc.templateapp.core.extensions.visible
import com.victorvgc.templateapp.core.ui.BaseActivity
import com.victorvgc.templateapp.databinding.ActivityLoginBinding
import com.victorvgc.templateapp.home.ui.HomeActivity
import com.victorvgc.templateapp.login.ui.view_model.LoginState
import com.victorvgc.templateapp.login.ui.view_model.LoginViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginActivity : BaseActivity() {
    override val viewModel: LoginViewModel by viewModels()

    private val binding: ActivityLoginBinding by binding(R.layout.activity_login)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@LoginActivity
        }

        initListeners()
        observeStates()
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            viewModel.doLogin()
        }

        binding.btnLoginRegister.setOnClickListener {
            viewModel.doRegister()
        }

        binding.btnLoginForgotPwd.setOnClickListener {
            viewModel.forgotPassword()
        }
    }

    private fun observeStates() {
        launch {
            viewModel.state.collectLatest {
                when (it) {
                    is LoginState.Failure -> {
                        binding.pbLogin.gone()
                        binding.btnLogin.visible()
                        binding.btnLoginRegister.visible()
                        binding.loginErrorMsg.visible()

                        when(it.failure) {
                            is UiFailure.EmptyResponse ->{}
                            is UiFailure.InvalidForm -> {
                                binding.loginErrorMsg.text = it.failure.displayMsg

                                binding.inputLoginName.error = ""
                                binding.inputLoginUser.error = ""
                                binding.inputLoginPwd.error = ""
                            }
                            is UiFailure.NetworkFailure -> {
                                // display error dialog
                            }
                        }
                    }
                    LoginState.ForgotPassword -> {
                        // start forgot password activity
                    }
                    LoginState.Initial -> {
                        binding.formLogin.gone()
                    }
                    LoginState.Loading -> {
                        binding.btnLogin.gone()
                        binding.btnLoginRegister.gone()
                        binding.pbLogin.visible()

                        Handler(Looper.getMainLooper()).postDelayed({
                            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                        }, 1000)
                    }
                    LoginState.LoginForm -> {
                        binding.formLogin.visible()
                        binding.inputLoginName.gone()
                    }
                    LoginState.RegisterForm -> {
                        binding.formLogin.visible()
                        binding.inputLoginName.visible()
                    }
                    LoginState.Success -> {
                    }
                }
            }
        }
    }
}