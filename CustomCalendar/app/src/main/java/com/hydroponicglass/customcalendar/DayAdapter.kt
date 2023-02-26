package com.hydroponicglass.customcalendar

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hydroponicglass.customcalendar.databinding.ListItemDayBinding
import java.util.*

private const val TAG = "DayAdapter"

class DayAdapter (val tempMonth:Int, val dayList : MutableList<Date>) : RecyclerView.Adapter<DayAdapter.CustomViewHolder>() {
    val ROW = 6

    class CustomViewHolder(val binding: ListItemDayBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_day, parent, false)
        return CustomViewHolder(ListItemDayBinding.bind(view))
    }

    override fun onBindViewHolder(holder: DayAdapter.CustomViewHolder, position: Int) {
        holder.binding.itemDayLayout.setOnClickListener {
            Log.d(TAG, "${dayList[position]}")
        }
        holder.binding.itemDayText.text = dayList[position].date.toString()

//        holder.binding.itemDayText.setTextColor(when(position % 7) {
//            0 -> Color.RED
//            6 -> Color.BLUE
//            else -> Color.BLACK
//        })

        if(tempMonth != dayList[position].month) {
            holder.binding.itemDayText.alpha = 0.4f
        }
    }

    override fun getItemCount(): Int {
        return ROW * 7
    }
}