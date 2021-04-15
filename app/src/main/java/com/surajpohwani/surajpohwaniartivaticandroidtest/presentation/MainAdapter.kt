package com.surajpohwani.surajpohwaniartivaticandroidtest.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.surajpohwani.surajpohwaniartivaticandroidtest.R
import com.surajpohwani.surajpohwaniartivaticandroidtest.data.model.Row
import com.surajpohwani.surajpohwaniartivaticandroidtest.databinding.RowItemBinding

class MainAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val rows = ArrayList<Row>()

    fun setList(rows: List<Row>) {
        this.rows.clear()
        this.rows.addAll(rows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RowItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.row_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rows.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(rows[position])
    }
}

class MyViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(row: Row) {

        binding.tvTitle.text = row.title
        binding.tvDescription.text = row.description
        binding.ivPicture.layout(0, 0, 0, 0)
        Glide.with(binding.ivPicture.context)
            .load(row.imageHref)
            .into(binding.ivPicture)

    }

}