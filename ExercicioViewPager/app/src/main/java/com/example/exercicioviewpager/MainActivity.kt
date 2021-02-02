package com.example.exercicioviewpager

import SectionsPagerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    val viewPager by lazy { findViewById<ViewPager2>(R.id.view_pager) }
    val tabs by lazy { findViewById<TabLayout>(R.id.tabs) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragments = getFragments()
        val sectionsPagerAdapter = SectionsPagerAdapter(fragments, this)

        viewPager.adapter = sectionsPagerAdapter
        viewPager.offscreenPageLimit = 1

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            when (position) {
                0 -> { tab.text = "Salgados"}
                1 -> { tab.text = "Lanches"}
                2 -> { tab.text = "Bebidas"}
            }
        }.attach()
    }

    private fun getFragments(): List<Fragment> {

        return listOf(
                PlaceholderFragment.newInstance(getItensCardapidio()),
                PlaceholderFragment.newInstance(getItensCardapidio()),
                PlaceholderFragment.newInstance(getItensCardapidio())
        )
    }

    private fun getItensCardapidio(): List<ItemCardapio> {
        val itensList = mutableListOf<ItemCardapio>()

        for (index in 0..4) {
            val item = ItemCardapio("Produto $index", "Valor $index")
            itensList.add(item)
        }

        return itensList.toList()
    }

}