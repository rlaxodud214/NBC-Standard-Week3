package com.example.standard_3week.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.standard_3week.data.Flower
import com.example.standard_3week.databinding.FragmentDashboardBinding

private const val KEY = "flowerData"

class DashBoardFragment : Fragment() {
    private val binding: FragmentDashboardBinding by lazy {
        FragmentDashboardBinding.inflate(layoutInflater)
    }

    private lateinit var receivedData: Flower

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments.let {
            if (it!!.containsKey(KEY)) {
                receivedData = it.getParcelable<Flower>(KEY)!!
            }
        }
    }

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
        binding.tvText1.text = "이름: ${receivedData.name} \n설명: ${receivedData.description}"
    }

    companion object {
        private var INSTANCE: DashBoardFragment? = null

        fun getInstance(): DashBoardFragment {
            return synchronized(DashBoardFragment::class) {
                val newInstance = INSTANCE ?: DashBoardFragment()

                if (INSTANCE == null) {
                    INSTANCE = newInstance
                }

                newInstance
            }
        }
    }
}