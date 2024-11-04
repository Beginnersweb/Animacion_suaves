package com.example.pbe1transition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pbe1transition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar FragmentA al iniciar la actividad
        openFragment(FragmentA())
    }

    // Método para abrir fragmentos de forma dinámica
    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true) // Sincroniza las transiciones de entrada y salida
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
