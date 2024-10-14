package com.example.a78_checkboxsnackbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputInfoET: EditText
    private lateinit var outputInfoTV: TextView

    private lateinit var saveBTN: Button
    private lateinit var deleteBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputInfoET = findViewById(R.id.inputInfoET)
        outputInfoTV = findViewById(R.id.outputInfoTV)

        saveBTN = findViewById(R.id.saveBTN)
        deleteBTN = findViewById(R.id.deleteBTN)

        saveBTN.setOnClickListener(this)
        deleteBTN.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View) {
        if (inputInfoET.text.isEmpty()) {
            return
        }

        when (v.id) {
            R.id.saveBTN -> {
                val text = inputInfoET.text
                outputInfoTV.text = text
            }

            R.id.deleteBTN -> {
                Snackbar.make(v, "Подтвердить удаление", Snackbar.LENGTH_LONG)
                    .setAction("Удалить") {
                        inputInfoET.text.clear()
                        outputInfoTV.text = ""
                        Snackbar.make(v, "Данные удалены", Snackbar.LENGTH_LONG).show()
                    }.show()
            }
        }
    }
}