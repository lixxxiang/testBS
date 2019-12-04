package com.example.testbs

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var behavior = BottomSheetBehavior.from(design_bottom_sheet)
        behavior.state = BottomSheetBehavior.STATE_COLLAPSED


        button.setOnClickListener { behavior.setState(BottomSheetBehavior.STATE_COLLAPSED); }

        behavior!!.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            @SuppressLint("RestrictedApi")
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                val layoutParams = bottomSheet.layoutParams

                val maxHeight: Int = 1500

                if (bottomSheet.height > maxHeight) {
                    layoutParams.height = maxHeight
                    bottomSheet.layoutParams = layoutParams
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }
}
