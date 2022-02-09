package com.example.myapkorgs
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapkorgs.databinding.ProductItemMainBinding

class ListaPedidosAdapter(private val pedidos: List<Pedido>) : RecyclerView.Adapter<ListaPedidosAdapter.ViewHolderPedidos>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPedidos {

//        val view = LayoutInflater.from(context).inflate(R.layout.product_item_main, parent, false)
//        return ViewHolderPedidos(view)

        // Via Binding
        val binding = ProductItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderPedidos(binding)

    }

    override fun onBindViewHolder(holder: ViewHolderPedidos, position: Int) {
        val itemPedido = pedidos[position]
        holder.vincula(itemPedido)

    }

    override fun getItemCount() = pedidos.size

    class ViewHolderPedidos(private val itemBinding: ProductItemMainBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun vincula(pedido: Pedido){
            itemBinding.textName.text = pedido.cliente
            itemBinding.textBoop.text = pedido.acabamento
            itemBinding.textElastico.text = pedido.cor
        }
    }

}


