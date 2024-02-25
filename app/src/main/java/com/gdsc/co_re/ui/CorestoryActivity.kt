package com.gdsc.co_re.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gdsc.co_re.R
import com.google.android.material.tabs.TabLayout

class CorestoryActivity : AppCompatActivity() {
    private lateinit var textViewName1: TextView
    private lateinit var textViewDate1: TextView
    private lateinit var textViewWeight1: TextView

    private lateinit var textViewName2: TextView
    private lateinit var textViewDate2: TextView
    private lateinit var textViewWeight2: TextView

    private lateinit var textViewName3: TextView
    private lateinit var textViewDate3: TextView
    private lateinit var textViewWeight3: TextView

    private lateinit var textViewName4: TextView
    private lateinit var textViewDate4: TextView
    private lateinit var textViewWeight4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corestory)

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
        textViewDate1 = findViewById(R.id.textViewDate1)
        textViewWeight1 = findViewById(R.id.textViewWeight1)

        textViewName2 = findViewById(R.id.textViewName2)
        textViewDate2 = findViewById(R.id.textViewDate2)
        textViewWeight2 = findViewById(R.id.textViewWeight2)

        textViewName3 = findViewById(R.id.textViewName3)
        textViewDate3 = findViewById(R.id.textViewDate3)
        textViewWeight3 = findViewById(R.id.textViewWeight3)

        textViewName4 = findViewById(R.id.textViewName4)
        textViewDate4 = findViewById(R.id.textViewDate4)
        textViewWeight4 = findViewById(R.id.textViewWeight4)
    }

    private fun setTabInfoForFirst() {
        textViewName1.text = "Refrigerated carton"
        textViewDate1.text = "01/30"
        textViewWeight1.text = "100"
        textViewName2.text = "Aseptic carton"
        textViewDate2.text = "01/31"
        textViewWeight2.text = "80"
        textViewName3.text = "Refrigerated carton"
        textViewDate3.text = "01/31"
        textViewWeight3.text = "60"
        textViewName4.text = "Aseptic carton"
        textViewDate4.text = "01/31"
        textViewWeight4.text = "60"
    }

    private fun setTabInfoForSecond() {
        textViewName1.text = "Refrigerated carton"
        textViewDate1.text = "03/24"
        textViewWeight1.text = "250"
        textViewName2.text = "Aseptic carton"
        textViewDate2.text = "03/25"
        textViewWeight2.text = "90"
        textViewName3.text = "Refrigerated carton"
        textViewDate3.text = "03/26"
        textViewWeight3.text = "76"
        textViewName4.text = "Aseptic carton"
        textViewDate4.text = "01/31"
        textViewWeight4.text = "60"
    }

    private fun setTabInfoForThird() {
        textViewName1.text = "Refrigerated carton"
        textViewDate1.text = "03/24"
        textViewWeight1.text = "340"
        textViewName2.text = "Aseptic carton"
        textViewDate2.text = "03/25"
        textViewWeight2.text = "85"
        textViewName3.text = "Refrigerated carton"
        textViewDate3.text = "03/26"
        textViewWeight3.text = "54"
        textViewName4.text = "Aseptic carton"
        textViewDate4.text = "04/31"
        textViewWeight4.text = "36"
    }
}