package me.bollytube.carouseldemo.carousels

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter
import kotlinx.android.synthetic.main.activity_infinite_scroll_carousel.*
import me.bollytube.carouseldemo.MyAdapter
import me.bollytube.carouseldemo.MyItem
import me.bollytube.carouseldemo.R
import me.bollytube.carouseldemo.transformer.InfiniteCarouselTransformer

class InfiniteCarouselActivity :
        AppCompatActivity(),
        DiscreteScrollView.OnItemChangedListener<MyAdapter.MyViewHolder> {
    override fun onCurrentItemChanged(viewHolder: MyAdapter.MyViewHolder?, adapterPosition: Int) {
        val realPosition = mInfiniteScrollWrapper.realCurrentPosition
        log("onCurrentItemChanged $realPosition")
    }

    private lateinit var mInfiniteScrollWrapper: InfiniteScrollAdapter<*>
    private lateinit var mAdapter: MyAdapter
    private var arrayList: ArrayList<MyItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinite_scroll_carousel)
        supportActionBar?.let {
            supportActionBar?.title = "Infinite Carousel"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }


        mAdapter = MyAdapter(arrayList)

        // Infinite scroll
        mInfiniteScrollWrapper = InfiniteScrollAdapter.wrap(mAdapter)
        infinite_carousel.adapter = mInfiniteScrollWrapper

        // Item transformer
        infinite_carousel.setItemTransformer(InfiniteCarouselTransformer())

        // Item change listener
        infinite_carousel.addOnItemChangedListener(this)

        // data
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
