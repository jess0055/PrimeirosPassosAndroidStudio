package com.example.exerciciofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), ActivityContract {
    lateinit var fragmentProfile: FragmentPerfil
    val viewPager by lazy { findViewById<ViewPager2>(R.id.view_pager) }
    val tabs by lazy { findViewById<TabLayout>(R.id.tabs) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = getFragments()
        val adapter = Adapter(fragments, this)

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 1

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            when (position) {
                0 -> { tab.text = "NÃO SÓCIO"}
                1 -> { tab.text = "SÓCIO"}
            }
        }.attach()
    }

    private fun getFragments(): List<Fragment> {
        fragmentProfile =  FragmentPerfil()
        return listOf(
                FragmentCadastro(),
                fragmentProfile
        )
    }

    override fun onFinishForm(nome: String, email: String, telefone: String, senha: String) {
        fragmentProfile.setData(nome, email, telefone, senha)
       hideKeyboard()
    }

    private fun hideKeyboard() {
        val inputService = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputService.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

}