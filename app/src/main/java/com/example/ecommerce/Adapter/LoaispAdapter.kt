package com.example.ecommerce.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ecommerce.Adapter.LoaispAdapter.ViewHoldel
import com.example.ecommerce.Data.Loaisp
import com.squareup.picasso.Picasso
import com.example.ecommerce.R

class LoaispAdapter : BaseAdapter() {
    val arrayListloaisp: ArrayList<Loaisp>? = null
    val context: Context? = null


    override fun getCount(): Int {
        return arrayListloaisp!!.size
    }

    override fun getItem(position: Int): Any {
        return arrayListloaisp!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class ViewHoldel {
        var txttenloaisanpham: TextView? = null
        var imgloaisanpham: ImageView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var viewHoldel: ViewHoldel? = null
        if (convertView == null) {
            viewHoldel = ViewHoldel()
            val inflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.dong_listview_loaisp, null)
            viewHoldel.txttenloaisanpham = convertView!!.findViewById<TextView>(R.id.tvloaisanpham)
            viewHoldel.imgloaisanpham = convertView!!.findViewById<ImageView>(R.id.imloaisp)
            convertView!!.setTag(viewHoldel)
        } else {
            viewHoldel = convertView.tag as ViewHoldel
        }
        val loaisp: Loaisp = getItem(position) as Loaisp
        viewHoldel.txttenloaisanpham?.text = loaisp.tenloaisanpham
        Picasso.get().load(loaisp.hinhanhloaisanpham)
            .placeholder(R.drawable.nomage)
            .error(R.drawable.error)
            .into(viewHoldel.imgloaisanpham);
        return convertView
    }

}
