package com.ojwang.allan.studystudio

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ojwang.allan.studystudio.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        assignNewNumb()
        binding.leftBtn.setOnClickListener {
            checkAnswer(true)
            assignNewNumb()
        }

        binding.rightBtn.setOnClickListener {
            checkAnswer(false)
            assignNewNumb()
        }

        //END OF CLASS MAIN
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean){
        val leftNumb = binding.leftBtn.text.toString().toInt()
        val rightNumb = binding.rightBtn.text.toString().toInt()
        // Below is a ternary statement
        val isAnswerCorrect = if (isLeftButtonSelected) leftNumb > rightNumb else rightNumb > leftNumb
        if (isAnswerCorrect){
            binding.bg.setBackgroundColor(Color.GREEN)

            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()
        }else{
            binding.bg.setBackgroundColor(Color.RED)

            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNewNumb() {
        val r = Random()
        val leftNumb = r.nextInt(10)
        var rightNumb = leftNumb
        while (rightNumb==leftNumb){
            rightNumb =r.nextInt(10)
        }
        binding.leftBtn.text = leftNumb.toString()
        binding.rightBtn.text = rightNumb.toString()
    }
}