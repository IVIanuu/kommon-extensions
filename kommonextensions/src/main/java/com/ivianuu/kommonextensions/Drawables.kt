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

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt

/**
 * Returns this drawable as a bitmap
 */
fun Drawable.toBitmap(config : Bitmap.Config = Bitmap.Config.ARGB_8888) : Bitmap {
    val bitmap: Bitmap

    if (this is BitmapDrawable) {
        if (this.bitmap != null) {
            return this.bitmap
        }
    }

    bitmap = if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
        Bitmap.createBitmap(1, 1, config)
    } else {
        Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config)
    }

    val canvas = Canvas(bitmap)
    setBounds(0, 0, canvas.width, canvas.height)
    draw(canvas)
    return bitmap
}

/**
 * Tints and mutates this drawable
 */
fun Drawable.tint(@ColorInt color: Int,
                  mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN,
                  mutate: Boolean = true) {
    setColorFilter(color, mode)
    if (mutate) {
        mutate()
    }
}