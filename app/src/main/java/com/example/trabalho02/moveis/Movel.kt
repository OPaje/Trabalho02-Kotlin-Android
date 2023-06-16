package com.example.trabalho02.moveis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

open class Movel(codigo:String, material:String, peso:Double, cor:String){

    val codigo : String
    val material : String
    val peso : Double
    val cor : String

    init {
        this.codigo = codigo
        this.material = material
        this.peso = peso
        this.cor = cor
    }

    override fun toString(): String {
        return "Codigo = $codigo Material = $material Peso = $peso \nCor = $cor"
    }


}