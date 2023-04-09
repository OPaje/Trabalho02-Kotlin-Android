package com.example.trabalho02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.trabalho02.databinding.TelaPostoBinding

class TelaPosto : AppCompatActivity() {

    lateinit var binding: TelaPostoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaPostoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val opcoes = resources.getStringArray(R.array.opcoesCRUD)
        val adaptador = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, opcoes)
        binding.lvOpcoesPosto.adapter = adaptador

    }
}