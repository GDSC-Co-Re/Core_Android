package com.gdsc.co_re.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.gdsc.co_re.R

class LocationPagerAdapter(private val context: Context, private val locations: List<Location>) : PagerAdapter() {

    override fun getCount(): Int {
        return locations.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.item_location, container, false)

        val location = locations[position]

        val locationNameTextView = view.findViewById<TextView>(R.id.textViewLocationName)
        locationNameTextView.text = location.name

        val locationLengthTextView = view.findViewById<TextView>(R.id.textViewLocation)
        locationLengthTextView.text = location.length

        val locationAddressTextView = view.findViewById<TextView>(R.id.textViewMap)
        locationAddressTextView.text = location.address

        container.addView(view)

        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
