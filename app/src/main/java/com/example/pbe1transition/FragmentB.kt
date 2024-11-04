package com.example.pbe1transition

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pbe1transition.databinding.FragmentBBinding


class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Configurar ViewBinding
        binding = FragmentBBinding.inflate(inflater, container, false)

        // Configurar la animación de entrada (cuando se navega hacia FragmentB)
        enterTransition = TransitionSet().apply {
            addTransition(Fade())
            addTransition(Slide(Gravity.BOTTOM))
            duration = 800 // Duración de la animación en milisegundos
        }

        // Configurar la animación de salida (cuando se regresa a FragmentA)
        exitTransition = TransitionSet().apply {
            addTransition(Fade())
            addTransition(Slide(Gravity.END)) // Desliza hacia la derecha
            duration = 600
        }


        // Configurar el botón para regresar a FragmentA
        binding.buttonBackToA.setOnClickListener {
            (activity as MainActivity).openFragment(FragmentA())
        }

        return binding.root
    }
}
