package me.bollytube.carouseldemo

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.ViewCompat.setScaleY
import android.support.v4.view.ViewCompat.setScaleX




class MainActivity : AppCompatActivity() {

    private var mutableList: MutableList<MyItem> = mutableListOf()
    private lateinit var mAdapter: MyAdapter

    private lateinit var mLayoutManager: CarouselLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = MyAdapter(mutableList)
        mLayoutManager = CarouselLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        my_rv.layoutManager = mLayoutManager
        my_rv.adapter = mAdapter

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(my_rv)

        loadData()

        click_me.setOnClickListener {
//            mLayoutManager.scrollToPosition(5)
            my_rv.scrollToPosition(5)
        }
    }

    private fun loadData() {
        for (i in 1..50) {
            mutableList.add(MyItem("Title $i", "http://via.placeholder.com/250x200"))
        }
        mAdapter.notifyDataSetChanged()
    }
}
