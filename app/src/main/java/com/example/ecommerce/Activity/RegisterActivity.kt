package com.example.ecommerce.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ecommerce.R
import com.example.ecommerce.connect.Server
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private var email: String? = null
    private var password: String? = null
    private var name: String? = null
    private var checkpass: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        name = "".also { checkpass = it }.also { password = it }.also { email = it }
    }

    fun save(view: View) {
        var email = edEmail.text.toString().trim()
        var password = edPassword.text.toString().trim()
        var name = edName.text.toString().trim()
        var checkpass = edCheckPass.text.toString().trim()
//            name = "".also { checkpass = it }.also { password = it }.also { email = it }
        if (!password.equals(checkpass)) {
            Toast.makeText(this, "The password you entered is incorrect", Toast.LENGTH_LONG)
                .show()

        } else if (!name.equals("") && !email.equals("") && !password.equals("")) {
            val sr: StringRequest = object :
                StringRequest(Method.POST, Server.signup, Response.Listener { response ->
                    if (response.equals("success")) {
                        tvStatus.text = "You have successfully registered"
                        bntRegister.setOnClickListener(View.OnClickListener {
                            intent = Intent(this@RegisterActivity, HomeActivity::class.java)
                            startActivity(intent)
                        })
                    } else if (response.equals("failure")) {
                        tvStatus.text = "Can't be left blank"
                    }
                }, Response.ErrorListener { error ->
                    Toast.makeText(
                        applicationContext,
                        error.toString().trim(),
                        Toast.LENGTH_LONG
                    ).show()
                }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String>? {
                    val data: MutableMap<String, String> = HashMap()
                    data["name"] = name
                    data["email"] = email
                    data["password"] = password
                    return data
                }
            }
            val requestQueue = Volley.newRequestQueue(applicationContext)
            requestQueue.add<String>(sr)
        }
    }


    fun login(view: View) {
        intent = Intent(this@RegisterActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}