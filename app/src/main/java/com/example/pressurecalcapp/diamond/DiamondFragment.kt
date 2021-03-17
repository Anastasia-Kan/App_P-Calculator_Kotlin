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
import com.example.pressurecalcapp.databinding.FragmentDiamondBinding
import com.example.pressurecalcapp.databinding.FragmentInfoBinding
import com.example.pressurecalcapp.diamond.DiamondViewModel
import com.example.pressurecalcapp.info.InfoViewModel

class DiamondFragment : Fragment() {

    private lateinit var viewModel : DiamondViewModel
    private lateinit var binding : FragmentDiamondBinding
    //private lateinit var infoViewModel: InfoViewModel
    //private lateinit var infoBinding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_diamond, container, false)
        viewModel = ViewModelProvider(this).get(DiamondViewModel::class.java)
        binding.diamondViewModel = viewModel
        binding.lifecycleOwner = this

        //infoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        //infoBinding.infoViewModel = infoViewModel
        //infoBinding.lifecycleOwner = this

        //infoViewModel = ViewModelProvider(this).get(InfoViewModel::class.java)

        Log.i(TAG, "Diamond Fragment created")

        binding.rubyTabBTN.setOnClickListener {
            Log.i(TAG, "Ruby-tab button clicked")
            this.findNavController().navigate(R.id.action_diamondFragment_to_rubyFragment)
        }

        binding.diaInfo.setOnClickListener { // App crashes on click
            var diamondInfoText = resources.getString(R.string.info_diamond)
            //infoBinding.infoTV.setText(diamondInfoText)
            //infoViewModel.infoText = resources.getString(R.string.info_diamond)
            //infoViewModel.setInfoText()
            this.findNavController().navigate(R.id.action_diamondFragment_to_infoFragment)
            Log.i(TAG, "Info button clicked: infoText = $diamondInfoText")
        }
        return binding.root
    }
}