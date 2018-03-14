package me.bollytube.carouseldemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.bollytube.carouseldemo.carousels.BackgroundToForegroundCarouselActivity
import me.bollytube.carouseldemo.carousels.ForegroundToBackgroundCarouselActivity
import me.bollytube.carouseldemo.carousels.InfiniteCarouselActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_infinite_carousel.setOnClickListener {
            startActivity(Intent(this, InfiniteCarouselActivity::class.java))
        }

        btn_back_foreground_carousel.setOnClickListener {
            startActivity(Intent(this, BackgroundToForegroundCarouselActivity::class.java))
        }

        btn_foreground_to_background.setOnClickListener {
            startActivity(Intent(this, ForegroundToBackgroundCarouselActivity::class.java))
        }
    }
}
