/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.kommonextensions

import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.app.ActivityCompat
import android.view.View
import android.view.WindowManager
import android.widget.EditText

/**
 * Returns the root view of this activity
 */
val Activity.rootView: View
    get() = findViewById(android.R.id.content)

// START ACTIVITY

/**
 * Starts the activity
 */
inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

// KEYBOARD

/**
 * Hides the soft input
 */
fun Activity.hideInputMethod() {
    inputMethodManager.hideSoftInputFromWindow(window.peekDecorView().windowToken, 0)
}

/**
 * Shows the soft input
 */
fun Activity.showInputMethod(v: EditText) {
    inputMethodManager.showSoftInput(v, 0)
}

// SYSTEM BARS

/**
 * Set' status and navigation bar color
 */
fun Activity.setSystemBarColor(@ColorInt color: Int) {
    setStatusBarColor(color)
    setNavigationBarColor(color)
}

/**
 * Set's system bars translucent
 */
fun Activity.setTranslucentSystemBars(enabled: Boolean = true) {
    setTranslucentStatusBar(enabled)
    setTranslucentNavigationBar(enabled)
}

/**
 * Set's system bars transparent
 */
fun Activity.setTransparentSystemBars(enabled: Boolean = true) {
    setTransparentStatusBar(enabled)
    setTransparentNavigationBar(enabled)
}

/**
 * Set's system bars hidden
 */
fun Activity.setSystemBarsHidden(hidden: Boolean = true) {
    setStatusBarHidden(hidden)
    setNavigationBarHidden(hidden)
}

// STATUS BAR

/**
 * Set's status bar color
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.statusBarColor = color
}

/**
 * Set's status bar light based on passed boolean
 */
@TargetApi(Build.VERSION_CODES.M)
fun Activity.setLightStatusBar(enabled: Boolean = true) {
    val decorView = window.decorView
    val systemUiVisibility = decorView.systemUiVisibility
    if (enabled) {
        decorView.systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else {
        decorView.systemUiVisibility = systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
    }
}

/**
 * Set's draw under status bar enabled
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
fun Activity.setDrawUnderStatusBar(enabled: Boolean = true) {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
}

/**
 * Set's status bar translucent
 */
@TargetApi(19)
fun Activity.setTranslucentStatusBar(enabled: Boolean = true) {
    val winParams = window.attributes
    if (enabled) {
        winParams.flags = winParams.flags or WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
    } else {
        winParams.flags = winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
    }
}

/**
 * Set's status bar transparent
 */
fun Activity.setTransparentStatusBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        if (enabled) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            setStatusBarColor(Color.TRANSPARENT)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        }

        setDrawUnderStatusBar(enabled)
    }
}

/**
 * Set's status bar hidden
 */
fun Activity.setStatusBarHidden(hidden: Boolean = true) {
    if (hidden) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    } else {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}

// NAVIGATION BAR

/**
 * Set's Navigation bar color
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setNavigationBarColor(@ColorInt color: Int) {
    window.navigationBarColor = color
}

/**
 * Set's navigation bar translucent
 */
@TargetApi(19)
fun Activity.setTranslucentNavigationBar(enabled: Boolean = true) {
    val winParams = window.attributes
    if (enabled) {
        winParams.flags = winParams.flags or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
    } else {
        winParams.flags = winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION.inv()
    }
}

/**
 * Set's navigation bar transparent
 */
@TargetApi(21)
fun Activity.setTransparentNavigationBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        if (enabled) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
    }
}

/**
 * Set's navigation bar hidden
 */
@TargetApi(19)
fun Activity.setNavigationBarHidden(enabled: Boolean = true) {
    val decorView = window.decorView
    var systemUiVisibility = decorView.systemUiVisibility
    if (enabled) {
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    } else {
        systemUiVisibility = systemUiVisibility and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION.inv()
        systemUiVisibility = systemUiVisibility and View.SYSTEM_UI_FLAG_IMMERSIVE.inv()
        systemUiVisibility = systemUiVisibility and View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY.inv()
        decorView.systemUiVisibility = systemUiVisibility
    }
}

// FINISHING

/**
 * Finishes without a transition
 */
fun Activity.finishWithoutTransition() {
    overridePendingTransition(0, 0)
    finish()
}

/**
 * Finishes after transition
 */
fun Activity.supportFinishAfterTransition() {
    ActivityCompat.finishAfterTransition(this)
}

/**
 * Finishes the task affinity
 */
fun Activity.supportFinishAffinity() {
    ActivityCompat.finishAffinity(this)
}
