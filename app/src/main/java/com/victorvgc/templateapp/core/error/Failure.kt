package com.victorvgc.templateapp.core.error

import java.lang.Exception

sealed class UiFailure(val displayMsg: String, val exception: Exception? = null) {
    class NetworkFailure(val msg: String, val error: Exception? = null): UiFailure(msg, error)
    class InvalidForm(val msg: String, val error: Exception? = null): UiFailure(msg, error)
    class EmptyResponse(val msg: String, val error: Exception? = null): UiFailure(msg, error)
}