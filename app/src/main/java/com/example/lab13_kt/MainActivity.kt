package com.example.lab13_kt

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    private lateinit var mainLayout: ConstraintLayout
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainLayout = findViewById(R.id.main)
        textView = findViewById(R.id.textView1)
        mainLayout.setOnTouchListener(this)

    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        var message: String = ""
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> message = "壓下"
            MotionEvent.ACTION_MOVE -> message = "移動"
            MotionEvent.ACTION_UP -> message = "放開"
            MotionEvent.ACTION_CANCEL -> message = "取消"
        }
        textView.text = "[$message] at [${event.x}, ${event.y}]"

        return true
        // true will receive remaining events
    }


}