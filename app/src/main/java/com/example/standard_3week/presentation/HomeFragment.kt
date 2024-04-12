package com.example.standard_3week.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.standard_3week.R
import com.example.standard_3week.data.DataSource
import com.example.standard_3week.data.Flower
import com.example.standard_3week.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
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

        with(binding) {
            btnSend.setOnClickListener {
                // 0. 데이터 준비
                val dataSource = DataSource.getDataSource()
                val data: List<Flower> = dataSource.getFlowerList()

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