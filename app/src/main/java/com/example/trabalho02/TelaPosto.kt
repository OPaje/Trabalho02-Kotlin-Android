package com.example.trabalho02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.trabalho02.databinding.TelaPostoBinding
import javax.sql.ConnectionPoolDataSource

class TelaPosto : AppCompatActivity() {

    lateinit var binding: TelaPostoBinding
    val listaPosto : ArrayList<PostoDeGasolina> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaPostoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textoOpcoes = resources.getStringArray(R.array.opcoesCRUD)
        val adaptador = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, textoOpcoes)
        binding.lvOpcoesPosto.adapter = adaptador

        val register = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){result: ActivityResult ->
            if(result.resultCode == RESULT_OK){
                result.data?.let{
                    if(it.hasExtra("555")){
                        val posto : PostoDeGasolina = it.getParcelableExtra("555")!!
                        listaPosto.add(posto)
                    }
                }
            }

        }

        val opcoes = hashMapOf(
            "Inserir Posto" to {register.launch(Intent(applicationContext, TelaInserirPosto::class.java))},
            "Mostrar Postos" to {startActivity(Intent(applicationContext, TelaMostraPosto::class.java).apply { putParcelableArrayListExtra("777", listaPosto)})}
        )

        binding.lvOpcoesPosto.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val itemSelecionado = parent.getItemAtPosition(position)
            opcoes[itemSelecionado]?.invoke()
        }

    }
}