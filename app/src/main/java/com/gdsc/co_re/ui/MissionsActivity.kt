package com.gdsc.co_re.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gdsc.co_re.R

class MissionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_missions)
    }
    fun onBackArrowClicked(view: View) {
        onBackPressed()
    }
}