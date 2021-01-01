package com.example.pomodoropracticeapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        etChangeWork.setText((TimeDatas.defaultWork/60000).toString())
        etChangeShort.setText((TimeDatas.defaultShort/60000).toString())
        etChangeLong.setText((TimeDatas.defaultLong/60000).toString())

        btChangeWork.setOnClickListener {
            TimeDatas.defaultWork = etChangeWork.text.toString().toLong()*60000
        }

        btChangeShort.setOnClickListener {
            TimeDatas.defaultShort = etChangeShort.text.toString().toLong()*60000
        }

        btChangeLong.setOnClickListener {
            TimeDatas.defaultLong = etChangeLong.text.toString().toLong()*60000
        }


        btGithub.setOnClickListener{
            val intenting = Intent(Intent.ACTION_VIEW)
            intenting.data = Uri.parse("https://github.com/yeocak/PomodoroPracticeApp")
            startActivity(intenting)
        }
        btPomodoro.setOnClickListener{
            val intenting = Intent(Intent.ACTION_VIEW)
            intenting.data = Uri.parse("https://en.wikipedia.org/wiki/Pomodoro_Technique")
            startActivity(intenting)
        }
    }

    fun goBack(v: View){
        val intenting = Intent(this,MainActivity::class.java)
        startActivity(intenting)
    }
}