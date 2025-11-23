package com.example.agenda.database
import android.util.Log
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper( // Essa classe ela vai criar o banco de dados
    context,
    "tasks",
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """CREATE TABLE IF NOT EXISTS tasks(
    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    numero VARCHAR(100) NOT NULL,
    gmail VARCHAR(100) NOT NULL,
    created DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
    );"""
        try {
            // Executa a consulta SQL
            db?.execSQL(sql)
            // Log de sucesso
            Log.i("info_db", "Banco criado com sucesso")
        } catch (e: Exception) {
            // Log de erro
            Log.i("info_db", "Erro ao criar o banco")
        }
    }

    override fun onUpgrade( // Somente quando ocorre atualizações
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }
}