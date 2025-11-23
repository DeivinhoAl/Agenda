package com.example.agenda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.database.TaskDAO
import com.example.agenda.model.Task

class AddContactActivity : AppCompatActivity() {
    private lateinit var btnaddcontact: Button
    private lateinit var editnome: EditText
    private lateinit var editgmail: EditText
    private lateinit var edittelefone: EditText
    fun saveContact(){
        // Inicializando as variáveis com os valores dos campos
        val taskNome = editnome.text.toString()
        val taskGmail = editgmail.text.toString()
        val taskTelefone = edittelefone.text.toString()

        // Criando uma nova tarefa
        val newTask = Task(-1, nome = taskNome, gmail = taskGmail, numero = taskTelefone, created = "")

        // Inicializando o TaskDAO
        val taskDAO = TaskDAO(this) // 'this' passa o contexto da Activity

        // Salvando a tarefa
        if (taskDAO.save(newTask)) {
            Toast.makeText(this, "Tarefa inserida com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Erro ao inserir a tarefa", Toast.LENGTH_SHORT).show()
        }
    }
    private lateinit var btn_delete: ImageButton // Declarando a referência para o botão

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        btn_delete = findViewById(R.id.btn_delete)
        btn_delete.setOnClickListener {
            finish() // O metodo finish encerra e retorna para a Activity que a chamou (MainActivity).
        }

        btnaddcontact = findViewById(R.id.btn_add_contact)
        editnome = findViewById(R.id.editnome)
        editgmail = findViewById(R.id.editgmail)
        edittelefone = findViewById(R.id.edittelefone)

        btnaddcontact.setOnClickListener {
            if (editnome.text.toString().isNotEmpty()) {
                saveContact()
            } else{
                Toast.makeText(this, "Insira o nome", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
