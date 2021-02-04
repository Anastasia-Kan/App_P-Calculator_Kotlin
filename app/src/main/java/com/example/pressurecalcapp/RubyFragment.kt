package com.example.pressurecalcapp

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatRadioButton

class RubyFragment : Fragment(), View.OnClickListener {

    val TAG = "pia9debug"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ruby, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatRadioButton>(R.id.shen_segment).setOnClickListener(this)
        view.findViewById<AppCompatRadioButton>(R.id.mao_hydro_segment).setOnClickListener(this)
        view.findViewById<AppCompatRadioButton>(R.id.mao_nHydro_segment).setOnClickListener(this)
        }

    override fun onClick(view: View?) {
        Log.i(ContentValues.TAG, "onClick: view is null: ${view == null}, view.id = ${view?.id}")
        when (view?.id) {
            R.id.shen_segment -> Log.i(ContentValues.TAG, "onClick: shen_segment")
            R.id.mao_hydro_segment -> Log.i(ContentValues.TAG, "onClick: mao_hydro_segment")
            R.id.mao_nHydro_segment -> Log.i(ContentValues.TAG, "onClick: mao_nHydro_segment")
        }
    }
}


