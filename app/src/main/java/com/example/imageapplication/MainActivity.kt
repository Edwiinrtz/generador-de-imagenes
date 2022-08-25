package com.example.imageapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.example.imageapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //instanciando el viewModel con provider para controlar el estado de la aplicación
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        val images = mutableListOf<ImageView>()
        images.add(binding.photo)
        images.add(binding.photo2)

        val len = images.size

        //traer el data
        val urlImage = mainActivityViewModel.callImageUrl(len)
        //observar cambios en el data
        urlImage?.observe(this) {
            //si el live data cambia ejecutar esto

            for (x in 0..len-1){
                mainActivityViewModel.loadImage(images.get(x),it.get(x))
            }

        }

        binding.btnUpdate.setOnClickListener {
            mainActivityViewModel.randonImageSize(len)
        }

    }

}
