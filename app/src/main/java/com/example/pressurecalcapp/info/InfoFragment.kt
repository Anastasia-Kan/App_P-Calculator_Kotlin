package com.example.pressurecalcapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.pressurecalcapp.databinding.FragmentInfoBinding
import com.example.pressurecalcapp.databinding.FragmentRubyBinding
import com.example.pressurecalcapp.info.InfoViewModel
import com.example.pressurecalcapp.ruby.RubyViewModel


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel : InfoViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        return binding.root
    }
}