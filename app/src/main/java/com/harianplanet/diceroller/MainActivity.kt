package com.harianplanet.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btn_roll)
        rollButton.setOnClickListener {
            val resultTextView : TextView = findViewById(R.id.textView)
            val diceImage1 : ImageView = findViewById(R.id.imageView)
            val resultTextView2 : TextView = findViewById(R.id.textView2)
            val diceImage2 : ImageView = findViewById(R.id.imageView2)
            val resultTextView3 : TextView = findViewById(R.id.textView3)
            val result : Int = rollDice()
            val result2 = rollDice()
            resultTextView.text = result.toString()
            resultTextView2.text = result2.toString()
            val drawabel_resource : Int = when(result){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage1.setImageResource(drawabel_resource)

            val drawabel_resource2 : Int = when(result2){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage2.setImageResource(drawabel_resource2)

            if(result == result2){
                resultTextView3.text = "You Won!"
            }else{
                resultTextView3.text = "Please try again!"
            }
        }
    }

    private fun rollDice(): Int{
        val dice = Dice(6)
        val diceRoll : Int = dice.roll()
        return diceRoll
    }
}

class Dice(val numSides : Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}