package com.example.standard_3week.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.standard_3week.databinding.FragmentNotificationBinding

private const val ARG_PARAM1 = "param1"

class NotificationFragment : Fragment() {
    private var param1: String? = null

    private val binding: FragmentNotificationBinding by lazy {
        FragmentNotificationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    companion object {
        private var INSTANCE: NotificationFragment? = null

        fun getInstance(): NotificationFragment {
            return synchronized(NotificationFragment::class) {
                val newInstance = INSTANCE ?: NotificationFragment()

                if (INSTANCE == null) {
                    INSTANCE = newInstance
                }

                newInstance
            }
        }
    }
}