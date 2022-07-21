package com.example.ecommerce.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.Model.GioHang
import com.example.ecommerce.Model.SanPham
import com.example.ecommerce.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_chi_tiet_san_pham.*
import java.text.DecimalFormat


class ChiTietSanPhamActivity : AppCompatActivity() {
    var id = 0
    var Tenchitiet = ""
    var Giachitiet = 0
    var Hinhanhchitiet = ""
    var Motachitiet = ""
    var Idsanpham = 0
    var yeuthich = 0
    var mangsp: ArrayList<SanPham>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_san_pham)
        GetInformation()
        EventButton()
        CatchEventSpiner()
    }

    private fun CatchEventSpiner() {
        val soluong = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, soluong)
        spinner.adapter = arrayAdapter
        val kickthuoc = arrayOf("S", "M", "L", "XL", "XXL")
        val stringAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, kickthuoc)
        spinnerkichthuoc.adapter = stringAdapter
    }

    private fun EventButton() {
        bntDatmua.setOnClickListener {
            if (HomeActivity.manggiohang.size > 0) {
                val sl = spinner.selectedItem.toString().toInt()
                val kt = spinnerkichthuoc.selectedItem.toString()
                var exite = false
                for (i in HomeActivity.manggiohang.indices) {
                    if (HomeActivity.manggiohang[i].idsp == id) {
                        HomeActivity.manggiohang[i].soluongsp = (HomeActivity.manggiohang[i].soluongsp + sl)
                        if (HomeActivity.manggiohang[i].soluongsp >= 10) {
                            HomeActivity.manggiohang[i].soluongsp = (10)
                        }
                        HomeActivity.manggiohang[i].giasp = ((Giachitiet * HomeActivity.manggiohang[i].soluongsp).toLong())
                        exite = true
                    }
                }
                if (exite == false) {
                    val soluong = spinner.selectedItem.toString().toInt()
                    val Giamoi = (soluong * Giachitiet).toLong()
                    HomeActivity.manggiohang.add(GioHang(id, Tenchitiet, Giamoi, Hinhanhchitiet, soluong, kt))
                }
            } else {
                val soluong = spinner.selectedItem.toString().toInt()
                val kt = spinnerkichthuoc.selectedItem.toString()
                val Giamoi = (soluong * Giachitiet).toLong()
                HomeActivity.manggiohang.add(GioHang(id, Tenchitiet, Giamoi, Hinhanhchitiet, soluong, kt))
            }
            val intent = Intent(applicationContext, Giohangactivity::class.java)
            startActivity(intent)
        }
    }

    private fun GetInformation() {
        var sanPham: SanPham = intent.getSerializableExtra("thongtinsanpham") as SanPham
        id = sanPham.id
        Tenchitiet = sanPham.Tensanpham.toString()
        Giachitiet = Math.toIntExact(sanPham.Giasanpham.toLong())
        Hinhanhchitiet = sanPham.Hinhanhsanpham.toString()
        Motachitiet = sanPham.Motasanpham.toString()
        Idsanpham = sanPham.idSanpham
        yeuthich = sanPham.yeuthich
        tvtenchitietsanpham.text = Tenchitiet
        //        txtgia.setText(Giachitiet);
//        txtmota.setText(Motachitiet);
        val decimalFormat = DecimalFormat("###,###,###")
        tvgiachitietsanpham.text = "Giá: \t" + decimalFormat.format(Giachitiet) + "\t VND"
        tvmotachitietsanpham.text = Motachitiet
        Picasso.get().load(Hinhanhchitiet)
            .placeholder(R.drawable.nomage)
            .error(R.drawable.error)
            .into(imgchitietsanpham)
    }

}