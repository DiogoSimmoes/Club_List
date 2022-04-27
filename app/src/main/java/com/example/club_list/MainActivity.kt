package com.example.club_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    var clubs: List<Club> = arrayListOf(
        Club("FC Porto", 36),
        Club("Benfica", 39),
        Club("Braga", 49),
        Club("Gil Vicente", 59)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewClub = findViewById<ListView>(R.id.listViewClub)
        val clubAdapter = clubAdapter()
        listViewClub.adapter = clubAdapter
    }

    inner class clubAdapter():BaseAdapter(){
        override fun getCount(): Int {
            return clubs.size
        }

        override fun getItem(position: Int): Any {
            return clubs[position]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val rootView = layoutInflater.inflate(R.layout.rowcontent, viewGroup, false)
            val textViewClub = rootView.findViewById<TextView>(R.id.textViewClub)
            val textViewClubPoints = rootView.findViewById<TextView>(R.id.textViewClubPoints)

            textViewClub.text = clubs[position].name
            textViewClubPoints.text = clubs[position].points.toString()

            return rootView
        }

    }
}