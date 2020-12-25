package com.example.jetpack.data

import android.util.Log
import com.example.jetpack.room.Comment
import com.example.jetpack.room.CommentDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArchitectureRepository @Inject constructor(private val commentDao: CommentDao) {


    suspend fun saveComment(comment: Comment) {
        commentDao.insertComment(comment)
    }


    fun getCommentById(id: Int): Flow<Comment>? {
        return commentDao.getCommentById(id)
    }

}