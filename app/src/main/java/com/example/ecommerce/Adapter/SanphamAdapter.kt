package com.example.ecommerce.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.util.*
import com.example.ecommerce.Model.SanPham
import com.example.ecommerce.R
import com.example.ecommerce.Activity.ChiTietSanPhamActivity
import com.example.ecommerce.connect.Checkconnect


class SanphamAdapter(var context: Context, arraySanpham: ArrayList<SanPham>) :
    RecyclerView.Adapter<SanphamAdapter.ItemHolder>() {
    var arraySanpham: ArrayList<SanPham>
    var productList: MutableList<SanPham>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.dong_sanphammoinhat, null)
        return ItemHolder(v)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val sanpham: SanPham = arraySanpham[position]
        holder.txttensanpham.setText(sanpham.Tensanpham)
        val decimalFormat = DecimalFormat("###,###,###")
        holder.txtgiasanpham.text =
            "Giá:\t" + decimalFormat.format(sanpham.Giasanpham) + " VNĐ"
        Picasso.get().load(sanpham.Hinhanhsanpham)
            .placeholder(R.drawable.nomage)
            .error(R.drawable.error)
            .into(holder.imghinhsanpham)
    }

    override fun getItemCount(): Int {
        return arraySanpham.size
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imghinhsanpham: ImageView
        var txttensanpham: TextView
        var txtgiasanpham: TextView

        init {
            imghinhsanpham = itemView.findViewById<View>(R.id.imageviewsanpham) as ImageView
            txtgiasanpham = itemView.findViewById(R.id.tvgiasanpham)
            txttensanpham = itemView.findViewById(R.id.tvTensanpham)
            itemView.setOnClickListener {
                val intent = Intent(context, ChiTietSanPhamActivity::class.java)
                intent.putExtra("thongtinsanpham", arraySanpham[position])
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                Checkconnect.ShowToast_Short(context, arraySanpham[position].Tensanpham)
                context.startActivity(intent)
            }
        }
    }

//    fun Filter(chartText: String) {
//        var chartText = chartText
//        chartText = chartText.lowercase(Locale.getDefault())
//        productList!!.clear()
//        if (chartText.length == 0) {
//            productList!!.addAll(arraySanpham)
//        } else {
//            for (p in arraySanpham) {
//                if (p.Tensanpham.toLowerCase(Locale.getDefault()).contains(chartText)) {
//                    productList!!.add(p)
//                }
//            }
//        }
//        notifyDataSetChanged()
//    }

    companion object {
        private const val Timeout = 3000
    }

    init {
        this.arraySanpham = arraySanpham
    }
}
