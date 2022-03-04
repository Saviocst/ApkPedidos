package com.example.myapkorgs
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapkorgs.dao.PedidosDao
import com.example.myapkorgs.databinding.ActivityListaPedidosBinding
import com.example.myapkorgs.ui.activity.FormularioActivity

class ListaPedidosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaPedidosBinding
    private val dao = PedidosDao()
    private val adapter = ListaPedidosAdapter(pedidos = dao.buscarTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityListaPedidosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configuraRecyclerView()
        buttonAdc()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscarTodos())
    }

    fun configuraRecyclerView(){
        //Log.i("MainActivity","onCreate: ${dao.buscarTodos()}")
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = LinearLayoutManager(this)
    }

    fun buttonAdc(){
        binding.botaoAdd.setOnClickListener {
            startActivity(Intent(this, FormularioActivity::class.java))
        }
    }


}