/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_articles)
    }

    fun onArticleSelected(position: Int) {
        System.out.println("CAN YOU SEE THIS")

        val CtoF = CtoF();
        val FtoC = FtoC();
        val help = Help();

        Log.i("FindThis","Position: $position")

        when (position) {
            0 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLarticle_fragment, CtoF)
                commit()
            }
            1 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLarticle_fragment, FtoC)
                commit()
            }
            2 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLarticle_fragment, help)
                commit()
            }
        }
        // Call a method in the ArticleFragment to update its content
        //articleFrag.updateArticleView(position);

        //TextView article = findViewById(R.id.article);
        //article.setText(Ipsum.Articles[position]);
    }

    fun convertToFahrenheit(view: android.view.View) {
        val text = findViewById<View>(R.id.celsiusValue) as EditText
        val celsiusValue = text.text.toString().toDouble()
        val fahrenheitValue = (celsiusValue * 1.8) + 32
        val cText = String.format("%.2f", celsiusValue)
        val fText = String.format("%.2f", fahrenheitValue)
        val result = findViewById<View>(R.id.result) as TextView
        val resultText = "Temperature $cText (C) is $fText (F)"
        result.text = resultText
    }

    fun convertToCelsius(view: android.view.View) {
        val text = findViewById<View>(R.id.fahrenheitValue) as EditText
        val fahrenheitValue = text.text.toString().toDouble()
        val celsiusValue = (fahrenheitValue - 32) * (0.555555555555555555)
        val cText = String.format("%.2f", fahrenheitValue)
        val fText = String.format("%.2f", celsiusValue)
        val result = findViewById<View>(R.id.result) as TextView
        val resultText = "Temperature $cText (F) is $fText (C)"
        result.text = resultText
    }
}