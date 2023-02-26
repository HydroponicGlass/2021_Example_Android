package com.hydroponicglass.customcalendar

import android.content.Context
import com.hydroponicglass.customcalendar.databinding.ListItemMonthBinding

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MonthAdapter (var context : Context) : RecyclerView.Adapter<MonthAdapter.CustomViewHolder>() {
    val center = Int.MAX_VALUE / 2
    private var calendar = Calendar.getInstance()

    class CustomViewHolder(val binding: ListItemMonthBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_month, parent, false)
        return CustomViewHolder(ListItemMonthBinding.bind(view))
    }

    override fun onBindViewHolder(holder: MonthAdapter.CustomViewHolder, position: Int) {
        calendar.time = Date() // Get today
        calendar.set(Calendar.DAY_OF_MONTH, 1) // Move to 1st day
        calendar.add(Calendar.MONTH, position - center)
        holder.binding.itemMonthText.text = "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월"
        val tempMonth = calendar.get(Calendar.MONTH)

        var dayList: MutableList<Date> = MutableList(6 * 7) { Date() } // 6 is week, 7 is day
        for(i in 0..5) {
            for(k in 0..6) {
                calendar.add(Calendar.DAY_OF_MONTH, (1-calendar.get(Calendar.DAY_OF_WEEK)) + k)
                dayList[i * 7 + k] = calendar.time
            }
            calendar.add(Calendar.WEEK_OF_MONTH, 1)
        }

        val dayListManager = GridLayoutManager(context, 7)
        val dayListAdapter = DayAdapter(tempMonth, dayList)

        holder.binding.itemMonthDayList.apply {
            layoutManager = dayListManager
            adapter = dayListAdapter
        }
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}