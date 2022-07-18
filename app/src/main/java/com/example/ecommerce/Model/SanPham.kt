package com.example.ecommerce.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SanPham : Serializable {
    @SerializedName("id")
    @Expose
    var id = 0
    @SerializedName("tensanpham")
    @Expose
    var Tensanpham: String? = null

    @SerializedName("giasanpham")
    @Expose
    var Giasanpham: Int = 0

    @SerializedName("hinhanhsanpham")
    @Expose
    var Hinhanhsanpham: String? = null

    @SerializedName("motasanpham")
    @Expose
    var Motasanpham: String? = null

    @SerializedName("idsanpham")
    @Expose
    var idSanpham = 0

    @SerializedName("yeuthich")
    @Expose
     var yeuthich = 0
    private val isShortlisted = false

    constructor(
        id: Int,
        Tensanpham: String?,
        Giasanpham: Int,
        Hinhanhsanpham: String?,
        Motasanpham: String?,
        idSanpham: Int,
        yeuthich: Int
    ) {
        this.id = id
        this.Tensanpham = Tensanpham
        this.Giasanpham = Giasanpham
        this.Hinhanhsanpham = Hinhanhsanpham
        this.Motasanpham = Motasanpham
        this.idSanpham = idSanpham
        this.yeuthich = yeuthich
    }
}
