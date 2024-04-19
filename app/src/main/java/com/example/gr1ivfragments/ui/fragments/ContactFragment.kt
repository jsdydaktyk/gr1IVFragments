package com.example.gr1ivfragments.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.gr1ivfragments.R
import com.example.gr1ivfragments.viewmodel.SharedViewModel

class ContactFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_contact,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText: EditText = view.findViewById(R.id.edittext)
        val button: Button = view.findViewById(R.id.btn_sender)

        button.setOnClickListener {
            viewModel.setMessage(editText.text.toString())
        }
    }
}
