package com.example.gr1ivfragments.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.gr1ivfragments.R
import com.example.gr1ivfragments.adapters.ImagesGridAdapter
import com.example.gr1ivfragments.adapters.OnImageClickListener
import com.example.gr1ivfragments.viewmodel.SharedViewModel

class BoatFragment : Fragment(), OnImageClickListener {

    private val viewModel: SharedViewModel by activityViewModels()
    private val listOfImages = listOf(
        R.drawable.test_apple,
        R.drawable.test_banana,
        R.drawable.test_lemon,
        R.drawable.test_strawberry,
        R.drawable.test_watermelon
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_boat,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView: TextView = view.findViewById(R.id.textView_boat)

        viewModel.message.observe(viewLifecycleOwner){
            msg->textView.text=msg
        }

        val gridView: GridView = view.findViewById(R.id.gridView_fruits)
        gridView.adapter = ImagesGridAdapter(requireContext(),listOfImages, this)

    }

    override fun onImageClick(imageId: Int) {
        val detailsFragment: DetailsFragment = DetailsFragment.newInstance(imageId)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.welcome_fragment_container,detailsFragment)
            ?.addToBackStack(null)
            ?.commit()

    }
}
