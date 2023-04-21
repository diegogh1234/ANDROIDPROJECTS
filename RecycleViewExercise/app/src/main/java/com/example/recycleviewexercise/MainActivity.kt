package com.example.recycleviewexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var contacts= ArrayList<Contact>();

    //creamos el adapter
    var contactAdapter=ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()
    }

    private fun initView() {
        val rvcontact= findViewById<RecyclerView>(R.id.rvContact)

        rvcontact.adapter= contactAdapter
        rvcontact.layoutManager=LinearLayoutManager(this)
    }

    private fun loadContacts() {
        contacts.add(Contact("Americo","11223344"))
        contacts.add(Contact("Alan","11255344"))
        contacts.add(Contact("Alex","11226644"))
        contacts.add(Contact("Alma","99223344"))
        contacts.add(Contact("Aaron","77223344"))
        contacts.add(Contact("Axel","11255344"))
        contacts.add(Contact("Alexandro","11226644"))
        contacts.add(Contact("Alldo","97823344"))


    }
}