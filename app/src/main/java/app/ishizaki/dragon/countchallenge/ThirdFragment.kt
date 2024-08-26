package app.ishizaki.dragon.countchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.ishizaki.dragon.countchallenge.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val sharedPref = activity?.getSharedPreferences("INITIAL_PREFERENCE", Context.MODE_PRIVATE)
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)


        binding.finishTutorialButton.setOnClickListener{
            sharedPref?.edit()?.putBoolean("initial", false)?.apply()
            activity?.finish()
        }

        return binding.root
    }


}