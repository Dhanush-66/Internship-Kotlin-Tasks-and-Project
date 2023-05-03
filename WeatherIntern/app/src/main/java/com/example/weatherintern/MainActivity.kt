
package com.example.weatherintern

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

import com.example.weatherintern.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var onboardingitemAdapter: OnboardingitemAdapter
    private lateinit var indicatorContainer : LinearLayout
    private lateinit var continuebtn : Button
    lateinit var preference : SharedPreferences
    val pref_show_intro = "Intro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        continuebtn = findViewById(R.id.continue_button)
        preference = getSharedPreferences( "Intro Slder", Context.MODE_PRIVATE)

        if (!preference.getBoolean(pref_show_intro,true)){
            navigatetonextactivity()
        }

        setOnboardingItems()
        setupIndicators()
        setCurrentIndicators(0)



    }

    private fun navigatetonextactivity(){
        startActivity(Intent(applicationContext,before_login_page::class.java))
        finish()
    }
    private fun setOnboardingItems(){
        onboardingitemAdapter = OnboardingitemAdapter(
            listOf(
                Onboardingitem(
                    onboardingImage = R.drawable.firstfrag,
                    title = "Account",
                    description = "You see all the detailed information in your profile."
                ),
                Onboardingitem(
                    onboardingImage = R.drawable.secondfrag,
                    title = "Map",
                    description = "You see use precipitation map to plan your day."
                ),
                Onboardingitem(
                    onboardingImage = R.drawable.thirdfrag,
                    title = "Time",
                    description = "Accurate weather forecast, which is distributed by the hour. "
                )
            )
        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onBoardingViewPager)
        onboardingViewPager.adapter = onboardingitemAdapter
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicators(position)
                val editor = preference.edit()
                editor.putBoolean(pref_show_intro,false)
                editor.apply()
            }
        }
        )
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        continuebtn.setOnClickListener{
            if(onboardingViewPager.currentItem + 1 < onboardingitemAdapter.itemCount ){
                onboardingViewPager.currentItem += 1

            }else {
                navigatetonextactivity()
            }
        }
    }

    private fun setupIndicators(){
        indicatorContainer = findViewById(R.id.indicatorContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingitemAdapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT , WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for(i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicators(position :Int){
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorContainer.getChildAt(i) as ImageView
            if(i == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}


























