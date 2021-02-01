package com.example.exercicioviewpager

import SectionsPagerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

        var salgados = arrayListOf("Coxinha - R$ 1.99", "Risoli - R$ 1.99", "Espiha - R$ 1.99","Kibe - R$ 1.99", "Enrolado - R$ 1.99")
        var lanches = arrayListOf("Burguer - R$ 1.99", "X-Bacon - R$ 1.99", "X-Salada - R$ 1.99", "Risoli - R$ 1.99", "X-Tudo - R$ 1.99")
        var bebidas = arrayListOf("Coca - R$ 1.99", "Guaraná - R$ 1.99", "Fanta - R$ 1.99", "Pepsi - R$ 1.99", "Suco - R$ 1.99")

        return listOf(
                PlaceholderFragment.newInstance(salgados),
                PlaceholderFragment.newInstance(lanches),
                PlaceholderFragment.newInstance(bebidas)
        )
    }

}