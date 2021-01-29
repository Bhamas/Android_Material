package com.example.material.network

import android.content.Context
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.IOException

public class WebService {
    val Service_URl:String="https://glwsstrack.glweststardubai.com/Services/CRMApp.asmx"
    private  val httpClient= OkHttpClient()
    var returnstring:String=""
   // val CUSTOMER_CHANGED="customer changed"

    fun   login(context: Context,UserId:String,Password:String):JSONObject
    {
        var gson= Gson()
        val requestbody=RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"),"UserId="+UserId+"&Password="+Password)
        val request=Request.Builder()
            .url(Service_URl+ "/ValidateUserId?").post(requestbody).build()
        httpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            returnstring=response.body()!!.string()
        }

            var obj=JSONObject(returnstring)
            return  obj
    }

}