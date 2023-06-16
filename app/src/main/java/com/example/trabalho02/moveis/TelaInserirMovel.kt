package com.example.trabalho02.moveis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.trabalho02.R
import com.example.trabalho02.databinding.TelaInserirMovelBinding
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.IOException


class TelaInserirMovel : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val caminhoDoArquivo = "My Files"
    private var arquivoExterno: File?=null
    private val armazenamentoExternoSomenteLeitura: Boolean get() {
        var armazSomLeitRet = false
        val armazenamentoExterno = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED_READ_ONLY == armazenamentoExterno) {
            armazSomLeitRet = true
        }
        return (armazSomLeitRet)
    }
    private val armazenamentoExternoDisponivel: Boolean get() {
        var armazExtDispRet = false
        val extStorageState = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED == extStorageState) {
            armazExtDispRet = true
        }
        return(armazExtDispRet)
    }

    lateinit var binding : TelaInserirMovelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaInserirMovelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val opcoesSpinner = resources.getStringArray(R.array.opcoesMoveis)
        val adaptador = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, opcoesSpinner)
        binding.spTipoMoveis.adapter = adaptador

        binding.spTipoMoveis.onItemSelectedListener = this

        binding.btnInserirMovel.setOnClickListener {
            val movel = retornaMovel(binding.spTipoMoveis.selectedItem.toString())
            Log.i("Teste", "${movel.toString()}")

            val texto = "${binding.spTipoMoveis.selectedItem.toString()} ${binding.etCodigoMovel.text.toString()} ${binding.etMaterialMovel.text.toString()}" +
                            "\n${binding.etPesoMovel.text.toString()} ${binding.etCorMovel.text.toString()} ${binding.etAtributo5Movel.text.toString()} " +
                                    "${binding.etAtributo6Movel.text.toString()} "

            arquivoExterno = File(getExternalFilesDir(caminhoDoArquivo), "moveis3.txt")
            try {
                val arquivo = File(caminhoDoArquivo, "moveis3.txt")
                if(arquivo.length() > 0){
                    val arquivoModificado = FileWriter("moveis3.txt", true)
                    arquivoModificado.write(movel.toString())
                    arquivoModificado.flush()
                    arquivoModificado.close()
                }else{
                    val fileOutPutStream = FileOutputStream(arquivoExterno)
                    fileOutPutStream.write(movel.toString().toByteArray())
                    fileOutPutStream.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            Toast.makeText(applicationContext,"Móvel salvo", Toast.LENGTH_SHORT).show()

            binding.etCodigoMovel.text.clear()
            binding.etMaterialMovel.text.clear()
            binding.etCorMovel.text.clear()
            binding.etPesoMovel.text.clear()
            binding.etAtributo5Movel.text.clear()
            binding.etAtributo6Movel.text.clear()
        }

        binding.btnHomeTelaInserirMovel.setOnClickListener {
            finish()
        }

    }

    fun retornaMovel(tipo:String) : Movel{
        var movel = Movel(binding.etCodigoMovel.text.toString(),
            binding.etMaterialMovel.text.toString(), binding.etPesoMovel.text.toString().toDouble(), binding.etCorMovel.text.toString())
        if(tipo == "Cadeira"){
             movel = Cadeira(binding.etAtributo5Movel.text.toString().toInt(), true, binding.etCodigoMovel.text.toString(),
                binding.etMaterialMovel.text.toString(), binding.etPesoMovel.text.toString().toDouble(), binding.etCorMovel.text.toString())
            //return movel
        }else if(tipo == "Cama"){
             movel = Cama(binding.etAtributo5Movel.text.toString(), binding.etAtributo6Movel.text.toString().toDouble(),
                binding.etCodigoMovel.text.toString(), binding.etMaterialMovel.text.toString(), binding.etPesoMovel.text.toString().toDouble(),
                binding.etCorMovel.text.toString())
            //return movel
        }else if(tipo == "Estante"){
            movel = Estante(binding.etAtributo5Movel.text.toString().toDouble(), binding.etAtributo6Movel.text.toString().toInt(),
                binding.etCodigoMovel.text.toString(), binding.etMaterialMovel.text.toString(), binding.etPesoMovel.text.toString().toDouble(),
                binding.etCorMovel.text.toString())
            //return movel
        }
        return movel
    }
    private fun mudaHint(movel: String){
        if(movel == "Cadeira"){
            binding.etAtributo5Movel.hint = "Quantidade de Pernas"
            binding.etAtributo6Movel.setText("Com encosto")

        }
        if(movel == "Cama"){
            binding.etAtributo5Movel.hint = "Tamanho"
            binding.etAtributo6Movel.text.clear()
            binding.etAtributo6Movel.hint = "Peso Suportado"

        }
        if(movel == "Estante"){
            binding.etAtributo5Movel.hint = "Altura"
            binding.etAtributo6Movel.text.clear()
            binding.etAtributo6Movel.hint = "Quantidade de Compartimentos"
        }
    }
    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        // obtém o valor selecionado no spinner
        val valorSelecionado = parent.getItemAtPosition(position).toString()

        mudaHint(valorSelecionado)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}