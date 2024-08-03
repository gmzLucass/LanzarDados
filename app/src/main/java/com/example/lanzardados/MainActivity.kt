package com.example.lanzardados

import android.media.Image
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLanzar: Button = findViewById(R.id.btnLanzar)

        btnLanzar.setOnClickListener{
            tiempo()
        }
        rollDice()
    }
    private fun rollDice(){
        var numero: Int = lanzar(6)
        val txtResult: TextView = findViewById(R.id.txtResultado)
        txtResult.text = numero.toString()

        val drawableResource = when(numero){
            1 -> R.drawable._1
            2 -> R.drawable._2
            3 -> R.drawable._3
            4 -> R.drawable._4
            5 -> R.drawable._5
            else -> R.drawable._6

        }
        val imgDado: ImageView = findViewById(R.id.imgDado)
        imgDado.setImageResource(drawableResource)

      //Toast.makeText(this, numero.toString(), Toast.LENGHT_LONG).show()
    }
    private fun lanzar(max: Int): Int {
      return (1..max).random()
    }

    private fun tiempo() {
        object : CountDownTimer(1500, 25){
            override fun onTick(p0: Long) {
             rollDice()
         }

         override fun onFinish() {

         }

        }.start()

    }
}


