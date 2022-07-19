package com.example.ecommerce.connect

 object Server {
    private var url = "http://192.168.50.34"
    var signup = url + "/mobilephp/sign_up.php"
    var signin = url + "/mobilephp/sign_in.php"
     var BASE_URL = url + "/mobilephp/getProducts.php"
     var BAS_URL = url + "/mobilephp/getSaleProduct.php"
     var BAS_URL1 = url + "/mobilephp/testp.php"
     var Duongdanchitietdhonhang = url + "/mobilephp/chitietdonhang.php"
     var getFavorite = url + "/mobilephp/favoriteadd.php"
     var Duongdandonhang = url + "/mobilephp/thongtinkhachhang.php"
     var updatelike = url + "/mobilephp/updatelike.php"
     var yeuthich = url + "/mobilephp/yeuthich.php"
     var loaisp = url + "/mobilephp/loaisp.php"
     var spmen = url + "/mobilephp/getsanpham.php?page="
     var spwm = url + "/mobilephp/getsanpham1.php?page="
     var pktt = url + "/mobilephp/getsanpham2.php?page="
     var ttth = url + "/mobilephp/getsanpham3.php?page="
     var ImagerView = url + "/testadmin/upload/product/"
}