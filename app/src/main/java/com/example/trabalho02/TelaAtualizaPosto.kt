package com.example.trabalho02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabalho02.databinding.TelaAtualizaPostoBinding
import com.example.trabalho02.databinding.TelaMostraPostoBinding

class TelaAtualizaPosto : AppCompatActivity() {

    lateinit var binding: TelaAtualizaPostoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaAtualizaPostoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}