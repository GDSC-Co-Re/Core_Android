package com.gdsc.co_re.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.gdsc.co_re.R
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class CommunityFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_community, container, false)
        val pieChart = view.findViewById<com.github.mikephil.charting.charts.PieChart>(R.id.pieChart)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(40f, ""))
        entries.add(PieEntry(60f, ""))
        val dataSet = PieDataSet(entries, "")

        dataSet.setDrawValues(false)
        dataSet.sliceSpace = 0f

        dataSet.colors = listOf(
            ContextCompat.getColor(requireContext(), R.color.green_03),
            ContextCompat.getColor(requireContext(), R.color.green_02)
        )

        dataSet.selectionShift = 5f

        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.description.isEnabled = false // Description
        pieChart.legend.isEnabled = false // 범례
        pieChart.holeRadius = 60f // 원의 크기를 조절함
        pieChart.setHoleColor(Color.TRANSPARENT)
        pieChart.invalidate()

        // LocalRanking 이동
        val imageArrow1 = view.findViewById<ImageView>(R.id.imageCommunityArrow1)
        imageArrow1.setOnClickListener {
            val intent = Intent(requireContext(), LocalRankingActivity::class.java)
            startActivity(intent)
        }

        // Missions 이동
        val imageArrow2 = view.findViewById<ImageView>(R.id.imageArrow2)
        imageArrow2.setOnClickListener {
            val intent = Intent(requireContext(), MissionsActivity::class.java)
            startActivity(intent)
        }

        // recentCore 이동
        val imageArrow3 = view.findViewById<ImageView>(R.id.imageArrow3)
        imageArrow3.setOnClickListener {
            val intent = Intent(requireContext(), RecentCoreActivity::class.java)
            startActivity(intent)
        }

        return view
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