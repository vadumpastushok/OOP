package com.example.lab5

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.databinding.ItemRvBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.TableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TableViewHolder(ItemRvBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.binding.itemIcon.setImageResource(MyEditor.getShapes()[position].getIcon())
        holder.binding.itemInfo.text = MyEditor.getShapes()[position].getInfo()
        holder.binding.itemDelete.setOnClickListener {
            MyEditor.removeShape(MyEditor.getShapes()[position])
        }
        holder.binding.itemLayout.setOnClickListener {
            MyEditor.setHighlightedShape(MyEditor.getShapes()[position])
        }
        if (MyEditor.getHighlightedShape() == MyEditor.getShapes()[position]) {
            holder.binding.itemInfo.setBackgroundColor(Color.GRAY)
        } else {
            holder.binding.itemInfo.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun getItemCount(): Int {
        return MyEditor.getShapes().size
    }

    class TableViewHolder(val binding: ItemRvBinding): RecyclerView.ViewHolder(binding.root)
}