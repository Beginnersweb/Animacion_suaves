package com.example.pbe1transition

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pbe1transition.databinding.FragmentABinding

class FragmentA : Fragment() {
    private lateinit var binding: FragmentABinding
    private var isImageViewExpanded = false // Variable para alternar el tamaño de la imagen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition() // Retrasa la transición de entrada en FragmentA
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)

        // Configurar el botón para alternar el tamaño de la imagen
        binding.buttonAnimateViews.setOnClickListener {
            toggleImageSize() // Llama a la función para cambiar el tamaño de la imagen
        }

        // Configurar transición de entrada para FragmentA
        enterTransition = TransitionSet().apply {
            addTransition(Fade())
            addTransition(Slide())
            duration = 600
        }

        // Configurar el botón para ir a FragmentB
        binding.buttonGoToB.setOnClickListener {
            (activity as MainActivity).openFragment(FragmentB())
        }

        // Iniciar la transición  después de que la vista esté completamente cargada
        binding.root.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }

        return binding.root
    }

    // Función para alternar el tamaño de la imagen
    private fun toggleImageSize() {
        val transition = ChangeBounds().apply {
            duration = 500 // Duración de la animación
        }
        TransitionManager.beginDelayedTransition(binding.root as ViewGroup, transition)

        if (isImageViewExpanded) {
            // Reducir al tamaño original
            binding.imageView.layoutParams.width = 200
            binding.imageView.layoutParams.height = 200
        } else {
            // Expandir a un tamaño mayor
            binding.imageView.layoutParams.width = 800
            binding.imageView.layoutParams.height = 800
        }

        // Solicitar actualización de layout y alternar estado
        binding.imageView.requestLayout()
        isImageViewExpanded = !isImageViewExpanded
    }
}
