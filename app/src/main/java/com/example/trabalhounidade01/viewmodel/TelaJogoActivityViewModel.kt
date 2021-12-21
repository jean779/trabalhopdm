package com.example.trabalhounidade01.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trabalhounidade01.model.Jogo

class TelaJogoActivityViewModel : ViewModel() {
    var jogo = MutableLiveData<Jogo>()
}