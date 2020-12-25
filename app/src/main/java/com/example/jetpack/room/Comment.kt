package com.example.jetpack.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment_table")
data class Comment(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "commentId")
    val id: Int = 0,

    val comments: String = ""
)