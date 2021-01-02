package com.example.pomodoropracticeapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        etChangeWork.setText((TimeDatas.defaultWork/60000).toString())
        etChangeShort.setText((TimeDatas.defaultShort/60000).toString())
        etChangeLong.setText((TimeDatas.defaultLong/60000).toString())

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
        if(etChangeWork.text.isNotEmpty() && etChangeShort.text.isNotEmpty() && etChangeLong.text.isNotEmpty()){
            TimeDatas.defaultWork = etChangeWork.text.toString().toLong()*60000
            TimeDatas.defaultShort = etChangeShort.text.toString().toLong()*60000
            TimeDatas.defaultLong = etChangeLong.text.toString().toLong()*60000

            val intenting = Intent(this,MainActivity::class.java)
            startActivity(intenting)
        }
        else{
            Toast.makeText(this, "You must fill all the field.", Toast.LENGTH_SHORT).show()
        }


    }
}