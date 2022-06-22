package com.example.ecommerce.Activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ecommerce.R
import com.example.ecommerce.connect.Server
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var email: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = "".also { password = it }
        var pDialog: ProgressDialog = ProgressDialog(this)
        pDialog.setMessage("Loading.......")
        pDialog.setCanceledOnTouchOutside(false)
        button.setOnClickListener(View.OnClickListener {
            var email = edEmail.text.toString().trim()
            var password = edPassword.text.toString().trim()
            if (email.equals("admin@gmail.com") && password.equals("123456")) {
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                if (checkEditText(edPassword) && isValidEmail(email)) {
                    pDialog.show()
                    val sr: StringRequest = object :
                        StringRequest(Method.POST, Server.signin, Response.Listener { response ->
                            if (response.equals("success")) {
                                Log.d("sang", "hk")
                                intent = Intent(this@MainActivity, HomeActivity::class.java)
                                startActivity(intent)
                            } else if (response.equals("failure")) {
                                Toast.makeText(
                                    this@MainActivity, "Mật khẩu bạn nhập không đúng",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }, Response.ErrorListener { error ->
                            Toast.makeText(
                                applicationContext,
                                error.toString().trim { it <= ' ' },
                                Toast.LENGTH_LONG
                            ).show()
                        }) {
                        @Throws(AuthFailureError::class)
                        override fun getParams(): Map<String, String>? {
                            val data: MutableMap<String, String> = HashMap()
                            data["email"] = email
                            data["password"] = password
                            return data
                        }
                    }
                    var requestQueue = Volley.newRequestQueue(applicationContext)
                    requestQueue.add<String>(sr)
                }
            }
        })
    }


    private fun checkEditText(editText: EditText): Boolean {
        if (editText.text.toString().trim { it <= ' ' }.length > 0) return true else {
            editText.error = "Vui lòng nhập dữ liệu!"
        }
        return false
    }

    //
    private fun isValidEmail(target: String): Boolean {
        if (target.toRegex().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) return true else {
            edEmail.setError("Email sai định dạng!")
        }
        return false
    }

    fun register(view: View) {
        intent = Intent(this@MainActivity, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}