package com.example.dialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dialog.databinding.FragmentBlank2Binding
import com.example.dialog.databinding.FragmentBlankBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
class BlankFragment2 : BottomSheetDialogFragment() {
    lateinit var binding: FragmentBlank2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank2Binding.inflate(layoutInflater)
        binding.xa.setOnClickListener{
            Toast.makeText(context, "Yashang", Toast.LENGTH_SHORT).show()
        }
        binding.no.setOnClickListener{
            Toast.makeText(context, "Eshitish kerak edi", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}