package com.example.myapkorgs.dao

import com.example.myapkorgs.Pedido

class PedidosDao {

private val pedidos = mutableListOf<Pedido>()

    fun adiciona(pedido: Pedido){
        pedidos.add(pedido)
    }

    fun buscarTodos() : List<Pedido>{
        return pedidos.toList()
    }
}