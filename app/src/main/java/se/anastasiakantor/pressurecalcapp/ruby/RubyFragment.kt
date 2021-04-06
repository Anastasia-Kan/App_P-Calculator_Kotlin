package se.anastasiakantor.pressurecalcapp.ruby

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import se.anastasiakantor.pressurecalcapp.R
import se.anastasiakantor.pressurecalcapp.databinding.FragmentRubyBinding
import se.anastasiakantor.pressurecalcapp.diamond.DiamondViewModel
import se.anastasiakantor.pressurecalcapp.helpers.*
import se.anastasiakantor.pressurecalcapp.main.MainFragmentDirections

class RubyFragment : Fragment() {

    private lateinit var viewModel : RubyViewModel
    private lateinit var binding: FragmentRubyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ruby, container, false)
        val startFromMethod = readPreferencesFromFile()
        Log.i(TAG, "start from $startFromMethod")

        viewModel = ViewModelProvider(this, RubyViewModel.Factory(startFromMethod)).get(RubyViewModel::class.java)
        binding.rubyViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.calibration.observe(viewLifecycleOwner, {
            it?.let {
                val position = it.ordinal
                val sharedPref =
                    requireContext().getSharedPreferences(
                        PREFERENCE_FILE_NAME,
                        Context.MODE_PRIVATE
                    )
                sharedPref?.let {
                    with(sharedPref.edit()) {
                        putInt(RUBY_CALIBRATION_KEY, position)
                        apply()
                    }
                }
            }
        })

        binding.rubyInfo.setOnClickListener {
            this.findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToInfoFragment(FROM_RUBY)
            )
        }

        binding.refRuby.onRightDrawableClicked {
            it.text.clear()
        }
        binding.gotRuby.onRightDrawableClicked {
            it.text.clear()
        }
        binding.refTemp.onRightDrawableClicked {
            it.text.clear()
        }
        binding.gotTemp.onRightDrawableClicked {
            it.text.clear()
        }


        closeKeyboard()

        return binding.root
    }

    fun closeKeyboard() {
        val activity = activity as Activity

        val view = activity.currentFocus
        if (view != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm!!.hideSoftInputFromWindow(view!!.getWindowToken(), 0)
        }
    }

    private fun readPreferencesFromFile(): Int {
        val sharedPref =
            requireContext().getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE) ?: return 0
        return sharedPref.getInt(RUBY_CALIBRATION_KEY, 0)
    }
}


