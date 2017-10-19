package com.ivianuu.kommonextensions.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ivianuu.kommonextensions.setTransparentSystemBars

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
