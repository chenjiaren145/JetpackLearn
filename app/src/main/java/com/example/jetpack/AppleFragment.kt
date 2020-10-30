package com.example.jetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_apple.*

class AppleFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apple, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btOne.setOnClickListener {
            val action = AppleFragmentDirections.actionAppleFragmentToWatermelonFragment()
            findNavController().navigate(action);
        }

        btTwo.setOnClickListener {
            val action = AppleFragmentDirections.actionAppleFragmentToWatermelonFragment().setSize(1)
            findNavController().navigate(action)
        }
    }

}