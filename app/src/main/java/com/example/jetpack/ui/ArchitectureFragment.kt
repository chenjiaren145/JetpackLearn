package com.example.jetpack.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.jetpack.R
import com.example.jetpack.TAG
import com.example.jetpack.databinding.ArchitectureFragmentBinding
import com.example.jetpack.viewmodel.ArchitectureViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArchitectureFragment : Fragment() {


    private val architectureViewModel: ArchitectureViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.i(TAG, "onCreateView: ")

        val binding = DataBindingUtil.inflate<ArchitectureFragmentBinding>(
            layoutInflater,
            R.layout.architecture_fragment,
            container,
            false
        ).apply {
            // Specify the current activity as the lifecycle owner.
            lifecycleOwner = this@ArchitectureFragment
            // Assign the component to a property in the binding class.
            viewModel = architectureViewModel
            callBack = object : CallBack {
                override fun save() {
//                    architectureViewModel.userName.value = editTextTextMultiLine.text.toString()
                    architectureViewModel.saveComment(editTextTextMultiLine.text.toString())
                }
            }
        }.also {
//            subscribeUi(it)
        }


        return binding.root
    }

    private fun subscribeUi(binding: ArchitectureFragmentBinding) {
        architectureViewModel.comment?.observe(viewLifecycleOwner) {
            binding.textView2.text = it?.comments ?: "没有"
        }
    }

    interface CallBack {
        fun save()
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