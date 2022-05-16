package com.suyf.parecelext.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.suyf.parecelext.R

class ParcelActivity : AppCompatActivity() {


    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.text_view)

        val item = intent.getParcelableExtra<TestParcel>("data")
        Log.d("Suyf", "parcelableExtra: -name(transient)=${item?.name}")
        Log.d("Suyf", "parcelableExtra: -age=${item?.age}")
        Log.d("Suyf", "parcelableExtra: -address=${item?.address}")

        textView.text =
            "has receive data：\nname(transient)=${item?.name},\nage=${item?.age},\naddress=${item?.address}"
    }
}