package com.hydroponicglass.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListAdapter (val list : ArrayList<ListItem>) : RecyclerView.Adapter<ListAdapter.CustomViewHolder>()
{
    class CustomViewHolder(listView : View) : RecyclerView.ViewHolder(listView){
        val title1 = listView.findViewById<TextView>(R.id.textView1)
        val title2 = listView.findViewById<TextView>(R.id.textView2)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener{
                val curPos : Int = adapterPosition
                val item : ListItem = list.get(curPos)
                Toast.makeText(parent.context, item.title1+" "+item.title2, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ListAdapter.CustomViewHolder, position: Int) {
        holder.title1.setText(list.get(position).title1.toString())
        holder.title2.setText(list.get(position).title2.toString())
    }

    override fun getItemCount(): Int {
        return list.size
    }

}