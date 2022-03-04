package com.example.myapkorgs.ui.dialog

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapkorgs.carregarImagem
import com.example.myapkorgs.databinding.FormularioImagemBinding

class FormularioImagemDialog(private val context: Context) {

    fun mostrar(urlPadrao: String? = null,
                quandoImagemCarregada: (imagem: String) -> Unit) {

        FormularioImagemBinding.inflate(LayoutInflater.from(context)).apply {

            urlPadrao?.let {
               addImagemDialog.carregarImagem(it)
                editUrlImagem.setText(it)
            }

            buttonCarregarImagem.setOnClickListener {

                if (editUrlImagem.text!!.isEmpty()){
                    Toast.makeText(context, "Preencha o campo vazio!", Toast.LENGTH_SHORT).show()
                }else{
                    val url = editUrlImagem.text.toString()

                    //Extensão criada
                    addImagemDialog.carregarImagem(url)

//                    addImagem.load(url){
//                        error(R.drawable.error3edited)
//                    }
                }

            }

            AlertDialog.Builder(context)

                .setView(root)
                .setPositiveButton("Confirmar"){_, _ ->

                    val url = editUrlImagem.text.toString()
                    Log.i("FormularioImagemDialog", "mostra: $url")

                    quandoImagemCarregada(url)

                    // Extenção criada
                    //////binding.edtImage.carregarImagem(url)

//                    binding.edtImage.load(url){
//                        placeholder(R.drawable.error3edited)
//                        error(R.drawable.editedphoto1)
//                    }
                }
                .setNegativeButton("Cancelar"){_, _ ->

                }
                .show()
        }

    }

    //Função de escopo onde chama-se apenas os membros , sem precisar chamar
    //a qualquer momento o binding essa função de escopo se chama (Applay)

    //OBS: Sendo usado o apply apaga a variavel criada formBinding pois não preci
    // sa usar-la mais o applay faz isso no escopo
}