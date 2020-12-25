package com.example.jetpack.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {

    @Query("SELECT  * FROM comment_table WHERE commentId = :id")
    fun getCommentById(id: Int): Flow<Comment>?

    @Insert(onConflict = OnConflictStrategy.REPLACE) // 配置 onConflict=REPLACE 当已存在的时候直接替换调，否则会报错
    suspend fun insertComment(comment: Comment)

}