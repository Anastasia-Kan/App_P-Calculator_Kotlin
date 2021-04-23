package se.anastasiakantor.pressurecalcapp.diamond

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import se.anastasiakantor.pressurecalcapp.R
import se.anastasiakantor.pressurecalcapp.databinding.FragmentDiamondBinding
import se.anastasiakantor.pressurecalcapp.helpers.*
import se.anastasiakantor.pressurecalcapp.main.MainFragmentDirections

class DiamondFragment : Fragment() {

    private lateinit var viewModel: DiamondViewModel
    private lateinit var binding: FragmentDiamondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_diamond, container, false)
        val startFromMethod = readPreferencesFromFile()
        viewModel = ViewModelProvider(this, DiamondViewModel.Factory(startFromMethod))
            .get(DiamondViewModel::class.java)
        binding.diamondViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.method.observe(viewLifecycleOwner, {
            it?.let {
                val position = it.ordinal
                val sharedPref =
                    requireContext().getSharedPreferences(
                        PREFERENCE_FILE_NAME,
                        Context.MODE_PRIVATE
                    )
                sharedPref?.let {
                    with(sharedPref.edit()) {
                        putInt(DIAMOND_METHOD_KEY, position)
                        apply()
                    }
                }
            }
        })

        binding.diaInfo.setOnClickListener {
            this.findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToInfoFragment(FROM_DIAMOND)
            )
        }

        binding.refPeak.onRightDrawableClicked {
            it.text.clear()
        }
        binding.refPeak.makeClearableEditText(null, null)

        binding.gotPeak.onRightDrawableClicked {
            it.text.clear()
        }
        binding.gotPeak.makeClearableEditText(null, null)

        viewModel.warningMessageDiamond.observe(viewLifecycleOwner, Observer { warningMessageDiamond ->
            warningMessageDiamond?.let {
                if(warningMessageDiamond) {
                //Reset status value to prevent multi-triggering
                viewModel.warningMessageDiamond.value = null
                val message = "Check your values"
                Snackbar.make(this.requireView(), message, Snackbar.LENGTH_LONG).show()}
            }
        })

        return binding.root
    }

    private fun readPreferencesFromFile(): Int {
        val sharedPref =
            requireContext().getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
                ?: return 0
        return sharedPref.getInt(DIAMOND_METHOD_KEY, 0)
    }
}