package com.example.drinkjuice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val orange = "Orange Juice"
    private val apple = "Apple Juice"
    private val mango = "Mango Juice"
    private val kewi = "Kewi Juice"

    private val values = mapOf(
        orange to 15 ,
        apple to 20 ,
        mango to 25 ,
        kewi to 30
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populatedropdownmenu()

        drink_menu.setOnItemClickListener{ adapterView , view , i , l ->
            val selectedDrink = drink_menu.text.toString()
            val price = values[selectedDrink]
            priceTv.text = price.toString()
        }

        submit.setOnClickListener {
            val message = "I want to order : ${drink_menu.text} "

            val i = Intent(Intent.ACTION_SENDTO)
            i.data = Uri.parse("mailto:")
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("CityDrink@gmail.com"))
            i.putExtra(Intent.EXTRA_SUBJECT,"Order")
            i.putExtra(Intent.EXTRA_TEXT,message)
            startActivity(i)
        }
    }

    private fun populatedropdownmenu() {
        val listofDrinks = listOf(orange,apple,mango,kewi)
        val adapter = ArrayAdapter(this,R.layout.drop_down_item,listofDrinks)
        drink_menu.setAdapter(adapter)
    }
}