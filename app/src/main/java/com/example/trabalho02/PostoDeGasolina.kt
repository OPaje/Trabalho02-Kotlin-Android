package com.example.trabalho02

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostoDeGasolina(
    val cnpj:String,
    val cidade:String,
    val caixa:Double,
    val volumeArmazenado:Int,
    val qtdFuncionarios:Int
): Parcelable


