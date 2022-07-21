package com.example.ecommerce.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.Adapter.GiohangAdapter
import com.example.ecommerce.Model.Cart
import com.example.ecommerce.R
import com.example.ecommerce.connect.Checkconnect
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_giohangactivity.*
import java.text.DecimalFormat

class Giohangactivity : AppCompatActivity(){
    private var ahBotNavHome: BottomNavigationView? = null
    var giohangAdapter: GiohangAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giohangactivity)
        giohangAdapter = GiohangAdapter(this@Giohangactivity, HomeActivity.manggiohang)
        lvgiohang.adapter = giohangAdapter
        txttongtien = findViewById<View>(R.id.tvtongtien) as TextView
        checkData()
        EvenUtil()
        CacthOnItemListView()
        EventButton()
        initItem()

    }

    private fun initItem() {
            ahBotNavHome = findViewById(R.id.ahbotnav_home)
            ahBotNavHome!!.setSelectedItemId(R.id.bag)
            ahBotNavHome!!.setOnNavigationItemSelectedListener(navgation)
    }

    private fun EventButton() {
        bnttieptuc.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext,HomeActivity::class.java)
            startActivity(intent)
        })
        bntthanhtoan.setOnClickListener(View.OnClickListener {
            if (HomeActivity.manggiohang.size > 0 ) {
                val intent = Intent(applicationContext, ThongtinkhachhangActivity::class.java)
                startActivity(intent)
            }else{
                Checkconnect.ShowToast_Short(applicationContext, "thong bao rong")
            }
        })
    }

    private fun CacthOnItemListView() {
        lvgiohang.onItemLongClickListener = AdapterView.OnItemLongClickListener{ adapterView, view, posion, l ->
                val builder = androidx.appcompat.app.AlertDialog.Builder(this@Giohangactivity)
                builder.setTitle("Xác nhận xóa sản phẩm\n")
                builder.setMessage("Bạn có chắc chắn xóa sản phẩm này không\n")
                builder.setPositiveButton("Có") { dialogInterface, i ->
                    if (HomeActivity.manggiohang.size <= 0) {
                        tvthongbao.visibility = View.VISIBLE
                    } else {
                        HomeActivity.manggiohang.removeAt(posion)
                        giohangAdapter!!.notifyDataSetChanged()
                        EvenUtil()
                        if (HomeActivity.manggiohang.size <= 0) {
                            tvthongbao.visibility = View.VISIBLE
                        } else {
                            tvthongbao.visibility = View.INVISIBLE
                            giohangAdapter!!.notifyDataSetChanged()
                            EvenUtil()
                        }
                    }
                }
                builder.setNegativeButton("Không") { dialogInterface, i ->
                    giohangAdapter!!.notifyDataSetChanged()
                    EvenUtil()
                }
                builder.show()
                true
            }
        Log.d("AAA", "{$lvgiohang} ")
    }


    companion object {
        @SuppressLint("StaticFieldLeak")
        var txttongtien: TextView? = null
        var carts: ArrayList<Cart>? = null

        @SuppressLint("SetTextI18n")
        @JvmStatic
        fun EvenUtil() {
            var tongtien: Long = 0
            for (i in HomeActivity.manggiohang.indices) {
                tongtien += HomeActivity.manggiohang[i].giasp
            }
            val decimalFormat = DecimalFormat("###,###,###")
            txttongtien?.text = decimalFormat.format(tongtien) + "\t" + "\tVNĐ"
        }
    }


    private fun checkData() {
        if (HomeActivity.manggiohang.size <= 0) {
            tvthongbao.visibility = View.VISIBLE
            lvgiohang.visibility = View.INVISIBLE

        } else {
            tvthongbao.visibility = View.INVISIBLE
            lvgiohang.visibility = View.VISIBLE
            Log.d("AAA", "{$lvgiohang} ")
        }
        giohangAdapter?.notifyDataSetChanged()

    }
    private val navgation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val i: Intent
        when (item.itemId) {
            R.id.home -> {
                supportFragmentManager.beginTransaction().commit()
            }
            R.id.shop -> {
//                i = Intent(this@Giohangactivity, MenActivity::class.java)
//                startActivity(i)
            }
            R.id.bag -> {
                i = Intent(this@Giohangactivity, Giohangactivity::class.java)
                startActivity(i)
            }
            R.id.favorite -> {
//                i = Intent(this@Giohangactivity, FavoriteActivity::class.java)
//                startActivity(i)
            }
            R.id.profile -> {
//                i = Intent(this@Giohangactivity, ProfileActivity::class.java)
//                startActivity(i)
            }
        }
        true
    }
}