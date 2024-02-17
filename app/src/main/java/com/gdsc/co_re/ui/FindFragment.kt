package com.gdsc.co_re.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gdsc.co_re.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FindFragment : Fragment(), OnMapReadyCallback {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    private lateinit var viewPager: ViewPager

    private val locations = listOf(
        Location("City Hall CORE", "1.2km", "15, Deoksugung-gil, Jung-gu", 37.5562, 126.9724),
        Location("Ewha Univ CORE", "1.9km", "12, Ewharo-gil, SeoDaeMoon-gu", 130.5562, 80.9724)
    )

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
        val view = inflater.inflate(R.layout.fragment_find, container, false)
        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        viewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = LocationPagerAdapter(requireContext(), locations)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                val selectedLocation = locations[position]
                val latLng = LatLng(selectedLocation.latitude, selectedLocation.longitude)
                googleMap.clear()
                googleMap.addMarker(MarkerOptions().position(latLng).title(selectedLocation.name))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
        return view
    }


    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        for (location in locations) {
            val latLng = LatLng(location.latitude, location.longitude)
            googleMap.addMarker(MarkerOptions().position(latLng).title(location.name))
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
            LatLng(locations.first().latitude, locations.first().longitude), 15f))
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FindFragment().apply { // HomeFragment() -> FindFragment() 으로 수정합니다.
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
