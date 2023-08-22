package com.example.dz2_m6.data.local

import androidx.room.*
import com.example.dz2_m6.data.TaskModel

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_list ORDER BY id DESC")
    fun getList(): List<TaskModel>

    @Insert
    fun addData(taskModel: TaskModel)

    @Delete
    fun deleteData(taskModel: TaskModel)

    @Update
    fun updateData(taskModel: TaskModel)
}