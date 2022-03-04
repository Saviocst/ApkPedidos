package com.example.myapkorgs

import android.widget.ImageView
import coil.load


fun ImageView.carregarImagem(url: String? = null){
    load(url){
        fallback(R.drawable.error3edited)
        error(R.drawable.error3edited)
        placeholder(R.drawable.editedphoto1)
    }

}