package com.example.pressurecalcapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatRadioButton

class RubyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_ruby, container, false)

        /*fun onSegmentClicked(view: View) {
            if (view is AppCompatRadioButton) {
                val checked = view.isChecked
                when (view.getId()) {
                    R.id.shen_segment -> if (checked) {
                        println("Shen chosen")
                    }
                    R.id.mao_hydro_segment -> if (checked) {
                        println("Mao hydro chosen")
                    }
                    R.id.mao_nHydro_segment -> if (checked) {
                        println("Mao non-hydro chosen")
                    }
                }
            }

        }*/

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shen = view.findViewById<AppCompatRadioButton>(R.id.shen_segment)
        val mao_hydro = view.findViewById<AppCompatRadioButton>(R.id.mao_hydro_segment)
        val mao_nHydro = view.findViewById<AppCompatRadioButton>(R.id.mao_nHydro_segment)

        /*fun onSegmentClicked(view: View) {
            if (view is AppCompatRadioButton) {
                val checked = view.isChecked
                when (view.getId()) {
                    R.id.shen_segment -> if (checked) {
                        println("Shen chosen")
                    }
                    R.id.mao_hydro_segment -> if (checked) {
                        println("Mao hydro chosen")
                    }
                    R.id.mao_nHydro_segment -> if (checked) {
                        println("Mao non-hydro chosen")
                    }
                }
            }*/


    }

    public fun onSegmentClicked(view: View) {
        if (view is AppCompatRadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.shen_segment -> if (checked) {println("Shen chosen")}
                R.id.mao_hydro_segment -> if (checked) {println("Mao hydro chosen")}
                R.id.mao_nHydro_segment -> if (checked) {println("Mao non-hydro chosen")}
            }
        }
    }
}