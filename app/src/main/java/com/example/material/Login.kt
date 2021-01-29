package com.example.material

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.material.network.WebService
import com.example.material.network.responses.LoginResponse
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import org.json.JSONObject

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Thread policy for internet access

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
       var mEmail=findViewById<TextInputEditText>(R.id.txtusername)
       var mPassword=findViewById<TextInputEditText>(R.id.txtpassword)
        findViewById<Button>(R.id.button_Go).setOnClickListener {
            signIn(mEmail.text.toString(), mPassword.text.toString())
        }
        }
       private  fun signIn(UserId:String,Password:String)
        {
                val webser=WebService()
                var obj=JSONObject()
                obj=  webser.login(this,UserId,Password)
                var g = Gson()
                var data = g.fromJson(obj.toString(), LoginResponse::class.java)
                findViewById<TextView>(R.id.slogan_name).text=data.isValid().toString()








    }
}