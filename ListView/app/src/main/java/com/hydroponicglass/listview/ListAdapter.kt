package com.hydroponicglass.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter (val context : Context, val contents : ArrayList<Contents>) : BaseAdapter()
{
    override fun getCount(): Int {
        return contents.size
    }

    override fun getItem(p0: Int): Any {
        return contents[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view :  View = LayoutInflater.from(context).inflate(R.layout.list_item, null)
        val title = view.findViewById<TextView>(R.id.title)
        val subTitle = view.findViewById<TextView>(R.id.subTitle)
        val content = contents[p0]

        title.setText(content.title)
        subTitle.setText(content.subTitle)

        return view
    }
}