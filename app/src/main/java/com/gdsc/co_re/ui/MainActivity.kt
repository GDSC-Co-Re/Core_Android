package com.gdsc.co_re.ui

import QrFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gdsc.co_re.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navbar = findViewById<BottomNavigationView>(R.id.navbar)

        navbar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.tab_home -> {
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, homeFragment).commit()
                }
                R.id.tab_find -> {
                    val findFragment = FindFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, findFragment).commit()
                }
                R.id.tab_qr -> {
                    val qrFragment = QrFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, qrFragment).commit()
                }
                R.id.tab_community -> {
                    val communityFragment = CommunityFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, communityFragment).commit()
                }
                R.id.tab_mypage -> {
                    val mypageFragment = MypageFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, mypageFragment).commit()
                }
            }
            true
        }
        navbar.selectedItemId = R.id.tab_home
    }
}
