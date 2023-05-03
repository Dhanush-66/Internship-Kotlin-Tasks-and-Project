package com.example.weatherintern

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingitemAdapter(private val onboardingitem: List<Onboardingitem>):
RecyclerView.Adapter<OnboardingitemAdapter.OnboardingItemViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return  OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_item_container,
                parent,false

            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onboardingitem[position])
    }

    override fun getItemCount(): Int {
        return onboardingitem.size
    }

    inner class OnboardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private  val imageOnboarding = view.findViewById<ImageView>(R.id.imageOnboarding)
        private  val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private  val  textDiscription = view.findViewById<TextView>(R.id.textDiscription)

        fun bind(onboardingitem: Onboardingitem){
            imageOnboarding.setImageResource(onboardingitem.onboardingImage)
            textTitle.text=onboardingitem.title
            textDiscription.text = onboardingitem.description
        }
    }

}