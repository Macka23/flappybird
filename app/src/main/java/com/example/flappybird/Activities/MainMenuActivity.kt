package com.example.flappybird.Activities

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.flappybird.R
import com.example.flappybird.Views.SkinManager

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)



        val playButton: Button = findViewById(R.id.playButton)
        val colorPreview: View = findViewById(R.id.colorPreview)
        val colorSlider: SeekBar = findViewById(R.id.colorSlider)
        colorSlider.max = SkinManager.getAvailableColors().lastIndex
        colorSlider.progress = SkinManager.getCurrentIndex()


        colorPreview.post {
            colorPreview.background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(SkinManager.getCurrentColor())
            }
        }

        colorSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                SkinManager.setSkin(progress)
                val drawable = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(SkinManager.getCurrentColor())
                }

                colorPreview.background = drawable
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        playButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
