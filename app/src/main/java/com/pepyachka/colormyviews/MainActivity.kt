package com.pepyachka.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.pepyachka.colormyviews.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                binding.boxOneText,
                binding.boxTwoText,
                binding.boxThreeText,
                binding.boxFourText,
                binding.boxFiveText,
                binding.constraintLayout
            )

        clickableViews.forEach { it -> it.setOnClickListener { makeColored(it) } }
        binding.changeColorsButton.setOnClickListener {
            clickableViews.forEach {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_text -> (view as TextView).setBackgroundAndTextColor()
            R.id.box_two_text -> (view as TextView).setBackgroundAndTextColor()
            R.id.box_three_text -> (view as TextView).setBackgroundAndTextColor()
            R.id.box_four_text -> (view as TextView).setBackgroundAndTextColor()
            R.id.box_five_text -> (view as TextView).setBackgroundAndTextColor()
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun randomColor() = Color.rgb(
        Random.nextInt(256),
        Random.nextInt(256),
        Random.nextInt(256)
    )

    private fun TextView.setBackgroundAndTextColor() {
        val color = randomColor()
        val invertedColor = getInvertedColor(color)
        this.setBackgroundColor(randomColor())
        this.setTextColor(invertedColor)
    }

    private fun getInvertedColor(color: Int): Int {
        val red = 255 - Color.red(color)
        val green = 255 - Color.green(color)
        val blue = 255 - Color.blue(color)
        return Color.rgb(red, green, blue)
    }
}