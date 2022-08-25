package com.example.imageapplication

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso

class MainActivityViewModel : ViewModel() {

    private var url: MutableLiveData<MutableList<String>>? = null

    /*var imagesCounter = 0

    fun getImagesNumber():Int{
        return  MainActivityViewModel.getNumber()
    }*/

    fun callImageUrl(numberImages:Int): MutableLiveData<MutableList<String>>?{
        if(url==null){
            url = MutableLiveData<MutableList<String>>()
            randonImageSize(numberImages)
        }
        return url
    }

    fun randonImageSize(numberImages:Int){
        var list = mutableListOf<String>()

        for (x in 1..numberImages){
            list.add("https://picsum.photos/${(3..5).random()}00/${(3..5).random()}00")
        }

        url?.value = list
    }

    fun loadImage(view: ImageView,url:String) {
        //
        Picasso
            .get()
            .load(url)
            .into(view)
    }
    /*companion object {
        private var number = 0
        @JvmStatic
        @BindingAdapter("bind:countImages")
        fun countImage(view: ImageView, x: Int) {
            number += x+1
            Log.i("number of images", (number).toString())
        }

        fun getNumber(): Int{
            return number
        }
    }*/


}
