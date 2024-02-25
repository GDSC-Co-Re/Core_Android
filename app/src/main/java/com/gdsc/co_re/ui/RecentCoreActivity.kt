package com.gdsc.co_re.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gdsc.co_re.R
import com.google.android.material.tabs.TabLayout

class RecentCoreActivity : AppCompatActivity() {
    private lateinit var textViewName1: TextView
    private lateinit var textViewNameBelow1: TextView
    private lateinit var textViewDate1: TextView
    private lateinit var textViewWeight1: TextView

    private lateinit var textViewName2: TextView
    private lateinit var textViewNameBelow2: TextView
    private lateinit var textViewDate2: TextView
    private lateinit var textViewWeight2: TextView

    private lateinit var textViewName3: TextView
    private lateinit var textViewNameBelow3: TextView
    private lateinit var textViewDate3: TextView
    private lateinit var textViewWeight3: TextView

    private lateinit var textViewName4: TextView
    private lateinit var textViewNameBelow4: TextView
    private lateinit var textViewDate4: TextView
    private lateinit var textViewWeight4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_core)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        setTabInfoForFirst()
                    }
                    1 -> {
                        setTabInfoForSecond()
                    }
                    2 -> {
                        setTabInfoForThird()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        initializeViews()
        setTabInfoForFirst()
    }

    private fun initializeViews() {
        textViewName1 = findViewById(R.id.textViewName1)
        textViewNameBelow1 = findViewById(R.id.textViewNameBelow1)
        textViewDate1 = findViewById(R.id.textViewDate1)
        textViewWeight1 = findViewById(R.id.textViewWeight1)

        textViewName2 = findViewById(R.id.textViewName2)
        textViewNameBelow2 = findViewById(R.id.textViewNameBelow2)
        textViewDate2 = findViewById(R.id.textViewDate2)
        textViewWeight2 = findViewById(R.id.textViewWeight2)

        textViewName3 = findViewById(R.id.textViewName3)
        textViewNameBelow3 = findViewById(R.id.textViewNameBelow3)
        textViewDate3 = findViewById(R.id.textViewDate3)
        textViewWeight3 = findViewById(R.id.textViewWeight3)

        textViewName4 = findViewById(R.id.textViewName4)
        textViewNameBelow4 = findViewById(R.id.textViewNameBelow4)
        textViewDate4 = findViewById(R.id.textViewDate4)
        textViewWeight4 = findViewById(R.id.textViewWeight4)
    }

    private fun setTabInfoForFirst() {
        textViewName1.text = "Alley"
        textViewNameBelow1.text = "aseptic carton"
        textViewDate1.text = "01/30"
        textViewWeight1.text = "100"
        textViewName2.text = "Alley"
        textViewNameBelow2.text = "aseptic carton"
        textViewDate2.text = "01/31"
        textViewWeight2.text = "80"
        textViewName3.text = "Mike"
        textViewNameBelow3.text = "aseptic carton"
        textViewDate3.text = "01/31"
        textViewWeight3.text = "60"
        textViewName4.text = "Mike"
        textViewNameBelow4.text = "aseptic carton"
        textViewDate4.text = "01/31"
        textViewWeight4.text = "60"
    }

    private fun setTabInfoForSecond() {
        textViewName1.text = "Justin"
        textViewNameBelow1.text = "aseptic carton"
        textViewDate1.text = "03/24"
        textViewWeight1.text = "250"
        textViewName2.text = "Mike"
        textViewNameBelow2.text = "aseptic carton"
        textViewDate2.text = "03/25"
        textViewWeight2.text = "90"
        textViewName3.text = "Mike"
        textViewNameBelow3.text = "aseptic carton"
        textViewDate3.text = "03/26"
        textViewWeight3.text = "76"
        textViewName4.text = "Mike"
        textViewNameBelow4.text = "aseptic carton"
        textViewDate4.text = "01/31"
        textViewWeight4.text = "60"
    }

    private fun setTabInfoForThird() {
        textViewName1.text = "Jimin"
        textViewNameBelow1.text = "aseptic carton"
        textViewDate1.text = "03/24"
        textViewWeight1.text = "250"
        textViewName2.text = "Chaewon"
        textViewNameBelow2.text = "aseptic carton"
        textViewDate2.text = "03/25"
        textViewWeight2.text = "90"
        textViewName3.text = "Yeji"
        textViewNameBelow3.text = "aseptic carton"
        textViewDate3.text = "03/26"
        textViewWeight3.text = "76"
        textViewName4.text = "Mike"
        textViewNameBelow4.text = "aseptic carton"
        textViewDate4.text = "01/31"
        textViewWeight4.text = "60"
    }
}
