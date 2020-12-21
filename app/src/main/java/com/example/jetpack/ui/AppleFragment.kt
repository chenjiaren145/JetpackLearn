package com.example.jetpack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.jetpack.R
import com.example.jetpack.databinding.FragmentAppleBinding

class AppleFragment : Fragment() {

    private lateinit var binding: FragmentAppleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAppleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 传递参示例
        binding.button1.setOnClickListener {
            val navOptions = navOptions { }
            findNavController().navigate(
                R.id.action_appleFragment_to_watermelonFragment,
                Bundle(),
                navOptions
            )
        }
        // 传递参示例
        binding.button2.setOnClickListener {
            val action = AppleFragmentDirections.actionAppleFragmentToWatermelonFragment()
                .setSize(1)
            findNavController().navigate(action)
        }

        // 不传参数 前往数据库操作页面
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_appleFragment_to_bananaFragment)
        }



    }

}