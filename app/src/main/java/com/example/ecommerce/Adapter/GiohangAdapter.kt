package com.example.ecommerce.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.ecommerce.Activity.Giohangactivity
import com.example.ecommerce.Activity.HomeActivity
import com.example.ecommerce.Model.GioHang
import com.example.ecommerce.R
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class GiohangAdapter(var context: Context, giohangArrayList: ArrayList<GioHang>) : BaseAdapter() {
    var giohangArrayList: ArrayList<GioHang>
    override fun getCount(): Int {
        return giohangArrayList.size
    }

    override fun getItem(position: Int): Any {
        return giohangArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    inner class ViewHodel {
        var txttengiohang: TextView? = null
        var txtgiagiohang: TextView? = null
        var tvso: TextView? = null
        var imggiohang: ImageView? = null
        var bnttru: Button? = null
        var bntgiatri: Button? = null
        var bntcong: Button? = null
        var editText: EditText? = null
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        var viewHodel: ViewHodel? = null
        if (view == null) {
            viewHodel = ViewHodel()
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.dong_giohang, null)
            viewHodel.txttengiohang = view.findViewById<View>(R.id.tvtengiohang) as TextView
            viewHodel.txtgiagiohang = view.findViewById<View>(R.id.tvgiagiohang) as TextView
            viewHodel.imggiohang = view.findViewById<View>(R.id.imggiohang) as ImageView
            viewHodel.bnttru = view.findViewById<View>(R.id.bnttru) as Button
            viewHodel.bntgiatri = view.findViewById<View>(R.id.bntthem) as Button
            viewHodel.bntcong = view.findViewById<View>(R.id.bntcong) as Button
            view.tag = viewHodel
        } else {
            viewHodel = view.tag as ViewHodel
        }
        val giohang: GioHang = getItem(i) as GioHang
        viewHodel.txttengiohang?.text = giohang.tensp
        val decimalFormat = DecimalFormat("###,###,###")
        viewHodel.txtgiagiohang!!.text = "Giá:\t" + decimalFormat.format(giohang.giasp) + "VND"
        Picasso.get().load(giohang.hinhanhsp)
            .placeholder(R.drawable.nomage)
            .error(R.drawable.error)
            .into(viewHodel.imggiohang)
        viewHodel.bntgiatri?.setText(giohang.soluongsp.toString() + "")
        val sl = viewHodel.bntgiatri!!.text.toString().toInt()
        if (sl >= 15) {
            viewHodel.bntcong!!.visibility = View.INVISIBLE
            viewHodel.bnttru!!.visibility = View.VISIBLE
        } else if (sl <= 1) {
            viewHodel.bnttru!!.visibility = View.INVISIBLE
        } else if (sl >= 1) {
            viewHodel.bnttru!!.visibility = View.VISIBLE
            viewHodel.bntcong!!.visibility = View.VISIBLE
        }
        val finalViewHolder = viewHodel
        val finalViewHolder1 = viewHodel
        viewHodel.bntcong!!.setOnClickListener {
            val slmoinhat = finalViewHolder.bntgiatri!!.text.toString().toInt() + 1
            val slhientai: Int = HomeActivity.manggiohang.get(i).soluongsp
            val giaht: Long = HomeActivity.manggiohang.get(i).giasp
            HomeActivity.manggiohang.get(i).soluongsp = slmoinhat
            val giamoinhat = giaht * slmoinhat / slhientai
            HomeActivity.manggiohang.get(i).giasp = giamoinhat
            val decimalFormat = DecimalFormat("###,###,###")
            finalViewHolder.txtgiagiohang!!.text = decimalFormat.format(giamoinhat) + " VND"
            Giohangactivity.EvenUtil()
            if (slmoinhat > 14) {
                finalViewHolder1.bntcong!!.visibility = View.INVISIBLE
                finalViewHolder1.bnttru!!.visibility = View.VISIBLE
                finalViewHolder.bntgiatri!!.text = slmoinhat.toString()
            } else {
                finalViewHolder.bnttru!!.visibility = View.VISIBLE
                finalViewHolder.bntcong!!.visibility = View.VISIBLE
                finalViewHolder.bntgiatri!!.text = slmoinhat.toString()
            }
        }
        viewHodel.bnttru!!.setOnClickListener {
            val slmoinhat = finalViewHolder.bntgiatri!!.text.toString().toInt() - 1
            val slhientai: Int = HomeActivity.manggiohang.get(i).soluongsp
            val giaht: Long = HomeActivity.manggiohang.get(i).giasp
            HomeActivity.manggiohang.get(i).soluongsp = (slmoinhat)
            val giamoinhat = giaht * slmoinhat / slhientai
            HomeActivity.manggiohang.get(i).giasp = (giamoinhat)
            val decimalFormat = DecimalFormat("###,###,###")
            finalViewHolder.txtgiagiohang!!.text = decimalFormat.format(giamoinhat) + " $"
            Giohangactivity.EvenUtil()
            if (slmoinhat < 2) {
                finalViewHolder.bnttru!!.visibility = View.INVISIBLE
                finalViewHolder.bntcong!!.visibility = View.VISIBLE
                finalViewHolder.bntgiatri!!.text = slmoinhat.toString()
            } else {
                finalViewHolder.bnttru!!.visibility = View.VISIBLE
                finalViewHolder.bntcong!!.visibility = View.VISIBLE
                finalViewHolder.bntgiatri!!.text = slmoinhat.toString()
            }
        }
        return view!!
    }

    init {
        this.giohangArrayList = giohangArrayList
    }
}