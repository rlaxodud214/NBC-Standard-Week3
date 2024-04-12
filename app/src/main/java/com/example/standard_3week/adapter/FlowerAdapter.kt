package com.example.standard_3week.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_3week.data.Flower
import com.example.standard_3week.databinding.ItemFlowerBinding

class FlowerAdapter : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {
    var dataList = listOf<Flower>()

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFlowerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class ViewHolder(val binding: ItemFlowerBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            // 클릭 이벤트 처리
        }

        fun bind(flower: Flower) {
            with(binding) {
                ivImage.setImageResource(flower.image)
                tvName.text = flower.name
            }
        }
    }
}