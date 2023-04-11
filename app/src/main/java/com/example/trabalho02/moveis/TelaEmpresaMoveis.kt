package com.example.trabalho02.moveis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabalho02.databinding.TelaEmpresaMoveisBinding

class TelaEmpresaMoveis : AppCompatActivity() {

    lateinit var binding : TelaEmpresaMoveisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaEmpresaMoveisBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}