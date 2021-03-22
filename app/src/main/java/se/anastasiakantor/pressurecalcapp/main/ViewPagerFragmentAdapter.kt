package se.anastasiakantor.pressurecalcapp.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import se.anastasiakantor.pressurecalcapp.diamond.DiamondFragment
import se.anastasiakantor.pressurecalcapp.ruby.RubyFragment

class ViewPagerFragmentAdapter(
    fragment: Fragment,
    private val titles: List<String>,
) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RubyFragment()
            1 -> DiamondFragment()
            else -> RubyFragment()
        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

}