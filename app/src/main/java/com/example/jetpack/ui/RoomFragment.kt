package com.example.jetpack.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.jetpack.TAG
import com.example.jetpack.databinding.RoomFragmentBinding
import com.example.jetpack.room.AppDatabase
import com.example.jetpack.room.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RoomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RoomFragment : Fragment() {

    private lateinit var binding: RoomFragmentBinding

    private val appDatabase by lazy {
        AppDatabase.getInstance(requireActivity())
    }

    init {
        lifecycleScope.launchWhenCreated {
            withContext(Dispatchers.IO) {
                Log.i("RoomFragment", "${Thread.currentThread()}")
            }
            Log.i("RoomFragment", "${Thread.currentThread()}")
        }
    }


    /** 随机年龄 */
    private val age: Int
        get() {
            return (10..20).random()
        }

    /** 随机名称 */
    private val names = listOf("张三", "李四", "王五")
    private val name: String
        get() {
            return names[(0..2).random()]
        }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        Log.i(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(TAG, "onCreateView: ")

        binding = RoomFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i(TAG, "onViewCreated: ")

        binding.btInsert.setOnClickListener {
            lifecycleScope.launch {
                appDatabase.userDao().insertUser(
                    User(name = name, age = age)
                )
            }
        }

        binding.btDelete.setOnClickListener {
            lifecycleScope.launch {
                appDatabase.userDao()
                    .deleteUsers(listOf(User(id = 1, name = "张三", age = 8)))
            }
        }

        binding.btReset.setOnClickListener {
            lifecycleScope.launch {
                appDatabase.userDao()
                    .deleteAllAndInsertUser(listOf(User(id = 1, name = "张三", age = 8)))
            }
        }

        binding.btOther.setOnClickListener {
            val action = RoomFragmentDirections.actionRoomFragmentToArchitectureFragment()
            findNavController().navigate(action)
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = RoomFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}