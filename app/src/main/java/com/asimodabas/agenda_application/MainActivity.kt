package com.asimodabas.agenda_application

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentListesi = ArrayList<Fragment>()
    private val fragmentBaslikListesi = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentListesi.add(FragmentBirinci())
        fragmentListesi.add(Fragmentİkinci())
        fragmentListesi.add(FragmentUcuncu())


        val adapter = MyViewPagerAdapter(this@MainActivity)
        viewpager2.adapter=adapter

        fragmentBaslikListesi.add("Gündem")
        fragmentBaslikListesi.add("Spor")
        fragmentBaslikListesi.add("Magazin")

        TabLayoutMediator(tablayout,viewpager2){tab,position ->
                tab.setText(fragmentBaslikListesi[position]) }.attach()

    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return fragmentListesi.size

        }

        override fun createFragment(position: Int): Fragment {
            return fragmentListesi[position]


        }


    }


}