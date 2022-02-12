package com.example.myapkorgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapkorgs.dao.PedidosDao
import com.example.myapkorgs.databinding.ActivityFormularioBinding
import kotlin.math.log

class FormularioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_formulario)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adicionar()


    }

    fun adicionar(){
        binding.btnAdicionar.setOnClickListener {

            if (!validacao()){
                Toast.makeText(this, R.string.message_error, Toast.LENGTH_LONG).show()
            }

            val nome = binding.edtName.text.toString()
            val tipo = binding.edtTipo.text.toString()
            val acabamento = binding.edtAcabamento.text.toString()
            val cor = binding.edtCor.text.toString()

            val teste = Pedido(
                cliente = nome,
                tipo = tipo,
                acabamento = acabamento,
                cor = cor)

            Log.i("Teste", "onCreate: $teste")

            val dao = PedidosDao()
            dao.adiciona(teste)

            Log.i("Teste", "onCreate: ${dao.buscarTodos()}")


        }
    }

    fun validacao():Boolean {
        return (binding.edtName.text.isNotEmpty() &&
                binding.edtTipo.text.isNotEmpty() &&
                binding.edtAcabamento.text.isNotEmpty() &&
                binding.edtCor.text.isNotEmpty())
    }
}