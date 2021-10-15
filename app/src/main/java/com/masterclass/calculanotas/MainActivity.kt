package com.masterclass.calculanotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masterclass.calculanotas.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.round
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalculete.setOnClickListener {
            btCalculateNote()

        }
    }

    private fun btCalculateNote() {
        val note1 = amount_input1.text.toString()
        val note2 = amount_input2.text.toString()
        val note3 = amount_input3.text.toString()
        caculateNote(note1,note2,note3)


    }

    private fun caculateNote(ac1: String, ac2: String, ac3: String) {
        val validateAc1 = ac1.toDouble()
        val validateAc2 = ac2.toDouble()
        val validateAc3 = ac3.toDouble()

        val resulValidadeNote = validateAc1 + validateAc2 + validateAc3
        val result:Double = resulValidadeNote / 3
        val rounded = String.format("%.2f", result) // rounds to 3 decimal places


        if (rounded >= 5.toString()){
            tvResult.text = "Aprovado$rounded"
        }else{
            tvResult.text = "Reprovado$rounded"
        }

    }

}