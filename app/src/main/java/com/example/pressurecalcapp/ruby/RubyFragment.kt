package com.example.pressurecalcapp.ruby

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pressurecalcapp.FROM_RUBY
import com.example.pressurecalcapp.R
import com.example.pressurecalcapp.TAG
import com.example.pressurecalcapp.databinding.FragmentRubyBinding

class RubyFragment : Fragment() {

    private lateinit var viewModel : RubyViewModel
    private lateinit var binding: FragmentRubyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ruby, container, false)
        viewModel = ViewModelProvider(this).get(RubyViewModel::class.java)
        binding.rubyViewModel = viewModel
        binding.lifecycleOwner = this

        Log.i(TAG, "Ruby Fragment created")

        binding.diamondTabBTN.setOnClickListener {
            Log.i(TAG, "diamondTab clicked")
            this.findNavController().navigate(R.id.action_rubyFragment_to_diamondFragment)
            //TODO: save local var Tab-state
        }

        binding.rubyInfo.setOnClickListener {
            this.findNavController().navigate(
                RubyFragmentDirections.actionRubyFragmentToInfoFragment(
                    FROM_RUBY
                )
            )
        }
        return binding.root
    }
}


