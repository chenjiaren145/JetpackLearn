package com.example.jetpack

import android.app.Application
import com.example.jetpack.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application()