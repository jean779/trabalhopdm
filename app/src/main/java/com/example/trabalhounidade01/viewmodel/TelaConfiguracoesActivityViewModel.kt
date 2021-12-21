package com.example.trabalhounidade01.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trabalhounidade01.model.Jogo

class TelaConfiguracoesActivityViewModel : ViewModel (){
    var jogo = MutableLiveData<Jogo>()
    var dificuldade = MutableLiveData<Int>()
    var tipoMapa = MutableLiveData<Int>()

    fun mudarTamanhoMapa(i : Int){
        jogo.value!!.setMapaTipo(i)
        tipoMapa.value = 1
    }
    fun mudarDificuldade(i : Int){
        jogo.value!!.setVelocidadeDaCobrinha(i)
        dificuldade.value = i
    }
}