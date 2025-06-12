package com.example.recyclervieweditview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclervieweditview.databinding.CatItemBinding

class CatAdapter (): RecyclerView.Adapter<CatAdapter.CatHolder>() {


    lateinit var binding: CatItemBinding
    var Cats = ArrayList<Cat>()

    class CatHolder (item: View) : RecyclerView.ViewHolder (item){
        var binding = CatItemBinding.bind(item)
        fun bind(cat: Cat) = with(binding) {

            imItem.setImageResource(cat.ImageID)
            tvName.text = cat.Name
            tvDescribtion.text = cat.Describtion

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder {
        val view = LayoutInflater.from(parent.context).inflate( R.layout.cat_item, parent, false)
        return CatHolder(view)
    }

    override fun getItemCount(): Int {
        return Cats.size
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
         holder.bind(Cats[position])
    }

    fun addCat(cat:Cat){
        Cats.add(cat)
        notifyDataSetChanged()
    }






}