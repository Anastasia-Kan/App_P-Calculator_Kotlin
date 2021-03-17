package com.example.pressurecalcapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.pressurecalcapp.databinding.FragmentInfoBinding
import com.example.pressurecalcapp.databinding.FragmentRubyBinding
import com.example.pressurecalcapp.info.InfoViewModel
import com.example.pressurecalcapp.ruby.RubyViewModel


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel : InfoViewModel
    var diamondFragment = DiamondFragment()

    lateinit var infoText : String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        viewModel = ViewModelProvider(this).get(InfoViewModel::class.java)
        binding.infoViewModel = viewModel
        binding.lifecycleOwner = this

        infoText = "Empty"


        binding.infoTV.setText(infoText)
        //binding.infoViewModel?.infoText = resources.getString(R.string.info_ruby)

        return binding.root
    }
}