package com.intelligentinvestorfinance.settingsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList : ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.profile,
            R.drawable.about,
            R.drawable.contact,
            R.drawable.help
        )

        heading = arrayOf(
            "Profile",
            "About Us",
            "Contact Us",
            "Help"
        )

        newRecyclerview = findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in imageId.indices){

            val news = News(imageId[i],heading[i])
            newArrayList.add(news)
        }

        newRecyclerview.adapter = MyAdapter(newArrayList)
    }
}