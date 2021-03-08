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

class RubyFragment : Fragment(), View.OnClickListener {

    private lateinit var viewModel : RubyViewModel
    private lateinit var binding: FragmentRubyBinding

    private val TAG = "MyDebug"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ruby, container, false)
        binding.infoRubyBTN.setOnClickListener { // App crashes with click
            this.findNavController().navigate(R.id.action_rubyFragment_to_infoFragment)
        }
        /*
        binding.buttonRules.setOnClickListener {
            this.findNavController().navigate(R.id.action_gameFragment_to_rulesFragment)
        }
         */
        Log.i(TAG, "Called ViewModelProvider" )
        viewModel = ViewModelProvider(this).get(RubyViewModel::class.java)
        binding.rubyViewModel = viewModel
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shenSegment.setOnClickListener(this)
        binding.maoHydroSegment.setOnClickListener(this)
        binding.maoNHydroSegment.setOnClickListener(this)

        val resPressureTV = binding.resPressureTV
        val refRubyET = binding.refRuby.text
        val gotRubyET = binding.gotRuby.text

        viewModel.refRuby = refRubyET.toString()

        binding.calcPressureBTN.setOnClickListener() {
            viewModel.calcPClicked()
        }

        resPressureTV.text = viewModel.refRuby
    }

    override fun onClick(view: View?) {
        Log.i(TAG, "onClick: view is null: ${view == null}, view.id = ${view?.id}")
        when (view?.id) {
            R.id.shen_segment -> Log.i(TAG, "onClick: shen_segment")
            R.id.mao_hydro_segment -> Log.i(TAG, "onClick: mao_hydro_segment")
            R.id.mao_nHydro_segment -> Log.i(TAG, "onClick: mao_nHydro_segment")
        }
    }
}


