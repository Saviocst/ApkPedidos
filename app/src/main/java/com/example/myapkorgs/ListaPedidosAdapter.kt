package com.example.myapkorgs
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.ImageRequest
import com.example.myapkorgs.databinding.ProductItemMainBinding

class ListaPedidosAdapter(pedidos: List<Pedido>) : RecyclerView.Adapter<ListaPedidosAdapter.ViewHolderPedidos>() {

    private val pedidoss = pedidos.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPedidos {

//        val view = LayoutInflater.from(context).inflate(R.layout.product_item_main, parent, false)
//        return ViewHolderPedidos(view)

        // Via Binding
        val binding = ProductItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderPedidos(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderPedidos, position: Int) {
        val itemPedido = pedidoss[position]
        holder.vincula(itemPedido)
    }

    override fun getItemCount() = pedidoss.size

    fun atualiza(pedidos: List<Pedido>) {
        this.pedidoss.clear()
        this.pedidoss.addAll(pedidos)
        notifyDataSetChanged()
    }



    class ViewHolderPedidos(private val itemBinding: ProductItemMainBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun vincula(pedido: Pedido){

            itemBinding.textName.text = pedido.cliente
            itemBinding.textTipo.text = pedido.tipo
            itemBinding.textBoop.text = pedido.acabamento
            itemBinding.textElastico.text = pedido.cor

            // Caso não queira apresentar o conteiner de imagem nulla

//            val visibilidade = if(pedido.imagem != null){
//                View.VISIBLE
//            }
//            else{
//                View.GONE
//            }
//            itemBinding.imgEdit.visibility = visibilidade

            //Extenção criada
            itemBinding.imgEdit.carregarImagem(pedido.imagem)

//            itemBinding.imgEdit.load(pedido.imagem){
//                // Caso não selecione a imagem ela exibirar esse lambda
//                fallback(R.drawable.error3edited)
//                error((R.drawable.error3edited))
//            }


        //itemBinding.imgEdit.load(R.drawable.imageskk)
            //pexels-nataliya-vaitkevich-5982132.jpg
        }

    }

}


