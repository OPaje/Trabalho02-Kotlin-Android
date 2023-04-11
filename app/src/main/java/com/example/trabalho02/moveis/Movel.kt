package com.example.trabalho02.moveis

open class Movel(codigo:String, material:String, peso:Double, cor:String) {

    private val codigo : String
    private val material : String
    private val peso : Double
    private val cor : String

    init {
        this.codigo = codigo
        this.material = material
        this.peso = peso
        this.cor = cor
    }
}