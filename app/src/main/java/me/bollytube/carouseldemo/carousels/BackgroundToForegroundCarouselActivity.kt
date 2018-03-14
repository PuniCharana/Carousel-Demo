package me.bollytube.carouseldemo.carousels

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.yarolegovich.discretescrollview.DiscreteScrollView
import kotlinx.android.synthetic.main.activity_carousel.*
import me.bollytube.carouseldemo.MyAdapter
import me.bollytube.carouseldemo.MyItem
import me.bollytube.carouseldemo.R
import me.bollytube.carouseldemo.transformer.BackgroundToForegroundTransformer


class BackgroundToForegroundCarouselActivity :
        AppCompatActivity(),
        DiscreteScrollView.OnItemChangedListener<MyAdapter.MyViewHolder> {
    override fun onCurrentItemChanged(viewHolder: MyAdapter.MyViewHolder?, adapterPosition: Int) {
        log("onCurrentItemChanged $adapterPosition")
    }

    private lateinit var mAdapter: MyAdapter
    private var arrayList: ArrayList<MyItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel)
        supportActionBar?.let {
            supportActionBar?.title = "Background To Foreground Carousel"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        mAdapter = MyAdapter(arrayList)

        defaultitem.adapter = mAdapter

        defaultitem.setItemTransformer(BackgroundToForegroundTransformer())

        defaultitem.addOnItemChangedListener(this)

        loadData()
    }

    private fun loadData() {
        log("Loading data...")
        for (i in 1..10) {
            arrayList.add(MyItem("Title $i", "http://via.placeholder.com/250x200"))
        }
        mAdapter.notifyDataSetChanged()
    }

    private fun log(message: String) {
        Log.d("BackgroundToForeground", message)
    }
}
