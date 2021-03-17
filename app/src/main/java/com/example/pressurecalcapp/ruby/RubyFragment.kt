package com.example.pressurecalcapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pressurecalcapp.ruby.RubyViewModel
import com.example.pressurecalcapp.databinding.FragmentRubyBinding
import com.example.pressurecalcapp.info.InfoViewModel

class RubyFragment : Fragment() {

    private lateinit var viewModel : RubyViewModel
    private lateinit var binding: FragmentRubyBinding
    //private lateinit var infoViewModel: InfoViewModel
    //var infoFragment = InfoFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ruby, container, false)
        viewModel = ViewModelProvider(this).get(RubyViewModel::class.java)
        binding.rubyViewModel = viewModel
        binding.lifecycleOwner = this

        //infoViewModel = ViewModelProvider(this).get(InfoViewModel::class.java)

        Log.i(TAG, "Ruby Fragment created")

        binding.diamondTabBTN.setOnClickListener {
            Log.i(TAG, "diamondTab clicked")
            this.findNavController().navigate(R.id.action_rubyFragment_to_diamondFragment)
            //TODO: save local var Tab-state
        }

        binding.rubyInfo.setOnClickListener {
            var rubyInfoText = resources.getString(R.string.info_ruby)
            //infoViewModel.infoText = resources.getString(R.string.info_ruby)
            //infoViewModel.setInfoText()
            //infoFragment.infoText = resources.getString(R.string.info_ruby)
            this.findNavController().navigate(R.id.action_rubyFragment_to_infoFragment)
            Log.i(TAG, "Info button clicked, infoText = $rubyInfoText")
        }
        return binding.root
    }
}


