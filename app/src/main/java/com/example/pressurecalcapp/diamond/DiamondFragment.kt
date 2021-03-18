package com.example.pressurecalcapp.diamond

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pressurecalcapp.FROM_DIAMOND
import com.example.pressurecalcapp.R
import com.example.pressurecalcapp.TAG
import com.example.pressurecalcapp.databinding.FragmentDiamondBinding

class DiamondFragment : Fragment() {

    private lateinit var viewModel : DiamondViewModel
    private lateinit var binding : FragmentDiamondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_diamond, container, false)
        viewModel = ViewModelProvider(this).get(DiamondViewModel::class.java)
        binding.diamondViewModel = viewModel
        binding.lifecycleOwner = this

        Log.i(TAG, "Diamond Fragment created")

        binding.rubyTabBTN.setOnClickListener {
            Log.i(TAG, "Ruby-tab button clicked")
            this.findNavController().navigate(R.id.action_diamondFragment_to_rubyFragment)
        }

        binding.diaInfo.setOnClickListener {
            //var diamondInfoText = infoFromDiamond
            this.findNavController().navigate(
                DiamondFragmentDirections.actionDiamondFragmentToInfoFragment(
                    FROM_DIAMOND
                )
            )

        }
        return binding.root
    }
}