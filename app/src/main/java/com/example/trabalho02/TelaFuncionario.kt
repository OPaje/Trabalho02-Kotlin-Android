package com.example.trabalho02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.trabalho02.databinding.TelaFuncionarioBinding


class TelaFuncionario : AppCompatActivity() {

    lateinit var binding : TelaFuncionarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaFuncionarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val funcionarios : MutableList<Funcionarios> = mutableListOf()

        binding.btnCadastrar.setOnClickListener {
        val func = Funcionarios(binding.etSalario.text.toString().toDouble(), binding.etCpfFunc.text.toString(), binding.etNomeFunc.text.toString(),
                                    binding.etFuncaoFunc.text.toString())
            funcionarios.add(func)

            Toast.makeText(this, "Funcionário cadastrado", Toast.LENGTH_SHORT).show()

            var adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, funcionarios)
            binding.lvListaFunc.adapter = adaptador

            binding.etNomeFunc.text.clear()
            binding.etCpfFunc.text.clear()
            binding.etFuncaoFunc.text.clear()

        }

    }
}