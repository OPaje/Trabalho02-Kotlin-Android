package com.example.trabalho02.moveis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.trabalho02.R
import com.example.trabalho02.databinding.TelaEmpresaMoveisBinding

class TelaEmpresaMoveis : AppCompatActivity() {

    lateinit var binding: TelaEmpresaMoveisBinding
    val listaMoveis: ArrayList<Movel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaEmpresaMoveisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val opcoesCrud = resources.getStringArray(R.array.opcoes_crud_movel)
        val adaptador =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, opcoesCrud)
        binding.lvOpcoesCrudMovel.adapter = adaptador

        val register = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                result.data?.let {
                    if (it.hasExtra("555")) {
                        val movel: Movel = it.getParcelableExtra("555")!!
                        listaMoveis.add(movel)
                    }
                }
            }
        }

        val opcoes = hashMapOf(
            "Inserir Móveis" to {register.launch(Intent(applicationContext, TelaInserirMovel::class.java))}
        )
    }
}