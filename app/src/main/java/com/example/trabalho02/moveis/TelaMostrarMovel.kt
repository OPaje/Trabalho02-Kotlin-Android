package com.example.trabalho02.moveis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.example.trabalho02.databinding.TelaMostrarMovelBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class TelaMostrarMovel : AppCompatActivity() {
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

    lateinit var binding : TelaMostrarMovelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaMostrarMovelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arquivoExterno = File(getExternalFilesDir(caminhoDoArquivo), "moveis3.txt")

        val nomeDoArquivo = "moveis3.txt"
        arquivoExterno = File(getExternalFilesDir(caminhoDoArquivo),nomeDoArquivo)
        if(nomeDoArquivo.trim()!=""){
            val fileInputStream = FileInputStream(arquivoExterno)
            val inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null

            //while ((linha = br.readLine()) != null) - Java
            while ((bufferedReader.readLine().also { text = it }) != null)
            {
                stringBuilder.append(text)
            }
            fileInputStream.close()

            binding.etMoveisArquivo.setText(stringBuilder)

            //Toast.makeText(applicationContext,stringBuilder.toString(), Toast.LENGTH_SHORT).show()

            binding.btnHomeTelaMostrarMovel.setOnClickListener {
                finish()
            }
        }
    }

}
