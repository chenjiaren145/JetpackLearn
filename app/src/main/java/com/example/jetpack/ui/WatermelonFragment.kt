package com.example.jetpack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.navArgs
import com.example.jetpack.databinding.FragmentWatermelonBinding
import com.example.jetpack.model.WatermelonViewModel


class WatermelonFragment : Fragment() {

    // 从navArgs中获取传递的参数
    private val args: WatermelonFragmentArgs by navArgs()

    private lateinit var binding: FragmentWatermelonBinding

    private val viewModel by lazy {
        WatermelonViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWatermelonBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 获取safe arg 传递来的参数
        Toast.makeText(context, args.size.toString(), Toast.LENGTH_SHORT).show()


        viewModel.name.observe(viewLifecycleOwner) {
            // update UI
            binding.textView1.text = it
        }

    }
}