package com.example.gr1ivfragments.adapters

import android.content.Context
import android.media.Image
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

interface  OnImageClickListener{
    fun onImageClick(imageId: Int)
}


class ImagesGridAdapter(
    private val context: Context,
    private val imagesList: List<Int>,
    private val listener: OnImageClickListener
    ) : BaseAdapter() {
    override fun getCount(): Int = imagesList.size

    override fun getItem(position: Int): Any = imagesList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int,
                         convertView: View?,
                         parent: ViewGroup?): View {
       val imageView = convertView as? ImageView ?: ImageView(context).apply{
           layoutParams = ViewGroup.LayoutParams(300,300)
           scaleType = ImageView.ScaleType.CENTER_CROP
           setPadding(10,10,10,10)
       }
        imageView.setImageResource(imagesList[position])
        imageView.setOnClickListener{
            listener.onImageClick(imagesList[position])
        }

        return imageView
    }
}