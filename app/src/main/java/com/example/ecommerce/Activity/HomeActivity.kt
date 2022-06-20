package com.example.ecommerce.Activity

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ListView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.Adapter.LoaispAdapter
import com.example.ecommerce.Adapter.SanphamAdapter
import com.example.ecommerce.Data.Giohang
import com.example.ecommerce.Data.Loaisp
import com.example.ecommerce.Data.Sanpham
import com.example.ecommerce.R
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var recyclerView: RecyclerView? = null
    var navigationView: NavigationView? = null
    var listView: ListView? = null
    var drawerLayout: DrawerLayout? = null
    var mangloaisp: ArrayList<Loaisp>? = null
    var loaispAdapter: LoaispAdapter? = null
    var id = 0
    var tenloaisanpham = ""
    var hinhanhloaisanpham = ""
    var mangsanpham: ArrayList<Sanpham>? = null
    var sanphamAdapter: SanphamAdapter? = null
    var manggiohang: ArrayList<Giohang>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ActionViewFilipper()

    }

    private fun ActionViewFilipper() {
        val mangquangcao = ArrayList<String>()
        mangquangcao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoJrqgL29sDDUPHdjd1gmOmE0M8DRQgtliUg&usqp=CAU")
        mangquangcao.add("https://cellphones.com.vn/sforum/wp-content/uploads/2019/05/Honor-20-Pro-lo-anh-quang-cao-1.jpg")
        mangquangcao.add("http://media.kinhtedothi.vn//2020/10/16/photo1602639905259_16026399053921289001190.jpg")
        mangquangcao.add("https://cdnimg.vietnamplus.vn/uploaded/xtsqr/2020_10_14/screen_shot_20201014_at_004714.png")
        for (i in mangquangcao.indices) {
            val imageView = ImageView(applicationContext)
            Picasso.get().load(mangquangcao[i]).into(imageView)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            imageSlider!!.addView(imageView)
        }
        imageSlider!!.flipInterval = 3000
        imageSlider!!.isAutoStart = true
        val animation_in = AnimationUtils.loadAnimation(
            applicationContext, R.anim.slide_in_right
        )
        val animation_out = AnimationUtils.loadAnimation(
            applicationContext, R.anim.slide_out_right
        )
        imageSlider!!.inAnimation = animation_in
        imageSlider!!.outAnimation = animation_out
    }
    }
