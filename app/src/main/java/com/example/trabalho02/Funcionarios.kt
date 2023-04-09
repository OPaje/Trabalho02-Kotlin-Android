package com.example.trabalho02

import android.widget.EditText

class Funcionarios(salario: Double, cpf: String, nome: String, funcao: String){
    var salario : Double = 0.0
    val cpf: String
    val nome : String
    var funcao : String

    init {
        this.salario = salario
        this.cpf = cpf
        this.nome = nome
        this.funcao = funcao
    }
    /*constructor(salario: Double, cpf: String, nome: String, funcao: String) {
        this.salario = salario
        this.cpf = cpf
        this.nome = nome
        this.funcao = funcao
    }*/

    override fun toString(): String {
        return "Salario: $salario cpf=${cpf} nome=${this.nome}, funcao=${funcao})"
    }

}