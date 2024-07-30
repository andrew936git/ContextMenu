package com.example.contextmenu

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val random = Random
    private lateinit var randomButtonBT: Button
    private lateinit var textET: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textET = findViewById(R.id.textET)
        registerForContextMenu(textET)

        randomButtonBT = findViewById(R.id.randomButtonBT)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }



    override fun onContextItemSelected(item: MenuItem): Boolean {
        val number = textET.getText().toString().toInt()
        when (item.itemId) {
            R.id.menu_change_color -> {
                when (number) {
                    in 1..10 -> textET.setBackgroundColor(Color.RED)
                    in 11..20 -> textET.setBackgroundColor(Color.parseColor("#FF9900"))
                    in 21..30 -> textET.setBackgroundColor(Color.YELLOW)
                    in 31..40 -> textET.setBackgroundColor(Color.GREEN)
                    in 41..50 -> textET.setBackgroundColor(Color.BLUE)
                }
            }

            R.id.menu_exit -> finish()
        }
        return super.onContextItemSelected(item)
    }

    fun onClick(view: View) {

        randomButtonBT.setOnClickListener {
            textET.text.clear()
            textET.setText((random.nextInt(0, 50)).toString())
        }
    }
}