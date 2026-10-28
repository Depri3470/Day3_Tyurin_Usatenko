package com.depri.day3_tyurin_usatenko

import android.graphics.Color
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val switchDarkMode = findViewById<Switch>(R.id.darkThemeSwitch)
        val mainLayout = findViewById<ConstraintLayout>(R.id.main)

        switchDarkMode.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                mainLayout.setBackgroundColor(Color.BLACK)
                findViewById<TextView>(R.id.tvDescription).setTextColor(Color.WHITE)
            } else {
                mainLayout.setBackgroundColor(Color.WHITE)
                findViewById<TextView>(R.id.tvDescription).setTextColor(Color.BLACK)
            }
            }
        }
}