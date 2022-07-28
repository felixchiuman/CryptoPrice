package com.felix.cryptoprice.ui.home.trending

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.felix.cryptoprice.data.api.model.trending.GetTrendingLatestResponse
import com.felix.cryptoprice.databinding.ItemContentBinding

class TrendingAdapter (private val onItemClick: OnClickListener) : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<GetTrendingLatestResponse.Data>(){
        override fun areItemsTheSame(
            oldItem: GetTrendingLatestResponse.Data,
            newItem: GetTrendingLatestResponse.Data
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: GetTrendingLatestResponse.Data,
            newItem: GetTrendingLatestResponse.Data
        ): Boolean = oldItem.hashCode() == newItem.hashCode()
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<GetTrendingLatestResponse.Data>?) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemContentBinding.inflate(inflater, parent,false))
    }

    override fun onBindViewHolder(holder: TrendingAdapter.ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(data: GetTrendingLatestResponse.Data){
            binding.apply {
                val price = data.quote.uSD.price
                val limit = String.format("%.2f", price)
                tvCode.text = data.symbol
                tvName.text = data.name
                tvPrice.text = "$$limit"
                if (data.quote.uSD.percentChange1h > 0) {
                    tvPercent.text = "+${data.quote.uSD.percentChange1h}%"
                    tvPercent.setTextColor(binding.root.context.resources.getColor(android.R.color.holo_green_dark))
                } else {
                    tvPercent.text = "${data.quote.uSD.percentChange1h}%"
                    tvPercent.setTextColor(binding.root.context.resources.getColor(android.R.color.holo_red_dark))
                }
                root.setOnClickListener {
                    onItemClick.onClickItem(data)
                }
            }
        }
    }
    interface OnClickListener{
        fun onClickItem(data: GetTrendingLatestResponse.Data)
    }
}