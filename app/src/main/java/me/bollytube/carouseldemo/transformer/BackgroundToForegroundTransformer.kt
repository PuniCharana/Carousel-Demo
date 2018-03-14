package me.bollytube.carouseldemo.transformer

import android.view.View
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer


class BackgroundToForegroundTransformer : DiscreteScrollItemTransformer {
    override fun transformItem(item: View?, position: Float) {
        item?.let { view->
            val height = view.height
            val width = view.width
            val scale = min(if (position < 0) 1f else Math.abs(1f - position), 0.5f)

            view.scaleX = scale
            view.scaleY = scale
            view.pivotX = width * 0.5f
            view.pivotY = height * 0.5f
            view.translationX = if (position < 0) width * position else -width * position * 0.25f
        }
    }

    private fun min(pos: Float, min: Float): Float {
        return if (pos < min) min else pos
    }

}