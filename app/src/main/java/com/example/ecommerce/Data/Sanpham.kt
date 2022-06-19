package com.example.ecommerce.Data

class Sanpham {
    var ID = 0
    var Tensanpham: String? = null
    var Giasanpham: Int? = null
    var Hinhanhsanpham: String? = null
    var Motasanpham: String? = null
    var IDSanpham = 0

    constructor(
        ID: Int,
        Tensanpham: String?,
        Giasanpham: Int?,
        Hinhanhsanpham: String?,
        Motasanpham: String?,
        IDSanpham: Int
    ) {
        this.ID = ID
        this.Tensanpham = Tensanpham
        this.Giasanpham = Giasanpham
        this.Hinhanhsanpham = Hinhanhsanpham
        this.Motasanpham = Motasanpham
        this.IDSanpham = IDSanpham
    }

}
