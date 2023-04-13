package com.example.trabalho02.moveis

import kotlinx.parcelize.Parcelize


class Cama(tamanho:String, pesoSuportado:Double, codigo:String, material:String, peso:Double, cor:String) :
    Movel(codigo, material, peso, cor)
{
        private val tamanho:String
        private val pesoSuportado:Double

        init {
            this.tamanho = tamanho
            this.pesoSuportado = pesoSuportado
        }

    override fun toString(): String {
        return " Tamanho = $tamanho Peso Suportado = $pesoSuportado"
    }


}