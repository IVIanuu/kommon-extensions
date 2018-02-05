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
import android.graphics.Color
import android.os.Build
import android.support.annotation.ColorInt
import android.view.View
import android.view.WindowManager

fun Activity.setSystemBarColor(@ColorInt color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        setStatusBarColor(color)
        setNavigationBarColor(color)
    }
}

fun Activity.setTranslucentSystemBars(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        setTranslucentStatusBar(enabled)
        setTranslucentNavigationBar(enabled)
    }
}

fun Activity.setTransparentSystemBars(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        setTransparentSystemBars(enabled)
    }
}

fun Activity.setSystemBarsHidden(hidden: Boolean = true) {
    setStatusBarHidden(hidden)
    setNavigationBarHidden(hidden)
}

fun Activity.setSystemBarsLight(enabled: Boolean = true) {
    setLightStatusBar(enabled)
    setLightNavigationBar(enabled)
}

fun Activity.setStatusBarColor(@ColorInt color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = color
    }
}

fun Activity.setLightStatusBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val decorView = window.decorView
        val systemUiVisibility = decorView.systemUiVisibility
        if (enabled) {
            decorView.systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            decorView.systemUiVisibility = systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
    }
}

fun Activity.setDrawUnderStatusBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        val decorView = window.decorView
        val systemUiVisibility = decorView.systemUiVisibility
        val flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        if (enabled) {
            decorView.systemUiVisibility = systemUiVisibility or flags
        } else {
            decorView.systemUiVisibility = systemUiVisibility and flags.inv()
        }
    }
}

fun Activity.setTranslucentStatusBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        val winParams = window.attributes
        if (enabled) {
            winParams.flags = winParams.flags or WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        } else {
            winParams.flags = winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
        }
    }
}

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

fun Activity.setStatusBarHidden(hidden: Boolean = true) {
    if (hidden) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    } else {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}

fun Activity.setNavigationBarColor(@ColorInt color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.navigationBarColor = color
    }
}

fun Activity.setTranslucentNavigationBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        val winParams = window.attributes
        if (enabled) {
            winParams.flags = winParams.flags or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        } else {
            winParams.flags = winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION.inv()
        }
    }
}

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

fun Activity.setNavigationBarHidden(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
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
}

fun Activity.setLightNavigationBar(enabled: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val decorView = window.decorView
        val systemUiVisibility = decorView.systemUiVisibility
        if (enabled) {
            decorView.systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        } else {
            decorView.systemUiVisibility = systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
        }
    }
}