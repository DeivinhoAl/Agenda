package com.example.agenda.database

import com.example.agenda.model.Task

// Arquivo de interface que vai ter todos os metodos que vamos implementar para a tabela Task
interface ITask {
    fun save(Task : Task) : Boolean
    fun delete(id: Int) : Boolean // Vamos excluir por ID
    fun update(task: Task) : Boolean
    fun list() : List<Task>
}