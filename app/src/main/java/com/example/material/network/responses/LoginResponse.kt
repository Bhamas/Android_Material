package com.example.material.network.responses

public class LoginResponse {
    private val isValid:Int=1
   private val EmpId:String=""

    fun isValid():Boolean{
        return isValid==1
    }
    fun getEmpId():String{
        return EmpId
    }



}