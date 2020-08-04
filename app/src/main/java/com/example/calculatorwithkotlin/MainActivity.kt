package com.example.calculatorwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var isNewOperation = true
    fun buttonNumberEvent(view: View) {

        if (isNewOperation) {
            show_result_textView.text = ""
        }
        isNewOperation = false

        var showResult: String = show_result_textView.text.toString();
        val selectedButton = view as Button

        when (selectedButton.id) {
            zero_button.id -> {
                showResult += "0"
            }
            one_button.id -> {
                showResult += "1"
            }
            two_button.id -> {
                showResult += "2"
            }
            three_button.id -> {
                showResult += "3"
            }
            four_button.id -> {
                showResult += "4"
            }
            five_button.id -> {
                showResult += "5"
            }
            six_button.id -> {
                showResult += "6"
            }
            seven_button.id -> {
                showResult += "7"
            }
            eight_button.id -> {
                showResult += "8"
            }
            nine_button.id -> {
                showResult += "9"
            }
            dot_button.id -> {
                showResult += "."
            }
            negative_or_positive_button.id -> {
                showResult = "-$showResult"
            }
        }
        show_result_textView.text = showResult
    }

    var oldNumber = "0"
    var operation = ""
    fun buttonOperation(view: View) {
        oldNumber = show_result_textView.text.toString()
        isNewOperation = true
        val selectedButton = view as Button
        when (selectedButton.id) {
            plus_button.id -> {
                operation = "+"
            }
            sub_button.id -> {
                operation = "-"
            }
            mul_button.id -> {
                operation = "*"
            }
            div_button.id -> {
                operation = "/"
            }
            mod_button.id -> {
                operation = "%"
            }
        }

    }

    fun buttonResult(view: View) {
        var newNumber = show_result_textView.text.toString()
        var finalNumber: Double? = null
        when (operation) {
            "+" -> {
                finalNumber = newNumber.toDouble() + oldNumber.toDouble()

            }
            "-" -> {
                finalNumber = newNumber.toDouble() - oldNumber.toDouble()
            }
            "*" -> {
                finalNumber = newNumber.toDouble() * oldNumber.toDouble()

            }
            "/" -> {
                finalNumber = newNumber.toDouble() / oldNumber.toDouble()

            }
            "%" -> {
                finalNumber = newNumber.toDouble() % oldNumber.toDouble()

            }
        }
        show_result_textView.text = finalNumber.toString()
        isNewOperation = true
    }

    fun buttonClear(view: View) {
        isNewOperation = true
        show_result_textView.text = "0"
        oldNumber = "0"


    }

}


