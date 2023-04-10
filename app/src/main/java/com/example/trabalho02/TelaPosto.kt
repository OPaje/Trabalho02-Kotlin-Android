package com.example.trabalho02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.trabalho02.databinding.TelaPostoBinding
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

        val registerAtualiza = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){result : ActivityResult ->
            if (result.resultCode == RESULT_OK){
                result.data?.let {
                    if(it.hasExtra("444")){
                        val posto : PostoDeGasolina = it.getParcelableExtra("444")!!
                        val indice = listaPosto.indexOfFirst { it.cnpj == posto.cnpj }
                        listaPosto.set(indice, posto)
                    }
                }
            }
        }

        fun postosAbaixo1000L(lista : ArrayList<PostoDeGasolina>) : ArrayList<PostoDeGasolina>{
            val abaixo : ArrayList<PostoDeGasolina> = ArrayList()
            for (posto in lista){
                if(posto.volumeArmazenado < 1000){
                    abaixo.add(posto)
                }
            }

            return abaixo
        }

        val opcoes = hashMapOf(
            "Inserir Posto" to {register.launch(Intent(applicationContext, TelaInserirPosto::class.java))},

            "Mostrar Postos" to {startActivity(Intent(applicationContext, TelaMostraPosto::class.java).apply {
                putParcelableArrayListExtra("777", listaPosto)})},

            "Atualizar Posto" to {registerAtualiza.launch(Intent(applicationContext, TelaAtualizaPosto::class.java).apply {
                putParcelableArrayListExtra("222", listaPosto) })},

            "Mostrar Caixa Total" to {
                val totalCaixa : Double = listaPosto.sumOf { it.caixa }
                Toast.makeText(applicationContext, "Caixa Total R$$totalCaixa", Toast.LENGTH_SHORT).show()
            },
            "Mostrar Postos Abaixo de 1000L" to {
                val postos = postosAbaixo1000L(listaPosto)
                val adaptadorVolume = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, postos)
                binding.lvPostosVolumeAbaixo.adapter = adaptadorVolume
            }
        )

        binding.lvOpcoesPosto.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val itemSelecionado = parent.getItemAtPosition(position)
            opcoes[itemSelecionado]?.invoke()
        }


    }
}