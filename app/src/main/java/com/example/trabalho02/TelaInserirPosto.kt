package com.example.trabalho02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import com.example.trabalho02.databinding.TelaInserirPostoBinding

class TelaInserirPosto : AppCompatActivity() {
    lateinit var binding: TelaInserirPostoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaInserirPostoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInserirPosto.setOnClickListener {
            val posto : PostoDeGasolina = PostoDeGasolina(binding.etCnpj.text.toString(), binding.etCidade.text.toString(),
                                                            binding.etCaixa.text.toString().toDouble(), binding.etVolume.text.toString().toInt(),
                                                            binding.etQtdFuncionarios.text.toString().toInt())

            Intent().apply {
                putExtra("555", posto as Parcelable)
                setResult(RESULT_OK, this)
            }

            Toast.makeText(applicationContext, "Posto Inserido com Sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}