package com.example.standard_3week.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.standard_3week.R
import com.example.standard_3week.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Default로 Home Fragment가 뜨도록 추가함
        setFragment(HomeFragment())

        // 프레임 레이아웃에 Fragment를 띄운다.
        with(binding) {
            tlMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.connectFragment()
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {}
                override fun onTabReselected(p0: TabLayout.Tab?) {}
            })

        }
    }

    private fun TabLayout.Tab.connectFragment() = with(binding) {
        // tab의 포지션 값을 이용해서 Fragment를 구분할 수 있었다!! -> 하지만, 명시적이진 않음
        // TabItem에 id 값이 들어간다면 명시적으로 체크할 수 있지만 id값을 넣으면 오류가 발생한다,,(원래 그렇다고 함)
        when (this@connectFragment.position) {
             0 -> setFragment(HomeFragment.getInstance())
             1 -> setFragment(DashBoardFragment.getInstance())
             2 -> setFragment(NotificationFragment.getInstance())
        }
    }

    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fl_main, frag)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}