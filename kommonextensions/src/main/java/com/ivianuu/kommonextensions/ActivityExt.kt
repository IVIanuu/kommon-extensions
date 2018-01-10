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

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.support.v4.app.ActivityCompat
import android.view.View

inline val Activity.contentView: View
    get() = findViewById(android.R.id.content)

// START ACTIVITY

inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(createIntent<T>())
}

inline fun <reified T : Activity> Activity.startActivity(initializer: Intent.() -> Unit) {
    val intent = createIntent<T>(initializer)
    startActivity(intent)
}

// START SERVICE

// KEYBOARD

inline fun Activity.hideInputMethod() {
    inputMethodManager.hideSoftInputFromWindow(window.peekDecorView().windowToken, 0)
}

inline fun Activity.showInputMethod(view: View) {
    inputMethodManager.showSoftInput(view, 0)
}

// FINISHING

inline fun Activity.finishWithoutTransition() {
    overridePendingTransition(0, 0)
    finish()
}

inline fun Activity.supportFinishAfterTransition() {
    ActivityCompat.finishAfterTransition(this)
}

inline fun Activity.supportFinishAffinity() {
    ActivityCompat.finishAffinity(this)
}

inline fun Activity.finishWithResult(resultCode: Int, data: Intent? = null) {
    setResult(resultCode, data)
    finish()
}

// LOCK ORIENTATION

inline fun Activity.lockCurrentScreenOrientation(orientation: Int = resources.configuration.orientation) {
    requestedOrientation = when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        else -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
    }
}

inline fun Activity.unlockScreenOrientation() {
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
}
