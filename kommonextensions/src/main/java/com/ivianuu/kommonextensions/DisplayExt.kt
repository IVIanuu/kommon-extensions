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
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.support.annotation.Px
import android.util.DisplayMetrics
import android.view.Surface
import android.view.WindowManager
import androidx.content.systemService

private val systemMetrics: DisplayMetrics get() = Resources.getSystem().displayMetrics
private val displayMetrics = DisplayMetrics()

val Int.dp: Float get() = (this * systemMetrics.density)

val Int.sp: Float get() = (this * systemMetrics.scaledDensity)

val Context.isPortrait: Boolean
    get() = !isLandscape

val Context.isLandscape: Boolean
    get() {
        val rotation = rotation
        return rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270
    }

val Context.rotation: Int
    get() = windowManager.defaultDisplay.rotation

val Context.screenHeight: Int
    get() {
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

val Context.screenWidth: Int
    get() {
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

val Context.realScreenHeight: Int
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() {
        windowManager.defaultDisplay.getRealMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

val Context.realScreenWidth: Int
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() {
        windowManager.defaultDisplay.getRealMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }