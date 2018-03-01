package com.ivianuu.kommonextensions.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ivianuu.kommonextensions.doOnDestroy
import com.ivianuu.kommonextensions.doOnPause
import com.ivianuu.kommonextensions.isStatusBarTransparent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isStatusBarTransparent = true

        lifecycle.doOnPause {
            Log.d("testt", "pause")
        }

        lifecycle.doOnDestroy {
            Log.d("testt", "on destroy")
        }
    }
}
