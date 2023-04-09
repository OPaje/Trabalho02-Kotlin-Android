package com.example.trabalho02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.trabalho02.databinding.TelaMostraPostoBinding

class TelaMostraPosto : AppCompatActivity() {
    lateinit var binding : TelaMostraPostoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaMostraPostoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("777")){
            val lista : ArrayList<PostoDeGasolina> = intent.getParcelableArrayListExtra("777")!!
            val adaptador = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, lista)
            binding.lvMostraPostos.adapter = adaptador

        }

        binding.btnHomeTelaMostrarPosto.setOnClickListener {
            finish()
        }

    }
}