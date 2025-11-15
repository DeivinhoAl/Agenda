package com.example.agenda

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnaddcontact : FloatingActionButton //classe terá uma referência privada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edit_nome)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnaddcontact = findViewById(R.id.fab_add_contato) // Capturando o valor
        btnaddcontact.setOnClickListener { // Determinando o que vai acontecer quando eu clicar.
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent) //Intent vai mudar de uma tela para a outra.
        }
    }
}