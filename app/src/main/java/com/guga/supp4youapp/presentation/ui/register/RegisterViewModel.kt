package com.guga.supp4youapp.presentation.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _visiblePassword = MutableLiveData(true)
    val visiblePassword: LiveData<Boolean> = _visiblePassword

    private val _passwordRepetition = MutableLiveData(true)
    val passwordRepetition: LiveData<Boolean> = _passwordRepetition

    fun changeVisibilityPassowrd() {
        _visiblePassword .value = !_visiblePassword .value!!
    }
    fun changeVisibilityPasswordRep() {
        _passwordRepetition.value = !_passwordRepetition.value!!
    }
}
