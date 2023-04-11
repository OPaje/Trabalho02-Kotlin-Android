package com.example.trabalho02.moveis

class Cadeira(qtdPernas:Int, encosto:Boolean, codigo:String, material:String, peso:Double, cor:String) :
    Movel(codigo, material, peso, cor) {

    private val qtdPernas:Int
    private val encosto:Boolean

    init {
        this.qtdPernas = qtdPernas
        this.encosto = encosto
    }
}