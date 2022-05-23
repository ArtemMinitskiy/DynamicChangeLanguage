package com.cleaner.languagetset.ui.home

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cleaner.languagetset.LocaleHelper.setLocale
import com.cleaner.languagetset.MainActivity
import com.cleaner.languagetset.MainActivity2
import com.cleaner.languagetset.databinding.FragmentHomeBinding
import java.util.*


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val LANGUAGE_ENGLISH = "en"
    val LANGUAGE_UKRAINIAN = "uk"
    val LANGUAGE_RUSSIAN = "ru"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.textHome.setOnClickListener {
            setLocale(LANGUAGE_ENGLISH)
        }

        binding.textHome2.setOnClickListener {
            setLocale(LANGUAGE_RUSSIAN)
        }


        binding.nextActivity.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity2::class.java))
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    lateinit var myLocale: Locale

    //to change the language and refresh the screen
    fun setLocale(localeName: String) {
        val context: Context = setLocale(requireContext(), localeName)
        myLocale = Locale(localeName)
        val res: Resources = context.resources
        val dm: DisplayMetrics = res.displayMetrics
        val conf: Configuration = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)
        val refresh = Intent(getContext(), MainActivity::class.java)
        startActivity(refresh)
    }

}