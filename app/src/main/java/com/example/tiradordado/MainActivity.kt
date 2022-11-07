package com.example.tiradordado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonTirar: Button = findViewById(R.id.button)

        botonTirar.setOnClickListener{
            val toast = Toast.makeText(this, "¡Dado tirado!", Toast.LENGTH_SHORT)
            toast.show()

            rodar()
        }
    }

    private fun rodar() {
        val dado = Dado(6)
        val tirarDado = dado.rodar()

        val resultadoImagen: ImageView = findViewById(R.id.imageView)

        when (tirarDado) {
            1 -> resultadoImagen.setImageResource(R.drawable.lado1)
            2 -> resultadoImagen.setImageResource(R.drawable.lado2)
            3 -> resultadoImagen.setImageResource(R.drawable.lado3)
            4 -> resultadoImagen.setImageResource(R.drawable.lado4)
            5 -> resultadoImagen.setImageResource(R.drawable.lado5)
            else -> resultadoImagen.setImageResource(R.drawable.lado6)
        }
    }
}

class Dado (val numLados: Int) {

    fun rodar(): Int {
        return (1..numLados).random()
    }
}