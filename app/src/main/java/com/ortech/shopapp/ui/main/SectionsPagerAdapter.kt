package com.ortech.shopapp.ui.main

import android.content.Context
import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ortech.shopapp.R
import com.ortech.shopapp.StoreListFragment
import com.ortech.shopapp.StoreMapTabFragment

private val TAB_TITLES = arrayOf(
    Resources.getSystem().getString( R.string.tab_text_1),
    Resources.getSystem().getString( R.string.tab_text_1)
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1)
        return if (position == 1) {
            StoreMapTabFragment()
        } else {
            StoreListFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position].toString()
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}