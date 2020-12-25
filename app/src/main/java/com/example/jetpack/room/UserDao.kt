package com.example.jetpack.room

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE userId = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM USER_TABLE")
    suspend fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // 配置 onConflict=REPLACE 当已存在的时候直接替换调，否则会报错
    suspend fun insertUser(user: User)

    @Insert
    suspend fun insertUsers(user: List<User>)

    @Update // db文件中没有对应主键的数据就不会有任何变化
    suspend fun upDataUser(user: User)

    @Delete
    suspend fun deleteUsers(users: List<User>)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Transaction
    suspend fun deleteAllAndInsertUser(users: List<User>) {
        deleteUsers(getAll())
        insertUsers(users)
    }


}