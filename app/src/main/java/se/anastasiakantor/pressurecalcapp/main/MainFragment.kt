package se.anastasiakantor.pressurecalcapp.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import se.anastasiakantor.pressurecalcapp.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import se.anastasiakantor.pressurecalcapp.helpers.PREFERENCE_FILE_NAME
import se.anastasiakantor.pressurecalcapp.helpers.START_WITH_TAB_KEY


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val titles = listOf("Ruby", "Diamond")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)

        binding.viewPager.adapter = ViewPagerFragmentAdapter(this, titles)

        // attaching tab mediator
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()

        // get FragmentNumber from Preferences and go there
        binding.viewPager.setCurrentItem(readPositionFromPreferences(), false)

        // saving FragmentNumber in ViewPager in Preferences
        val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val sharedPref =
                    requireContext().getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
                        ?: return
                with(sharedPref.edit()) {
                    putInt(START_WITH_TAB_KEY, position)
                    apply()
                }
            }
        }
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback)

        return binding.root
    }

    private fun readPositionFromPreferences(): Int {
        val sharedPref =
            requireContext().getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE) ?: return 0
        return sharedPref.getInt(START_WITH_TAB_KEY, 0)
    }
}