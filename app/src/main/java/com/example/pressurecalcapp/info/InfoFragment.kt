package com.example.pressurecalcapp.info

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pressurecalcapp.FROM_DIAMOND
import com.example.pressurecalcapp.FROM_RUBY
import com.example.pressurecalcapp.R
import com.example.pressurecalcapp.TAG
import com.example.pressurecalcapp.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)

        /*binding.infoToolbar.setNavigationIcon(R.drawable.back_arrow)
        binding.infoToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }*/

        val args: InfoFragmentArgs by navArgs()

        val from_where = args.textSource
        Log.i(TAG, "onCreateView: $from_where")

        binding.infoTV.text = when (from_where) {
            FROM_RUBY -> getString(R.string.info_ruby)
            FROM_DIAMOND -> getString(R.string.info_diamond)
            else -> ""
        }

        return binding.root
    }
}