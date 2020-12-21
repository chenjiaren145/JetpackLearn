package com.example.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
//@TypeConverters 有非基本类型数据的时候需要添加转换器，转化成基本类型
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    // 线程安全的懒汉式  Tip 这里不能私有化构造
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, AppDatabase::class.java, "Sample.db"
            )
                // .addMigrations(MigrationAll(1, 2)) // 自定义数据库升级迁移规则
                .fallbackToDestructiveMigration()   // 可选的迁移规则 所有表都会被丢弃，同时 identity_hash 被插入
                .build()

        // TODO: 2020/12/16 测试下迁移 identity_hash 的变化，identity_hash是什么！！默认其他迁移规则学习！！
    }

}