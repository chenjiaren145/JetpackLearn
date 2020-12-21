package com.example.jetpack.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId") // 修改列的名称
    val id: Int = 0,

    val name: String = "",
    val age: Int = 0,
)