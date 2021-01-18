package com.project.buku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.buku.Database.Pembeli
import kotlinx.android.synthetic.main.adapter_pembeli.view.*

class PembeliAdapter (private val allPembeli: ArrayList<Pembeli>, private val listener: OnAdapterListener) : RecyclerView.Adapter<PembeliAdapter.PembeliViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PembeliViewHolder {
        return PembeliViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.adapter_pembeli, parent, false)
        )
    }

    override fun getItemCount() = allPembeli.size

    override fun onBindViewHolder(holder: PembeliViewHolder, position: Int) {
        val pembeli = allPembeli[position]
        holder.view.text_nohp.text = pembeli.nohp
        holder.view.text_nohp.setOnClickListener {
            listener.onClick(pembeli)
        }
        holder.view.icon_deletePembeli.setOnClickListener {
            listener.onDelete(pembeli)
        }
        holder.view.icon_editPembeli.setOnClickListener {
            listener.onUpdate(pembeli)
        }
    }

    class PembeliViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Pembeli>) {
        allPembeli.clear()
        allPembeli.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(pembeli: Pembeli)
        fun onDelete(pembeli: Pembeli)
        fun onUpdate(pembeli: Pembeli)
    }

}