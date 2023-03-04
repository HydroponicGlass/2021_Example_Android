package com.hydroponicglass.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hydroponicglass.recyclerview.databinding.ListItemBinding

class RecyclerViewAdapter (val list : ArrayList<ListItem>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>()
{
    class CustomViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(ListItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.CustomViewHolder, position: Int) {
        holder.binding.textView1.setText(list.get(position).title1.toString())
        holder.binding.textView2.setText(list.get(position).title2.toString())
    }

    override fun getItemCount(): Int {
        return list.size
    }

}