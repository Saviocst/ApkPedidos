package com.example.myapkorgs
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapkorgs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.adapter = ListaPedidosAdapter( listOf(
            Pedido(cliente = "Joana", acabamento = "Fosco", cor = "Rosa"),
            Pedido(cliente = "Raniely", acabamento = "Holografico Caquinho", cor = "Marfim")))

        binding.rvMain.layoutManager = LinearLayoutManager(this)

    }
}