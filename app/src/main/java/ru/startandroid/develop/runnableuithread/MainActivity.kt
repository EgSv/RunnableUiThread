package ru.startandroid.develop.runnableuithread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

const val LOG_TAG = "myLogs"

class MainActivity : AppCompatActivity() {

    private var tvInfo: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById<View>(R.id.tvInfo) as TextView

        val t = Thread {
            try {
                Thread.sleep(2000)
                runOnUiThread(runn1)
                Thread.sleep(1000)
                tvInfo!!.postDelayed(runn3, 2000)
                tvInfo!!.post(runn2)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        t.start()
    }
    private var runn1: Runnable = Runnable {
        tvInfo!!.text = "runn1"
    }
    private var runn2: Runnable = Runnable {
        tvInfo!!.text = "runn2"
    }
    private var runn3: Runnable = Runnable {
        tvInfo!!.text = "runn3"
    }
}