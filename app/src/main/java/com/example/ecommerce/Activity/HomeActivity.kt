package com.example.ecommerce.Activity

import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.ecommerce.Adapter.SanphamAdapter
import com.example.ecommerce.Model.SanPham
import com.example.ecommerce.R
import com.example.ecommerce.connect.Checkconnect
import com.example.ecommerce.connect.Server
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import org.json.JSONException
import java.util.*

class HomeActivity : AppCompatActivity() {
    var mangsanpham =  ArrayList<SanPham>()
    var limitdata = false
    var sanphamAdapter: SanphamAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mangsanpham = ArrayList<SanPham>()
        sanphamAdapter = SanphamAdapter(applicationContext, mangsanpham)
        Log.d("AAA", "{$mangsanpham} ")
        rcv_new.setHasFixedSize(true)
        rcv_new.layoutManager = GridLayoutManager(applicationContext, 2)
        rcv_new.adapter = sanphamAdapter
        ActionViewFilipper()
        GetDuLieuSPMoiNhat1()
    }

    private fun GetDuLieuSPMoiNhat1() {
        val requestQueue = Volley.newRequestQueue(applicationContext)
        val jsonArrayRequest = JsonArrayRequest(Server.BASE_URL,
            { response ->
                if (response != null) {
                    var ID = 0
                    var Tensanpham = ""
                    var Giasanpham = 0
                    var Hinhanhsanpham = ""
                    var Motasanpham = ""
                    val IDsanpham = 0
                    var yeuthich = 0
                    for (i in 0 until response.length()) {
                        try {
                            val jsonObject = response.getJSONObject(i)
                            ID = jsonObject.getInt("id")
                            yeuthich = jsonObject.getInt("view")
                            Tensanpham = jsonObject.getString("name")
                            Giasanpham = jsonObject.getInt("price")
                            Hinhanhsanpham = Server.ImagerView + jsonObject.getString("image_link")
                            Motasanpham = jsonObject.getString("content")
                            // IDsanpham=jsonObject.getInt("catatlog_id");
                           mangsanpham?.add(SanPham(ID, Tensanpham, Giasanpham, Hinhanhsanpham, Motasanpham, IDsanpham, yeuthich))
                            sanphamAdapter!!.notifyDataSetChanged()
                            Collections.shuffle(mangsanpham)
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                } else {
                    limitdata = true
                    Checkconnect.ShowToast_Short(applicationContext, """The data has run out""".trimIndent()) }
            }) { }
        requestQueue.add(jsonArrayRequest)
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
            imageSlider.addView(imageView)
        }
        imageSlider.setFlipInterval(3000)
        imageSlider.setAutoStart(true)
        val animation_in = AnimationUtils.loadAnimation(
            applicationContext, R.anim.slide_in_right
        )
        val animation_out = AnimationUtils.loadAnimation(
            applicationContext, R.anim.slide_out_right
        )
        imageSlider.setInAnimation(animation_in)
        imageSlider.setOutAnimation(animation_out)
    }

}