package com.example.dz2_m6.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "task_list")
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String?= null,
    val desc: String? = null,
    val check: Boolean? = false
) : Serializable