package com.hydroponicglass.customdialog_with_recyclerview

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hydroponicglass.customdialog_with_recyclerview.databinding.LayoutDialogBinding

class CustomDialog(private val context : AppCompatActivity) {

    private lateinit var binding : LayoutDialogBinding
    private val dialog = Dialog(context)

    fun ShowDialog(string : String) {
        binding = LayoutDialogBinding.inflate(context.layoutInflater)
        dialog.setContentView(binding.root)

//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)   // remove title bar
//        dialog.setCancelable(false) // when outside click, not invisible

        binding.textView.text = string

        val list = arrayListOf(
            "aaAAAAAAAAAAAAAAA",
            "baAAAAAAAAAAAAAAA",
            "caAAAAAAAAAAAAAAA",
            "daAAAAAAAAAAAAAAA",
            "eaAAAAAAAAAAAAAAA",
            "faAAAAAAAAAAAAAAA",
        )

        val adapter = RecyclerViewAdapter(list)
        adapter.SetOnItemClickListener( object : RecyclerViewAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                Log.d("test", "${position}")
            }
        })
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        dialog.show()
    }
}