package com.example.billboostapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.billboostapp.Adapters.CompanyAdapter.ViewHolder
import com.example.billboostapp.DataModels.Company
import com.example.billboostapp.R

class CompanyAdapter (var companyList: List<Company>):RecyclerView.Adapter<ViewHolder>() {
    class ViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {
        fun setText(item: Company) {
            TODO("Not yet implemented")
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_company, parent, false)
        return CompanyAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return companyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = companyList[position]
        holder.setText(item)
    }
}