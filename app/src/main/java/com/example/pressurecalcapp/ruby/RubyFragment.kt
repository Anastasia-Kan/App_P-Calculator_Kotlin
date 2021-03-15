package com.example.pressurecalcapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pressurecalcapp.ruby.RubyViewModel
import com.example.pressurecalcapp.databinding.FragmentRubyBinding

class RubyFragment : Fragment() {

    private lateinit var viewModel : RubyViewModel
    private lateinit var binding: FragmentRubyBinding


    private val TAG = "MyDebug"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ruby, container, false)
        viewModel = ViewModelProvider(this).get(RubyViewModel::class.java)
        binding.rubyViewModel = viewModel
        binding.lifecycleOwner = this

        binding.rubyInfo.setOnClickListener {
            Log.i(TAG, "Info button clicked")
            this.findNavController().navigate(R.id.action_rubyFragment_to_infoFragment)
        }

        return binding.root
    }
}


