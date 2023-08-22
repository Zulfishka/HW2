package com.example.dz2_m6.ui.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.dz2_m6.R
import com.example.dz2_m6.core.BaseFragment
import com.example.dz2_m6.data.TaskModel
import com.example.dz2_m6.databinding.FragmentFirstBinding
import com.example.dz2_m6.databinding.FragmentSecondBinding
import com.example.dz2_m6.ui.first.FirstFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {

   private val viewModel: SecondViewModel by lazy {
      ViewModelProvider(requireActivity())[SecondViewModel::class.java] }

   override fun inflateViewBinding(): FragmentSecondBinding {
      return FragmentSecondBinding.inflate(layoutInflater)
   }

   override fun initView() {
      binding.btnSave.setOnClickListener {
         val result = TaskModel(
            title = binding.etFirst.text.toString(),
            desc = binding.etSecond.text.toString()
         )
         viewModel.insertData(result)
         requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, FirstFragment()).commit()
      }
   }
}