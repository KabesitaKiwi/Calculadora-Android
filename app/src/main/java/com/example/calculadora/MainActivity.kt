package com.example.calculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    private lateinit var resultado: TextView
    private val calc = Calculadora.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado = findViewById(R.id.resultado)

        val botonesNumeros = listOf(
            R.id.num0, R.id.num1, R.id.num2, R.id.num3,
            R.id.num4, R.id.num5, R.id.num6, R.id.num7, R.id.num8, R.id.num9
        )

        for (id in botonesNumeros) {
            findViewById<Button>(id).setOnClickListener { vista ->
                val numero = (vista as Button).text.toString().toInt()
                calc.annadeNumero(numero)
                resultado.text = calc.getContenido()
            }
        }

        findViewById<Button>(R.id.botonPunto).setOnClickListener {
            calc.annadePunto()
            resultado.text = calc.getContenido()
        }

        findViewById<Button>(R.id.botonSumar).setOnClickListener {
            calc.opera('+')
        }

        findViewById<Button>(R.id.botonRestar).setOnClickListener {
            calc.opera('-')
        }

        findViewById<Button>(R.id.botonMultiplicar).setOnClickListener {
            calc.opera('*')
        }

        findViewById<Button>(R.id.botonDividir).setOnClickListener {
            calc.opera('/')
        }

        // = Botón Igual
        findViewById<Button>(R.id.botonResultado).setOnClickListener {
            calc.igual()
            resultado.text = calc.getContenido()
        }
    }
}