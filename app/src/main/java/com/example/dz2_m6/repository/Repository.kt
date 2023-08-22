package com.example.dz2_m6.repository

import com.example.dz2_m6.data.TaskModel
import com.example.dz2_m6.data.local.TaskDao
import javax.inject.Inject

class Repository @Inject constructor(private val dao: TaskDao) {

    fun insert(taskModel: TaskModel) {
        dao.addData(taskModel)
    }

    fun getData(): List<TaskModel> {
        return dao.getList()
    }

    fun deleteData(taskModel: TaskModel) {
        dao.deleteData(taskModel)
    }

    //    fun updateData(taskModel: TaskModel){
//        dao.updateData(taskModel)
//    }
    fun updateData(taskModel: TaskModel) {
        dao.updateData(taskModel)
    }

}