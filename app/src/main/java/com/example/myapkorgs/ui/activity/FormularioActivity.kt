package com.example.myapkorgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapkorgs.Pedido
import com.example.myapkorgs.R
import com.example.myapkorgs.carregarImagem
import com.example.myapkorgs.dao.PedidosDao
import com.example.myapkorgs.databinding.ActivityFormularioBinding
import com.example.myapkorgs.ui.dialog.FormularioImagemDialog

class FormularioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioBinding
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_formulario)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adicionar()
        dialogBox()
    }

    fun adicionar(){

        binding.btnAdicionar.setOnClickListener {

            if (!validacao()){
                Toast.makeText(this, R.string.message_error, Toast.LENGTH_LONG).show()
            }else{
                val nome = binding.edtName.text.toString()
                val tipo = binding.edtTipo.text.toString()
                val acabamento = binding.edtAcabamento.text.toString()
                val cor = binding.edtCor.text.toString()

                val teste = Pedido(
                    cliente = nome,
                    tipo = tipo,
                    acabamento = acabamento,
                    cor = cor,
                    imagem = url)

//                Log.i("Teste", "onCreate: $teste")

                val dao = PedidosDao()
                dao.adiciona(teste)

//                Log.i("Teste", "onCreate: ${dao.buscarTodos()}")
                Toast.makeText(this, R.string.message_ok, Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    fun dialogBox(){
        binding.edtImageFormulario.setOnClickListener {
            FormularioImagemDialog(this).mostrar(url){ imagem ->
                url = imagem
                binding.edtImageFormulario.carregarImagem(url)
            }
        }
    }

    fun validacao():Boolean {
        return (binding.edtName.text!!.isNotEmpty() &&
                binding.edtTipo.text!!.isNotEmpty() &&
                binding.edtAcabamento.text!!.isNotEmpty() &&
                binding.edtCor.text!!.isNotEmpty())
    }


}