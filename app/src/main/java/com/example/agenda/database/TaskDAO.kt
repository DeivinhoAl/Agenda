package com.example.agenda.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.agenda.model.Task
// Dentro da camada DAO que fazemos a implementação das coisas que vão se conectar com o banco de Dados.
class TaskDAO(context : Context) : ITask {
    val write = DatabaseHelper(context).writableDatabase // Serve para fazer operações descritas no banco
    val read = DatabaseHelper(context).readableDatabase // Ler registros
    override fun save(Task: Task): Boolean {
        val content = ContentValues()
        content.put("nome",Task.nome)
        content.put("numero",Task.numero)
        content.put("gmail",Task.gmail)

        try {
            write.insert("tasks", null, content) //Precisamos passar os dados por um contents
            Log.i("info_db", "Registro inserido com sucesso")
        } catch (e: Exception) {
            Log.i("info_db", "Erro ao criar registro")
            return false
        }
        return true
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(task: Task): Boolean {
        TODO("Not yet implemented")
    }

    override fun list(): List<Task> {
        val Tasklist = mutableListOf<Task>()
        val sql = "Select * From tasks"
        val cursor = read.rawQuery(sql, null) // rawQuery Manda executar a Query
        while(cursor.moveToNext()){ // Serve para pegar o índice da coluna
            val id = cursor.getInt( cursor.getColumnIndexOrThrow( "id"))
            val nome = cursor.getString( cursor.getColumnIndexOrThrow( "nome"))
            val numero = cursor.getString( cursor.getColumnIndexOrThrow( "numero"))
            val gmail = cursor.getString( cursor.getColumnIndexOrThrow( "gmail"))
            val created = cursor.getString( cursor.getColumnIndexOrThrow( "created"))

            val task = Task(id,nome,numero,gmail,created) // Adiciono novo objeto
            Tasklist.add(task) // Inserindo na lista o objeto
        }
        return Tasklist
    }
}