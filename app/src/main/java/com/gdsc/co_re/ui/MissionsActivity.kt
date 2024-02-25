package com.gdsc.co_re.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gdsc.co_re.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.android.material.tabs.TabLayout

class MissionsActivity : AppCompatActivity() {

    private lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_missions)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        barChart = findViewById(R.id.barChart)
        setupBarChart()

        // 처음에 0번 데이터 표시
        tabLayout.getTabAt(0)?.select()
        updateBarChart(0)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                updateBarChart(tab?.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupBarChart() {
        barChart.axisRight.isEnabled = false // 오른쪽 축 비활성화
        val xAxis = barChart.xAxis
        xAxis.apply {
            setDrawGridLines(false) // x축 그리드 라인 비활성화
            textColor = ContextCompat.getColor(this@MissionsActivity, R.color.green_02) // x축 레이블 색상 설정
            valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    return "" // 오른쪽 숫자 제거
                }
            }
        }
        val leftAxis = barChart.axisLeft
        leftAxis.textSize = 14f
        leftAxis.setLabelCount(4, true) // 4개만 표시
        leftAxis.textColor = ContextCompat.getColor(this, R.color.green_03) // 왼쪽 숫자 색상 설정
        leftAxis.setDrawAxisLine(false) // 왼쪽 축의 선 비활성화
        leftAxis.setDrawGridLines(true) // 왼쪽 y축 그리드 라인 활성화
        leftAxis.gridColor = ContextCompat.getColor(this, R.color.green_02) // 왼쪽 y축 그리드 라인 색상 설정
        barChart.axisRight.setDrawAxisLine(false) // 오른쪽 축의 선 비활성화
        barChart.xAxis.setDrawAxisLine(false) // 위쪽 축의 선 비활성화
        barChart.legend.isEnabled = false // 범례 비활성화
        barChart.description.isEnabled = false // 설명 비활성화
    }

    private fun updateBarChart(position: Int?) {
        val entries = when (position) {
            0 -> listOf(
                BarEntry(1f, 20f, "1st"),
                BarEntry(2f, 30f, "2nd"),
                BarEntry(3f, 25f, "3rd"),
                BarEntry(4f, 35f, "4th")
            )
            1 -> listOf(
                BarEntry(1f, 35f, "Nov"),
                BarEntry(2f, 15f, "Dec"),
                BarEntry(3f, 40f, "Jan"),
                BarEntry(4f, 20f, "Feb")
            )
            2 -> listOf(
                BarEntry(1f, 10f, "2021"),
                BarEntry(2f, 45f, "2022"),
                BarEntry(3f, 20f, "2023"),
                BarEntry(4f, 30f, "2024")
            )
            else -> emptyList()
        }
        val dataSet = BarDataSet(entries, "") // 범례

        // 막대 아래에 텍스트 표시 설정
        dataSet.setDrawValues(true)
        dataSet.valueTextSize = 14f
        dataSet.valueTypeface = Typeface.create("pretendard_light", Typeface.NORMAL)
        dataSet.valueTextColor = ContextCompat.getColor(this, R.color.green_03)
        dataSet.valueFormatter = object : ValueFormatter() {
            override fun getBarLabel(barEntry: BarEntry?): String {
                return barEntry?.data.toString()
            }
        }
        dataSet.color = ContextCompat.getColor(this, R.color.green_03) // 그래프 색상
        val data = BarData(dataSet)
        data.barWidth = 0.4f // 그래프 가로 넓이
        barChart.data = data
        barChart.invalidate()
    }
}
