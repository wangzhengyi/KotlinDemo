package com.ss.android.auto.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ss.android.auto.R

class ForecastListAdapter(val context: Context, val items: List<String>) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder != null) {
            holder.textView.text = items[position]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_list_item, parent, false)
        return ViewHolder(view, view.findViewById(R.id.tv_text))
    }


    class ViewHolder(itemView: View, var textView: TextView) : RecyclerView.ViewHolder(itemView)
}