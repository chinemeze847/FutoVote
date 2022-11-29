package com.example.futovote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.futovote.databinding.FragmentLoginBinding
import com.example.futovote.model.StudentRequestDto
import com.example.futovote.viewmodels.StudentViewModel


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val studentViewModel: StudentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener { view ->
            val matricNo = binding.matricNo.text.toString()
            val password = binding.password.text.toString()

            if(!matricNo?.isDigitsOnly()!!){
                Toast.makeText(context,"Matric no must be digits only",  Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var request : StudentRequestDto? = null

            request = StudentRequestDto(matricNo,password)

            if (request != null) {
                studentViewModel.loginStudent(request)
            }

            if(studentViewModel.registered.value == "Successful Login")
                Toast.makeText(context,"you are logged in",Toast.LENGTH_LONG)
        }
        binding.signUp.setOnClickListener {  view.findNavController().navigate(R.id.signUpFragment) }
    }
}