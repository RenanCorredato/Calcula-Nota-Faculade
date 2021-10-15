package com.masterclass.calculanotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
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
        //Recupendo valores digitados
        val note1 = amount_input1.text.toString()
        val note2 = amount_input2.text.toString()
        val note3 = amount_input3.text.toString()

        val validateField = fieldValidate(
            ac1 = note1,
            ac2 = note2,
            ac3 = note3)

        if (validateField){
            caculateNote(note1,note2,note3)
        }else{
            tvResult.text = "Preencha os Campos"
        }

    }

    private fun fieldValidate(ac1: String, ac2: String, ac3: String): Boolean {
        //Validando Campos
        var validateField = true

        if (ac1 == "") {
            validateField = false
        } else if (ac2 == "") {
            validateField = false
        } else if (ac3 == "") {

        }
        return validateField
    }

    private fun caculateNote(ac1: String, ac2: String, ac3: String) {
        //Convertendo valores string para numeros
        val validateAc1 = ac1.toDouble()
        val validateAc2 = ac2.toDouble()
        val validateAc3 = ac3.toDouble()

        val resulValidadeNote = validateAc1 + validateAc2 + validateAc3
        val result: Double = resulValidadeNote / 3
        val rounded = String.format("%.2f", result) // rounds to 3 decimal places


        if (rounded >= 5.toString()) {
            tvResult.text = "Aprovado:$rounded"
        } else {
            tvResult.text = "Reprovado:$rounded"
        }

    }


}