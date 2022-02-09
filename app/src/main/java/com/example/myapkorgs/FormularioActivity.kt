package com.example.myapkorgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapkorgs.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_formulario)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}