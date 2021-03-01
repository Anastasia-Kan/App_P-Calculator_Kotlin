package com.example.pressurecalcapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.pressurecalcapp.databinding.FragmentDiamondBinding
import com.example.pressurecalcapp.databinding.FragmentRubyBinding

class DiamondFragment : Fragment() {

    lateinit var bind_dia : FragmentDiamondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind_dia = DataBindingUtil.inflate(inflater, R.layout.fragment_diamond, container, false)
        return bind_dia.root
    }
}