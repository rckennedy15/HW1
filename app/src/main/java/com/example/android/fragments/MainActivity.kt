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
}