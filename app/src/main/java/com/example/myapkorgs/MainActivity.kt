package com.example.myapkorgs
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapkorgs.dao.PedidosDao
import com.example.myapkorgs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = PedidosDao()
        binding.rvMain.adapter = ListaPedidosAdapter(pedidos = dao.buscarTodos())

        binding.rvMain.layoutManager = LinearLayoutManager(this)

        buttonAdc()

    }


    fun buttonAdc(){

        binding.botaoAdd.setOnClickListener {
            startActivity(Intent(this, FormularioActivity::class.java))
        }
    }
}