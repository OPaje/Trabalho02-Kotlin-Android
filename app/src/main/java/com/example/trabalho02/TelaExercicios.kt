package com.example.trabalho02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.trabalho02.databinding.TelaExerciciosBinding

class TelaExercicios : AppCompatActivity() {
    lateinit var binding: TelaExerciciosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaExerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val opcoesExercicios = resources.getStringArray(R.array.opcoesExec)
        val adaptador = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, opcoesExercicios)
        binding.lvOpcoesExercicios.adapter = adaptador

        val vaiParaExec = hashMapOf(
            "Exercício Funcionário" to {startActivity(Intent(applicationContext, TelaFuncionario::class.java))},
            "Exercício Posto" to {startActivity(Intent(applicationContext, TelaPosto::class.java))}
        )

        binding.lvOpcoesExercicios.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val textoSelecionado = parent.getItemAtPosition(position)
            vaiParaExec[textoSelecionado]?.invoke()
        }
    }
}