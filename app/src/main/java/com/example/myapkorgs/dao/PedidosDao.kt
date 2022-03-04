package com.example.myapkorgs.dao

import com.example.myapkorgs.Pedido

class PedidosDao {

    fun adiciona(pedido: Pedido){
        pedidos.add(pedido)
    }

    fun buscarTodos() : List<Pedido>{
        return pedidos.toList()
    }

    companion object{

        private val pedidos = mutableListOf(
            Pedido(
                cliente = "Sávio",
                acabamento = "Fosco",
                cor = "Preto",
                tipo = "Agenda")
        )

    }
}