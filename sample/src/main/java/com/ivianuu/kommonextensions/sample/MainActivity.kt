package com.ivianuu.kommonextensions.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ivianuu.kommonextensions.isStatusBarTransparent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isStatusBarTransparent = true

    }
}
