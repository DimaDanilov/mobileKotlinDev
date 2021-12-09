package com.example.lab5danilov

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {

    //Контекст для TextView
    lateinit var context: Context

    //LinearLayout в который будут вставляться новые TextView активити
    var linearLayout: LinearLayout? = null

    //Список элементов для отображения в активити
    var textListData = arrayOf(
        "Element 1", "Element 2",
        "Element 3", "Element 4",
        "Element 5", "Element 6",
        "Element 7", "Element 8",
        "Element 9", "Element 10"
    )

    //Текущий элемент(счетчик)
    var currentElement = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.textListField)

        DimaAsyncTask().execute()
    }

    inner class DimaAsyncTask() : AsyncTask<Void, Void, Void>() {
        private fun printTextInTextView(textToPrint: String){
            var textView = TextView(context)
            textView.setText(textToPrint)
            linearLayout?.addView(textView)
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate()
            printTextInTextView(textListData[currentElement])
            currentElement++
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            for (i in textListData) {
                TimeUnit.SECONDS.sleep(2)
                publishProgress()
            }
            return null
        }
    }
}