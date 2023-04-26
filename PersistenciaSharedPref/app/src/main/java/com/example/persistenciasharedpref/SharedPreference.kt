package com.example.persistenciasharedpref

import android.content.Context

class SharedPreference(val context: Context) {
    val PREFPS_NAME="sharedPreferences"
    val sharedPreference= context.getSharedPreferences(PREFPS_NAME,Context.MODE_PRIVATE)

    fun save(keyName:String, value: String)
    {
        val editor= sharedPreference.edit()
        editor.putString(keyName,value)
        editor.commit()
    }

    fun getValue(keyName:String):String?{
        return sharedPreference.getString(keyName,null)
    }

    fun clear()
    {
        val editor= sharedPreference.edit()
        editor.clear()
        editor.commit()
    }

    fun removeValue(keyName:String)
    {
        val editor=sharedPreference.edit()
        editor.remove(keyName)
        editor.commit()
    }
}