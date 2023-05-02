package com.example.weatherintern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherintern.databinding.FragmentWelcomefragmentBinding

class Welcomefragment : Fragment() {
    private lateinit var binding: FragmentWelcomefragmentBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcomefragment, container, false)
    }

    fun setTitle(title : String){
        binding.fragmentTitle.text = title
    }

}