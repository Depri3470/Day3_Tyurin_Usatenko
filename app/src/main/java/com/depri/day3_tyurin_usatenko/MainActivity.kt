package com.depri.day3_tyurin_usatenko

import android.graphics.Color
import android.os.Bundle
import android.widget.CheckBox
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
        val cbReading = findViewById<CheckBox>(R.id.cbReading)
        val cbSports = findViewById<CheckBox>(R.id.cbSports)
        val cbMusic = findViewById<CheckBox>(R.id.cbMusic)
        val userHobbies = findViewById<TextView>(R.id.userHobbies)


        switchDarkMode.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                mainLayout.setBackgroundColor(Color.BLACK)
                findViewById<TextView>(R.id.tvDescription).setTextColor(Color.WHITE)
            } else {
                mainLayout.setBackgroundColor(Color.WHITE)
                findViewById<TextView>(R.id.tvDescription).setTextColor(Color.BLACK)
            }
        }

        fun updateHobbiesText() {
            val hobbies = mutableListOf<String>()

            if (cbReading.isChecked) hobbies.add("Чтение")
            if (cbSports.isChecked) hobbies.add("Спорт")
            if (cbMusic.isChecked) hobbies.add("Музыка")

            if (hobbies.isEmpty()) {
                userHobbies.text = "Выберите ваши увлечения"
            } else {
                userHobbies.text = "Ваши увлечения: ${hobbies.joinToString(", ")}"
            }
        }

        cbReading.setOnCheckedChangeListener { _, _ -> updateHobbiesText() }
        cbSports.setOnCheckedChangeListener { _, _ -> updateHobbiesText() }
        cbMusic.setOnCheckedChangeListener { _, _ -> updateHobbiesText() }
    }
}