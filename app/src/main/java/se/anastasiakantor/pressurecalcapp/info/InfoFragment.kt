package se.anastasiakantor.pressurecalcapp.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import se.anastasiakantor.pressurecalcapp.helpers.FROM_DIAMOND
import se.anastasiakantor.pressurecalcapp.helpers.FROM_RUBY
import se.anastasiakantor.pressurecalcapp.R
import se.anastasiakantor.pressurecalcapp.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)

        val args: InfoFragmentArgs by navArgs()

        val from_where = args.textSource

        binding.infoTV.text = when (from_where) {
            FROM_RUBY -> getString(R.string.info_ruby)
            FROM_DIAMOND -> getString(R.string.info_diamond)
            else -> ""
        }

        return binding.root
    }
}