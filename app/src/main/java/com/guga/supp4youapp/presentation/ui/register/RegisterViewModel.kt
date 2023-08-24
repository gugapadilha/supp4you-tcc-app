package com.guga.supp4youapp.presentation.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    // Estado de visibilidade da senha
    private val _visiblePassword = MutableLiveData(true)  // Defina como true
    val visiblePassword: LiveData<Boolean> = _visiblePassword

    private val _senhaRepeticaoVisivel = MutableLiveData(true)  // Defina como true
    val senhaRepeticaoVisivel: LiveData<Boolean> = _senhaRepeticaoVisivel

    fun changeVisibilityPassowrd() {
        _visiblePassword .value = !_visiblePassword .value!!
    }
    fun changeVisibilityPasswordRep() {
        _senhaRepeticaoVisivel.value = !_senhaRepeticaoVisivel.value!!
    }
}
