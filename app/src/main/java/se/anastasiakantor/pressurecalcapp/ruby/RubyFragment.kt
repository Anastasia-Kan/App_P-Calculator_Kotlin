package se.anastasiakantor.pressurecalcapp.ruby

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
import se.anastasiakantor.pressurecalcapp.databinding.FragmentRubyBinding
import se.anastasiakantor.pressurecalcapp.helpers.*
import se.anastasiakantor.pressurecalcapp.main.MainFragmentDirections

class RubyFragment : Fragment() {

    private lateinit var viewModel: RubyViewModel
    private lateinit var binding: FragmentRubyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ruby, container, false)
        val startFromMethod = readPreferencesFromFile()
        Log.i(TAG, "start from $startFromMethod")

        viewModel = ViewModelProvider(
            this,
            RubyViewModel.Factory(startFromMethod)
        ).get(RubyViewModel::class.java)
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
            // TODO: show soft keyboard when old value deleted
            it.text.clear()
        }
        binding.refRuby.makeClearableEditText(null, null)

        binding.gotRuby.onRightDrawableClicked {
            it.text.clear()
        }
        binding.gotRuby.makeClearableEditText(null, null)

        binding.refTemp.onRightDrawableClicked {
            it.text.clear()
        }
        binding.refTemp.makeClearableEditText(null, null)

        binding.gotTemp.onRightDrawableClicked {
            it.text.clear()
        }
        binding.gotTemp.makeClearableEditText(null, null)

        viewModel.warningMessageRuby.observe(viewLifecycleOwner, Observer { warningMessageRuby ->
            warningMessageRuby?.let {
                if (warningMessageRuby) {
                    //Reset status value to prevent multi-triggering
                    viewModel.warningMessageRuby.value = null
                    val message = "Check your values"
                    val snack = Snackbar.make(this.requireView(), message, Snackbar.LENGTH_SHORT)
                    //snack.view.setBackgroundColor(Color.parseColor(R.color.snackbar_color.toString()))
                    snack.view.setBackgroundColor(Color.parseColor("#F44336"))
                    snack.show()
                }
            }
        })

        return binding.root
    }

    private fun readPreferencesFromFile(): Int {
        val sharedPref =
            requireContext().getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
                ?: return 0
        return sharedPref.getInt(RUBY_CALIBRATION_KEY, 0)
    }
}


