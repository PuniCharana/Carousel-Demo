package me.bollytube.carouseldemo

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.my_item.view.*

class MyAdapter(
        private val mutableList: MutableList<MyItem>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(mutableList[position])
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindView(myItem: MyItem) {
            Glide.with(itemView.context).load(myItem.thumbnail).into(itemView.my_iv)
        }
    }
}