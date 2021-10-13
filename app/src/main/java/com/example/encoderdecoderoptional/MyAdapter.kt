package com.example.encoderdecoderoptional

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.txtcode.view.*

class MyAdapter(val al:ArrayList<codencod>):RecyclerView.Adapter<MyAdapter.VH>() {
    class VH(Items:View):RecyclerView.ViewHolder(Items) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.txtcode,parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var text = al[position]
        holder.itemView.apply {
            textView.text = text.txt1
            textView2.text = text.txt2
        }
    }

    override fun getItemCount(): Int = al.size
}