package me.bollytube.carouseldemo.transformer

import android.view.View
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer

class InfiniteCarouselTransformer : DiscreteScrollItemTransformer {

    override fun transformItem(item: View?, position: Float) {

        item?.let { view ->
            val height = view.height
            val width = view.width
            val scale: Float = if (position < 0) {
                min(if (position > 0) 1f else Math.abs(1f + position), 0.9f)
            } else {
                min(if (position < 0) 1f else Math.abs(1f - position), 0.9f)
            }

            view.scaleX = scale
            view.scaleY = scale
            view.pivotX = width * 0.5f
            view.pivotY = height * 0.5f
        }
    }

    private fun min(pos: Float, min: Float): Float {
        return if (pos < min) min else pos
    }
}