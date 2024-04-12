package com.example.standard_3week.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.standard_3week.R
import com.example.standard_3week.data.DataSource
import com.example.standard_3week.data.Flower
import com.example.standard_3week.databinding.FragmentHomeBinding
import com.example.standard_3week.model.FlowerViewModel

class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val flowerViewModel: FlowerViewModel by activityViewModels()

    // 0. 데이터 준비
    private val data: List<Flower> by lazy {
        DataSource.getDataSource().getFlowerList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            flowerViewModel.description.observe(viewLifecycleOwner) {
                tvDescription.text = it
            }

            btnSend.setOnClickListener {
                // 1. 데이터 셋업을 위한 Bundle 객체 생성
                val bundle = Bundle().apply {
                    putParcelable("flowerData", data[4])
                }

                // 2. arguments에 데이터를 셋업한 bundle 지정
                val fragmentInstance = DashBoardFragment.getInstance()
                val frag = fragmentInstance.apply {
                    arguments = bundle
                }

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fl_main, frag)
                    .commit()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        flowerViewModel.setDescription("This is Home Fragment")
    }

    companion object {
        private var INSTANCE: HomeFragment? = null

        fun getInstance(): HomeFragment {
            return synchronized(HomeFragment::class) {
                val newInstance = INSTANCE ?: HomeFragment()

                if (INSTANCE == null) {
                    INSTANCE = newInstance
                }

                newInstance
            }
        }
    }
}