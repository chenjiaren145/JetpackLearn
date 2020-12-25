package com.example.jetpack.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.jetpack.R
import com.example.jetpack.TAG
import com.example.jetpack.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.i(TAG, "onCreateView: ")

        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i(TAG, "onViewCreated: ")

        // 传递参示例
        binding.button1.setOnClickListener {
            val navOptions = navOptions { }
            findNavController().navigate(
                R.id.action_homeFragment_to_watermelonFragment,
                Bundle(),
                navOptions
            )
        }
        // 传递参示例
        binding.button2.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToWatermelonFragment()
                .setSize(1)
            findNavController().navigate(action)
        }

        // 不传参数 前往数据库操作页面
        binding.button3.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRoomFragment())
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, "onActivityCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

}