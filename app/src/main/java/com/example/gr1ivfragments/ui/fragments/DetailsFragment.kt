package com.example.gr1ivfragments.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.gr1ivfragments.R


class DetailsFragment : Fragment() {
    // DetailsFragment.newInstance()
    companion object {
        fun newInstance(imageId: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                        putInt("imageId", imageId)
                }
            }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_details,
                                            container, false)

        val imageView: ImageView = view.findViewById(R.id.imageView_details)
        val imageId = arguments?.getInt("imageId") ?: R.drawable.ic_launcher_foreground

        imageView.setImageResource(imageId)

        return view
    }


}