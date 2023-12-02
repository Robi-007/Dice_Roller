package com.example.diceroller

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        /**
         * rollButton.text = "Let's Roll"
         */
        rollButton.setOnClickListener {
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image)

    }

    private fun rollDice() {
        val animationDrawable = ContextCompat.getDrawable(this, R.drawable.dice_animation) as AnimationDrawable
        diceImage.setImageDrawable(animationDrawable)
        animationDrawable.start()

        val random = Random().nextInt(6) + 1
        // Here you can add a delay before the animation stops to give the impression that the cube is spinning.
        android.os.Handler().postDelayed({
            animationDrawable.stop()
            val drawableResource = when (random) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.setImageResource(drawableResource)
        }, 500) // Here you can adjust the delay time for how long the cube is turned.
    }
}