package com.example.jetpack.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration1_2() : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
       database.execSQL("ALTER TABLE user_table ADD COLUMN last_update INTEGER")
    }
}
class Migration2_3() : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
       database.execSQL("ALTER TABLE user_table ADD COLUMN last_update INTEGER")
    }
}