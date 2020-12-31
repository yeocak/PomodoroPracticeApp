package com.example.pomodoropracticeapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    /* TODO
    * Make other mods
    * Settings tab
    * Add README
    */

    lateinit var timer: CountDownTimer

    private fun starting(timing: Long){
        timer = object: CountDownTimer(timing, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                TimeDatas.nowTime = (millisUntilFinished/1000)*1000
                updateTimer(millisUntilFinished)
            }

            override fun onFinish() {
                btnStartStop.text = "RESTART"
                TimeDatas.isStart = 2
            }
        }
        timer.start()
    }

    private fun updateTimer(seconds: Long){
            var second = seconds/1000
            var minutes = second/60
            second %= 60

            tvTime.text = "${minutes.toString().padStart(2, '0')}:${second.toString().padStart(2, '0')}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(TimeDatas.isStart == 1){
            starting(TimeDatas.nowTime)
            TimeDatas.isStart = 0
        }
    }

    fun startStop(view: View){
        if(TimeDatas.isStart == 0){
            btnStartStop.text = "STOP"
            TimeDatas.isStart = 1
            starting(TimeDatas.nowTime)
        }
        else if(TimeDatas.isStart == 1){
            btnStartStop.text = "START"
            TimeDatas.isStart = 0
            timer.cancel()
        }
        else{
            btnStartStop.text = "START"
            TimeDatas.nowTime = 10000
            updateTimer(TimeDatas.nowTime)
            TimeDatas.isStart = 0
        }
    }

    fun changeModeBefore(view: View){
        btLongBreak.setBackgroundColor(Color.parseColor("#00FFFFFF"))
        btShortBreak.setBackgroundColor(Color.parseColor("#00FFFFFF"))
        btWork.setBackgroundColor(Color.parseColor("#00FFFFFF"))

        view.setBackgroundResource(R.drawable.main_rectang)

        changeMode(view.id)
    }

    private fun changeMode(viewObj: Int){
        when (viewObj) {
            btWork.id -> {
                mainConstraint.setBackgroundColor(Color.parseColor("#D14334"))
                tvExplanation.text = "Time to work!"
            }
            btShortBreak.id -> {
                mainConstraint.setBackgroundColor(Color.parseColor("#B3E099"))
                tvExplanation.text = "Time for short break!"
            }
            btLongBreak.id -> {
                mainConstraint.setBackgroundColor(Color.parseColor("#028F76"))
                tvExplanation.text = "Time for long break!"
            }
        }
    }

}