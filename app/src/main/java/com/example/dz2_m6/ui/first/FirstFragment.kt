package com.example.dz2_m6.ui.first

import android.app.AlertDialog
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
import com.example.dz2_m6.ui.second.SecondFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {

    private lateinit var adapter: TaskAdapter
    private lateinit var viewModel: FirstViewModel

    override fun inflateViewBinding(): FragmentFirstBinding {
        return FragmentFirstBinding.inflate(layoutInflater)
    }

    override fun initView() {
        adapter = TaskAdapter(this::deleteClick, this::onClick, this::onClickOnCheckBox)
        binding.recyclerView.adapter = adapter
        viewModel = ViewModelProvider(requireActivity())[FirstViewModel::class.java]
        setData()
        binding.btnFab.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment()).commit()
        }
    }

    private fun onClickOnCheckBox(taskModel: TaskModel) {
        viewModel.updateData(taskModel)
        setData()
    }

    private fun setData() {
        val list = viewModel.getData()
        for (task in list) {
            if (task.check == true) {
                adapter.addTrueCheckBox(task)
            }
        }
        adapter.addData(list)
    }

    private fun onClick(taskModel: TaskModel) {
        setData()
    }

    private fun deleteClick(taskModel: TaskModel) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete?")
        builder.setMessage("Delete sure")
        builder.setPositiveButton("Delete") { d, _ ->
            viewModel.deleteData(taskModel)
            setData()
            d.dismiss()
        }
        builder.setNegativeButton("No") { d, _ ->
            d.dismiss()
        }
        builder.create().show()
    }
}