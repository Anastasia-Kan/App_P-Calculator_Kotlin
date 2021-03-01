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
import androidx.databinding.DataBindingUtil
import com.example.pressurecalcapp.databinding.FragmentRubyBinding
import androidx.databinding.DataBindingUtil.inflate as dataBindingUtilInflate

class RubyFragment : Fragment(), View.OnClickListener {

    val TAG = "MyDebug"

    private lateinit var bind_ruby: FragmentRubyBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind_ruby = DataBindingUtil.inflate(inflater, R.layout.fragment_ruby, container, false)
        return bind_ruby.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind_ruby.shenSegment.setOnClickListener(this)
        bind_ruby.maoHydroSegment.setOnClickListener(this)
        bind_ruby.maoNHydroSegment.setOnClickListener(this)
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


