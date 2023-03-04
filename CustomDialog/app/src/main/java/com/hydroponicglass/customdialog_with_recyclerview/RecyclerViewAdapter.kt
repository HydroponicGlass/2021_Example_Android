package com.hydroponicglass.customdialog_with_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hydroponicglass.customdialog_with_recyclerview.databinding.ListItemBinding

class RecyclerViewAdapter (val list : ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>()
{
    private lateinit var itemClickListner: ItemClickListener

    class CustomViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(ListItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.CustomViewHolder, position: Int) {
        holder.binding.textView.setText(list.get(position))
        holder.itemView.setOnClickListener{
            itemClickListner.onClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    fun SetOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

}