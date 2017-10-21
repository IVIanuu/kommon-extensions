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
import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.app.ActivityCompat
import android.view.View
import android.view.WindowManager
import android.widget.EditText

/**
 * The content view of this activity
 */
val Activity.contentView: View
    get() = findViewById(android.R.id.content)

// START ACTIVITY

/**
 * Starts the activity
 */
inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(createIntent<T>())
}

/**
 * Starts the activity and calls the initializer on intent creation
 */
inline fun <reified T : Activity> Activity.startActivity(initializer: Intent.() -> Unit) {
    val intent = createIntent<T>(initializer)
    startActivity(intent)
}

// START SERVICE

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
 * Sets the status and navigation bar color
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setSystemBarColor(@ColorInt color: Int) {
    setStatusBarColor(color)
    setNavigationBarColor(color)
}

/**
 * Sets the status and navigation bar color on lollipop and above
 */
fun Activity.supportSetSystemBarColor(@ColorInt color: Int) {
    if (isLollipop) {
        setSystemBarColor(color)
    }
}

/**
 * Sets system bars translucent
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
fun Activity.setTranslucentSystemBars(enabled: Boolean = true) {
    setTranslucentStatusBar(enabled)
    setTranslucentNavigationBar(enabled)
}

/**
 * Sets the system bars translucent on kitkat and above
 */
fun Activity.supportSetTranslucentSystemBars(enabled: Boolean = true) {
    if (isKitkat) {
        setTranslucentSystemBars(enabled)
    }
}

/**
 * Sets system bars transparent
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setTransparentSystemBars(enabled: Boolean = true) {
    setTransparentStatusBar(enabled)
    setTransparentNavigationBar(enabled)
}

/**
 * Sets the system bars transparent on lollipop and above
 */
fun Activity.supportSetTransparentSystemBars(enabled: Boolean = true) {
    if (isLollipop) {
        setTransparentSystemBars(enabled)
    }
}

/**
 * Sets system bars hidden
 */
fun Activity.setSystemBarsHidden(hidden: Boolean = true) {
    setStatusBarHidden(hidden)
    setNavigationBarHidden(hidden)
}

/**
 * Sets system bars light
 */
@TargetApi(Build.VERSION_CODES.O)
fun Activity.setSystemBarsLight(enabled: Boolean = true) {
    setLightStatusBar(enabled)
    setLightNavigationBar(enabled)
}

/**
 * Sets the system bars light on oreo and above
 */
fun Activity.supportSetSystemBarsLight(enabled: Boolean = true) {
    if (isOreo) {
        setSystemBarsLight(enabled)
    }
}

// STATUS BAR

/**
 * Sets the status bar color
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.statusBarColor = color
}

/**
 * Sets the status bar color on lollipop and above
 */
fun Activity.supportSetStatusBarColor(@ColorInt color: Int) {
    if (isLollipop) {
        setStatusBarColor(color)
    }
}

/**
 * Sets the status bar light based on passed boolean
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
 * Sets the status bar light on marshmallow and above
 */
fun Activity.supportSetLightStatusBar(enabled: Boolean = true) {
    if (isMarshmallow) {
        setLightStatusBar(enabled)
    }
}

/**
 * Sets draw under status bar enabled
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
fun Activity.setDrawUnderStatusBar(enabled: Boolean = true) {
    val decorView = window.decorView
    val systemUiVisibility = decorView.systemUiVisibility
    val flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    if (enabled) {
        decorView.systemUiVisibility = systemUiVisibility or flags
    } else {
        decorView.systemUiVisibility = systemUiVisibility and flags.inv()
    }
}

/**
 * Sets draw under status on jelly bean and above
 */
fun Activity.supportSetDrawUnderStatusBar(enabled: Boolean = true) {
    if (isJellyBean) {
        setDrawUnderStatusBar(enabled)
    }
}

/**
 * Sets the status bar translucent
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
fun Activity.setTranslucentStatusBar(enabled: Boolean = true) {
    val winParams = window.attributes
    if (enabled) {
        winParams.flags = winParams.flags or WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
    } else {
        winParams.flags = winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
    }
}

/**
 * Sets the status bar translucent on kitkat and above
 */
fun Activity.supportSetTranslucentStatusBar(enabled: Boolean = true) {
    if (isKitkat) {
        setTranslucentStatusBar(enabled)
    }
}

/**
 * Sets the status bar transparent
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setTransparentStatusBar(enabled: Boolean = true) {
    if (enabled) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        setStatusBarColor(Color.TRANSPARENT)
    } else {
        window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    }

    setDrawUnderStatusBar(enabled)
}

/**
 * Sets the status bar transparent on lollipop and above
 */
fun Activity.supportSetTransparentStatusBar(enabled: Boolean = true) {
    if (isLollipop) {
        setTransparentStatusBar(enabled)
    }
}

/**
 * Sets the status bar hidden
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
 * Sets the navigation bar color
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setNavigationBarColor(@ColorInt color: Int) {
    window.navigationBarColor = color
}

/**
 * Sets the navigation bar color on lollipop and above
 */
fun Activity.supportSetNavigationBarColor(@ColorInt color: Int) {
    if (isLollipop) {
        setNavigationBarColor(color)
    }
}

/**
 * Sets the navigation bar translucent
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
fun Activity.setTranslucentNavigationBar(enabled: Boolean = true) {
    val winParams = window.attributes
    if (enabled) {
        winParams.flags = winParams.flags or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
    } else {
        winParams.flags = winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION.inv()
    }
}

/**
 * Sets the navigation bar translucent on kitkat and above
 */
fun Activity.supportSetTranslucentNavigationBar(enabled: Boolean = true) {
    if (isKitkat) {
        setTranslucentNavigationBar(enabled)
    }
}

/**
 * Sets the navigation bar transparent
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setTransparentNavigationBar(enabled: Boolean = true) {
    if (enabled) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    } else {
        window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
}

/**
 * Sets the navigation bar transparent on lollipop and above
 */
fun Activity.supportSetTransparentNavigationBar(enabled: Boolean = true) {
    if (isLollipop) {
        setTransparentNavigationBar(enabled)
    }
}

/**
 * Sets the navigation bar hidden
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
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

/**
 * Sets the navigation bar hidden on kitkat
 */
fun Activity.supportSetNavigationBarHidden(enabled: Boolean = true) {
    if (isKitkat) {
        setNavigationBarHidden(enabled)
    }
}

/**
 * Sets the navigation bar light based on passed boolean
 */
@TargetApi(Build.VERSION_CODES.O)
fun Activity.setLightNavigationBar(enabled: Boolean = true) {
    val decorView = window.decorView
    val systemUiVisibility = decorView.systemUiVisibility
    if (enabled) {
        decorView.systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
    } else {
        decorView.systemUiVisibility = systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
    }
}

/**
 * Sets the navigation bar light on oreo and above
 */
fun Activity.supportSetLightNavigationBar(enabled: Boolean = true) {
    if (isOreo) {
        setLightNavigationBar(enabled)
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
