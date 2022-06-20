package com.example.ecommerce.connect

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast


class CheckConnection {

    companion object {
        fun ShowToast_Short(context: Context?, thongbao: String?) {
            Toast.makeText(context, thongbao, Toast.LENGTH_LONG).show()
        }

        fun haveNetworkConnection(context: Context): Boolean {
            var haveConnectedWifi = false
            var haveConnectedMobile = false
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.allNetworkInfo
            for (ni in netInfo) {
                if (ni.typeName.equals(
                        "WIFI",
                        ignoreCase = true
                    )
                ) if (ni.isConnected) haveConnectedWifi = true
                if (ni.typeName.equals(
                        "MOBILE",
                        ignoreCase = true
                    )
                ) if (ni.isConnected) haveConnectedMobile = true
            }
            return haveConnectedWifi || haveConnectedMobile
        }
    }

}