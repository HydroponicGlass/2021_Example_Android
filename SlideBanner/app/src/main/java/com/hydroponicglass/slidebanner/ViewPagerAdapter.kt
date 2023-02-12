package com.hydroponicglass.slidebanner

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hydroponicglass.slidebanner.databinding.ItemViewpagerBinding

private const val TAG = "ViewPagerAdapter"

class ViewPagerAdapter(private val list: ArrayList<Pair<Int, String>>): RecyclerView.Adapter<ViewPagerAdapter.CustomViewHolder>() {
    class CustomViewHolder(val binding: ItemViewpagerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager, parent, false)
        return CustomViewHolder(ItemViewpagerBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.layout.setBackgroundResource(list.get(position).first)
        holder.binding.textView.setText(list.get(position).second)

        holder.itemView.setOnClickListener{
            Log.d(TAG, "${position}")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}