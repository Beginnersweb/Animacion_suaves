package com.example.pbe1transition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pbe1transition.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura la transición compartida
        supportPostponeEnterTransition()
        binding.imageViewDetail.transitionName = "sharedImage"
        supportStartPostponedEnterTransition()
    }
}

