package com.gdsc.co_re.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.gdsc.co_re.R
import com.google.android.material.tabs.TabLayout
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MypageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        barChart = view.findViewById(R.id.barChart)
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
        return view
    }
    private fun setupBarChart() {
        barChart.axisRight.isEnabled = false // 오른쪽 축 비활성화
        val xAxis = barChart.xAxis
        xAxis.apply {
            setDrawGridLines(false) // x축 그리드 라인 비활성화
            textColor = ContextCompat.getColor(requireContext(), R.color.green_02) // x축 레이블 색상 설정
            valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    return "" // 오른쪽 숫자 제거
                }
            }
        }
        val leftAxis = barChart.axisLeft
        leftAxis.textColor = ContextCompat.getColor(requireContext(), R.color.green_02) // 왼쪽 숫자 색상 설정
        barChart.axisLeft.setDrawAxisLine(false) // 왼쪽 축의 선 비활성화
        barChart.axisRight.setDrawAxisLine(false) // 오른쪽 축의 선 비활성화
        barChart.xAxis.setDrawAxisLine(false) // 위쪽 축의 선 비활성화
        barChart.legend.isEnabled = false // 범례 비활성화
        barChart.axisLeft.setDrawGridLines(true) // 왼쪽 y축 그리드 라인 활성화
        barChart.axisLeft.gridColor = ContextCompat.getColor(requireContext(), R.color.green_02) // 왼쪽 y축 그리드 라인 색상 설정
        barChart.description.isEnabled = false // 설명 비활성화
    }

    private fun updateBarChart(position: Int?) {
        val entries = when (position) {
            0 -> listOf(BarEntry(1f, 20f), BarEntry(2f, 30f), BarEntry(3f, 25f), BarEntry(4f, 35f))
            1 -> listOf(BarEntry(1f, 35f), BarEntry(2f, 15f), BarEntry(3f, 40f), BarEntry(4f, 20f))
            2 -> listOf(BarEntry(1f, 10f), BarEntry(2f, 45f), BarEntry(3f, 20f), BarEntry(4f, 30f))
            else -> emptyList()
        }
        val dataSet = BarDataSet(entries, "") // 범례
        dataSet.setDrawValues(false) // 그래프 위 숫자 제거
        dataSet.color = ContextCompat.getColor(requireContext(), R.color.green_03) // 그래프 색상
        val data = BarData(dataSet)
        data.barWidth = 0.4f // 그래프 가로 넓이
        barChart.data = data
        barChart.invalidate()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
