package com.project.buku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.buku.Database.Buku
import kotlinx.android.synthetic.main.adapter_buku.view.*

class BukuAdapter (private val allBuku: ArrayList<Buku>, private val listener: OnAdapterListener) : RecyclerView.Adapter<BukuAdapter.BukuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        return BukuViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.adapter_buku, parent, false)
        )
    }

    override fun getItemCount() = allBuku.size

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        val buku = allBuku[position]
        holder.view.text_buku.text = buku.namabuku
        holder.view.text_buku.setOnClickListener {
            listener.onClick(buku)
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(buku)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(buku)
        }
    }

    class BukuViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Buku>) {
        allBuku.clear()
        allBuku.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(buku: Buku)
        fun onDelete(buku: Buku)
        fun onUpdate(buku: Buku)
    }
}