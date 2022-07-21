package com.example.ecommerce.Model

 class GioHang {
    var idsp = 0
    var tensp: String? = null
    var giasp: Long = 0
    var hinhanhsp: String? = null
    var size: String? = null
    var soluongsp = 0

    constructor(idsp: Int, tensp: String?, giasp: Long, hinhanhsp: String?, soluongsp: Int,size: String,
    ) {
        this.idsp = idsp
        this.tensp = tensp
        this.giasp = giasp
        this.hinhanhsp = hinhanhsp
        this.size = size
        this.soluongsp = soluongsp
    }
}
