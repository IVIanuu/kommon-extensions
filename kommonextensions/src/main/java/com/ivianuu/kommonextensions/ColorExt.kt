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

import android.graphics.Color
import android.support.annotation.ColorInt

inline fun String.toColorInt(): Int = Color.parseColor(this)

inline fun Int.stripAlpha(): Int = 0xff000000.toInt() or this

inline fun Int.shift(by: Float): Int {
    if (by == 1f) return this
    val alpha = Color.alpha(this)
    val hsv = FloatArray(3)
    Color.colorToHSV(this, hsv)
    hsv[2] *= by
    return (alpha shl 24) + (0x00ffffff and Color.HSVToColor(hsv))
}

inline fun Int.darken(): Int = shift(0.9f)

inline fun Int.lighten(): Int = shift(1.1f)

inline fun Int.isDark() = !isLight()

inline fun Int.isLight(): Boolean {
    val darkness =
            1 - (0.299 * Color.red(this)
                    + 0.587 * Color.green(this)
                    + 0.114 * Color.blue(this)) / 255
    return darkness < 0.4
}

inline fun Int.invert(): Int {
    val r = 255 - Color.red(this)
    val g = 255 - Color.green(this)
    val b = 255 - Color.blue(this)
    return Color.argb(Color.alpha(this), r, g, b)
}

inline fun Int.adjustAlpha(factor: Float): Int {
    val alpha = Math.round(Color.alpha(this) * factor)
    val red = Color.red(this)
    val green = Color.green(this)
    val blue = Color.blue(this)
    return Color.argb(alpha, red, green, blue)
}

inline fun Int.withAlpha(alpha: Float): Int {
    val a = Math.min(255, Math.max(0, (alpha * 255).toInt())) shl 24
    val rgb = 0x00ffffff and this
    return a + rgb
}

inline fun Int.blendWith(other: Int, ratio: Float): Int {
    val inverseRatio = 1f - ratio
    val a = Color.alpha(this) * inverseRatio + Color.alpha(other) * ratio
    val r = Color.red(this) * inverseRatio + Color.red(other) * ratio
    val g = Color.green(this) * inverseRatio + Color.green(other) * ratio
    val b = Color.blue(this) * inverseRatio + Color.blue(other) * ratio
    return Color.argb(a.toInt(), r.toInt(), g.toInt(), b.toInt())
}