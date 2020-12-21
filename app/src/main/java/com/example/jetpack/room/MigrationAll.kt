package com.example.jetpack.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MigrationAll(startVersion: Int, endVersion: Int) : Migration(startVersion, endVersion) {
    override fun migrate(database: SupportSQLiteDatabase) {
       database.execSQL("ALTER TABLE user_table ADD COLUMN last_update INTEGER")
    }
}