package com.example.trabalho02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.trabalho02.databinding.TelaAtualizaPostoBinding

class TelaAtualizaPosto : AppCompatActivity() {

    lateinit var binding: TelaAtualizaPostoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaAtualizaPostoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista : ArrayList<PostoDeGasolina> = ArrayList()
        val funcoes = TelaPosto()
        var cod = 0

        if(intent.hasExtra("222")){
            lista.addAll(intent.getParcelableArrayListExtra("222")!!)
            val adaptador = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, lista)
            binding.lvTelaAtualizar.adapter = adaptador
        }

        binding.lvTelaAtualizar.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as PostoDeGasolina
            cod = lista.indexOfFirst { it.cnpj == item.cnpj }
        }

        binding.btnAtualiza.setOnClickListener {
            val posto = PostoDeGasolina(lista[cod].cnpj, lista[cod].cidade,
                binding.etCaixaTelaAtualizar.text.toString().toDouble(), binding.etVolumeTelaAtualizar.text.toString().toInt(),
                binding.etQtdFuncTelaAtualizar.text.toString().toInt())

            Intent().apply {
                putExtra("444", posto as Parcelable)
                setResult(RESULT_OK, this)
            }

            binding.etCaixaTelaAtualizar.text.clear()
            binding.etVolumeTelaAtualizar.text.clear()
            binding.etQtdFuncTelaAtualizar.text.clear()

            Toast.makeText(applicationContext, getString(R.string.posto_atualizado), Toast.LENGTH_SHORT).show()
        }

        binding.btnHomeTelaAtualizar.setOnClickListener {
            finish()
        }
    }
}