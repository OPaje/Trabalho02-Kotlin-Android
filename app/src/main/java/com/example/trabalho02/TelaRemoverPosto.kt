package com.example.trabalho02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.trabalho02.databinding.TelaRemoverPostoBinding

class TelaRemoverPosto : AppCompatActivity() {

    lateinit var binding: TelaRemoverPostoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = TelaRemoverPostoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista : ArrayList<PostoDeGasolina> = ArrayList()
        if(intent.hasExtra("333")){
            lista.addAll(intent.getParcelableArrayListExtra("333")!!)
        }

        var cnpj : String = ""

        binding.btnBuscarPosto.setOnClickListener {
            cnpj =  binding.etBuscaPosto.text.toString()
            binding.tvPosto.text = lista.find { it.cnpj == cnpj }.toString()
        }

        binding.btnRemovePosto.setOnClickListener {
            binding.tvPosto.text = ""

            Intent().apply {
                putExtra("888", lista.find { it.cnpj == cnpj })
                setResult(RESULT_OK, this)
            }

            Toast.makeText(applicationContext, "Posto Removido com Sucesso", Toast.LENGTH_SHORT).show()
        }

        binding.btnHomeTelaRemoverPosto.setOnClickListener {
            finish()
        }
    }
}