package com.example.jetpack.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.jetpack.R
import com.example.jetpack.databinding.MainActivityBinding
import androidx.databinding.DataBindingUtil.setContentView
import com.example.jetpack.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<MainActivityBinding>(this, R.layout.main_activity)

        Log.i(TAG, "onCreate: ")
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)

        Log.i(TAG, "onCreateView: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
        
    }


    override fun onRestart() {
        super.onRestart()

        Log.i(TAG, "onRestart: ")
    }
    
    
    
}