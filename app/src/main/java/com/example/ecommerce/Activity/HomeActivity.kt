package com.example.ecommerce.Activity

import android.os.Bundle
import android.widget.ListView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.Adapter.LoaispAdapter
import com.example.ecommerce.Adapter.SanphamAdapter
import com.example.ecommerce.Data.Sanpham
import com.example.ecommerce.Data.Loaisp
import com.example.ecommerce.R
import com.google.android.material.navigation.NavigationView
import java.util.*

class HomeActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var viewFlipper: ViewFlipper? = null
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
    }
}