package com.suyf.parecelext.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.view.View
import android.widget.TextView
import com.suyf.parecelext.R

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private val item = TestParam().apply { name = "marry";age = 20;address = "gz" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_view)
        textView.text =
            "will send data：\nname=${item.name},\nage=${item.age},\naddress=${item.address}"
    }

    fun openSecondAct(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }

    fun openProcessAct(view: View) {
        val intent = Intent(this, ProcessActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }

    fun openThirdTestAct(view: View) {
        val intent = Intent(this, ThirdTestActivity::class.java)
        val data = TestParam2().apply { name = "我是嵌套";testParam = item }
        intent.putExtra("data", data)
        startActivity(intent)
    }

    fun openKotlinDataAct(view: View) {
        val intent = Intent(this, KotlinDataActivity::class.java)
        val data = TestKotlinData("kotlin-name", 20, "gz")
        intent.putExtra("data", data)
        startActivity(intent)
    }

    fun openParcelAct(view: View) {
        val intent = Intent(this, ParcelActivity::class.java)
        val data = TestParcel().apply { name = "marry";age = 20;address = "gz" }
        intent.putExtra("data", data)
        startActivity(intent)
    }
}