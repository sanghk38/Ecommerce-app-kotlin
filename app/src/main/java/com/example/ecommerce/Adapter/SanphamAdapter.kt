package com.example.ecommerce.Adapter

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.Activity.ChiTietSanPham
import com.example.ecommerce.Data.Sanpham
import com.example.ecommerce.R
import com.example.ecommerce.connect.CheckConnection
import com.squareup.picasso.Picasso
import kotlinx.android.parcel.Parcelize
import java.text.DecimalFormat


class SanphamAdapter {
   private var context: Context? = null
    private var arraySanpham: ArrayList<Sanpham>? = null
    val Timeout = 3000

    constructor(context: Context?, arraySanpham: ArrayList<Sanpham>?) {
        this.context = context
        this.arraySanpham = arraySanpham
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder? {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.dong_sanphammoinhat, null)
        return ItemHolder(v)
    }

    fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val sanpham: Sanpham = arraySanpham!![position]
        holder.txttensanpham.text =sanpham.Tensanpham
        val decimalFormat = DecimalFormat("###,###,###")
        holder.txtgiasanpham.text ="Giá: \t" + decimalFormat.format(sanpham.Giasanpham) + "Đ"
        Picasso.get().load(sanpham.Hinhanhsanpham)
            .placeholder(R.drawable.nomage)
            .error(R.drawable.error)
            .into(holder.imghinhsanpham)
    }

   override fun getItemCount(): Int {
        return arraySanpham!!.size
    }
    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imghinhsanpham: ImageView
        var txttensanpham: TextView
        var txtgiasanpham: TextView

        init {
            imghinhsanpham = itemView.findViewById<View>(R.id.imageviewsanpham) as ImageView
            txtgiasanpham = itemView.findViewById(R.id.tvgiasanpham)
            txttensanpham = itemView.findViewById(R.id.tvTensanpham)
            itemView.setOnClickListener {

                val intent = Intent(context, ChiTietSanPham::class.java)
                intent.putExtra("thongtinsanpham",position)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                CheckConnection.
                context.startActivity(intent)
            }
        }
    }
}
