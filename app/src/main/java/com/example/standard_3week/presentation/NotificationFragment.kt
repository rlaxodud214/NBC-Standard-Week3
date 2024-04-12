package com.example.standard_3week.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard_3week.adapter.FlowerAdapter
import com.example.standard_3week.databinding.FragmentNotificationBinding
import com.example.standard_3week.model.FlowerViewModel

class NotificationFragment : Fragment() {
    private val binding: FragmentNotificationBinding by lazy {
        FragmentNotificationBinding.inflate(layoutInflater)
    }

    private val flowerViewModel: FlowerViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(flowerViewModel) {
            description.observe(viewLifecycleOwner) {
                binding.tvDescription.text = it
            }

            flowers.observe(viewLifecycleOwner) {
                with(binding.rvImage) {
                    adapter = FlowerAdapter().apply {
                        dataList = it
                    }
                    layoutManager = LinearLayoutManager(context)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        flowerViewModel.setDescription("This is Notification Fragment")
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