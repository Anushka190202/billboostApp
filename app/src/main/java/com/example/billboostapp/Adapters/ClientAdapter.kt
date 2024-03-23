package com.example.billboostapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.billboostapp.DataModels.Clients
import com.example.billboostapp.R

class ClientAdapter(var clientList: List<Clients>): RecyclerView.Adapter<ClientAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName=view.findViewById<TextView>(R.id.tvName)
        var tvContact=view.findViewById<TextView>(R.id.tvContact)
        var tvEmail=view.findViewById<TextView>(R.id.tvEmail)
        var tvAddress=view.findViewById<TextView>(R.id.tvAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.client_list, parent, false)
//        context=parent.context
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return clientList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = clientList[position]
        holder.tvName.setText(item.clientName.toString())
        holder.tvContact.setText(item.contact.toString())
        holder.tvEmail.setText(item.email.toString())
        holder.tvAddress.setText(item.address.toString())
    }

}