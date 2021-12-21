package com.example.trabalhounidade01.model

import java.io.Serializable
import java.util.*

class Jogo : Serializable{
    private var pontuacao:Int = 0
    private var record: Int = 0
    private var mapaTipo:Int = 1
    private var colisao: Boolean = false
    private var cobraCorpo: Queue<IntArray> = LinkedList<IntArray>()
    private var cobraDirecao: Int = 0
    private var velocidadeDaCobrinha:Int = 0



    fun getColisao(): Boolean{
        return colisao
    }
    fun setColisao(colisao: Boolean){
        this.colisao = colisao
    }

    fun getMapaTipo(): Int{
        return mapaTipo
    }

    fun setMapaTipo( mapaTipo: Int){
        this.mapaTipo = mapaTipo
    }

    fun getRecod(): Int {
        return record
    }

    fun setRecord(record: Int){
        this.record = record
    }

    fun getVelocidadeDaCobrinha(): Int {
        return velocidadeDaCobrinha
    }

    fun setVelocidadeDaCobrinha(velocidade:Int){
        if(velocidade == 3){
            setColisao(true)
        }else{
            setColisao(false)
        }
        this.velocidadeDaCobrinha = velocidade
    }

    fun adicionarPontuacao(){
        pontuacao += 5
    }




}