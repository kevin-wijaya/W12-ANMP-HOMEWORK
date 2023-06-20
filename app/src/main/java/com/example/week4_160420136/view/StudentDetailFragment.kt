package com.example.week4_160420136.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week4_160420136.R
import com.example.week4_160420136.databinding.FragmentStudentDetailBinding
import com.example.week4_160420136.util.loadImage
import com.example.week4_160420136.viewmodel.DetailViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class StudentDetailFragment : Fragment(), ButtonUpdateClickListener {

    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_student_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(
            inflater, R.layout.fragment_student_detail, container, false
        )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.listener = this

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        var id = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        viewModel.fetch(id)
        observeViewModel(view)
    }
    fun observeViewModel(view:View) {

        viewModel.studentLD.observe(viewLifecycleOwner) {
            dataBinding.student = it
        }
//            var imageView =  view.findViewById<ImageView>(R.id.imageView)
//            var progressBar = view.findViewById<ProgressBar>(R.id.progressBar2)
//            imageView.loadImage(it.photoUrl, progressBar)
//            view.findViewById<EditText>(R.id.txtID).setText(it.id)
//            view.findViewById<EditText>(R.id.txtName).setText(it.name)
//            view.findViewById<EditText>(R.id.txtBod).setText(it.dob)
//            view.findViewById<EditText>(R.id.txtPhone).setText(it.phone)
//        }
    }


    override fun onButtonUpdateClick(v: View) {
        Log.d("twoway", dataBinding.student.toString())
    }
}