package com.hydroponicglass.mediastore_soundfileexecute

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AudioListAdapter (val list : ArrayList<AudioListItem>) : RecyclerView.Adapter<AudioListAdapter.CustomViewHolder>(){
    var mediaPlayer = MediaPlayer()
    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val fileName = view.findViewById<TextView>(R.id.fileName)
        val duration = view.findViewById<TextView>(R.id.duration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioListAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.audio_list_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener{
                val curPos : Int = adapterPosition
                val item : AudioListItem = list.get(curPos)
                Toast.makeText(parent.context, "${item.fileName} ${item.duration} ${item.uri}", Toast.LENGTH_SHORT).show()
                mediaPlayer.reset()
                mediaPlayer.setDataSource(parent.context, item.uri)
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener {
                    mediaPlayer.start()
                }
            }
        }
    }

    override fun onBindViewHolder(holder: AudioListAdapter.CustomViewHolder, position: Int) {
        holder.fileName.setText(list.get(position).fileName)
        holder.duration.setText(list.get(position).duration)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}