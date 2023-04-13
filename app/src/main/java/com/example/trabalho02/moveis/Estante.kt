package com.example.trabalho02.moveis

class Estante(altura:Double, qtdCompartimentos:Int, codigo:String, material:String, peso:Double, cor:String) :
    Movel(codigo, material, peso, cor) {
        private val altura:Double
        private val qtdCompartimentos:Int

        init {
            this.altura = altura
            this.qtdCompartimentos = qtdCompartimentos
        }

    override fun toString(): String {
        return "Altura = $altura QtdCompartimentos = $qtdCompartimentos"
    }


}