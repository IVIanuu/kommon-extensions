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

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.util.TypedValue
import android.view.animation.Animation
import android.view.animation.AnimationUtils

fun Context.getResAnim(@AnimRes resId: Int) : Animation = AnimationUtils.loadAnimation(this, resId)

fun Context.getResIntArray(@ArrayRes resId: Int) : IntArray = resources.getIntArray(resId)

fun Context.getResStringArray(@ArrayRes resId: Int) : Array<String> =
    resources.getStringArray(resId)

fun Context.getResTextArray(@ArrayRes resId: Int) : Array<CharSequence> =
    resources.getTextArray(resId)

fun Context.getResTypedArray(@ArrayRes resId: Int) : TypedArray = resources.obtainTypedArray(resId)

fun Context.getResBool(@BoolRes resId: Int) : Boolean = resources.getBoolean(resId)

fun Context.getResDimen(@DimenRes resId : Int) : Float = this.resources.getDimension(resId)

@Px
fun Context.getResDimenPx(@DimenRes resId : Int) : Int = this.resources.getDimensionPixelSize(resId)

@Px
fun Context.getResDimenPxOffset(@DimenRes resId : Int) : Int = this.resources.getDimensionPixelOffset(resId)

fun Context.getResFloat(@DimenRes resId: Int) : Float {
    val value = ValueHolder.VALUE
    resources.getValue(resId, value, true)
    return value.float
}

fun Context.getResInt(@IntegerRes resId: Int) : Int = resources.getInteger(resId)

fun Context.getResVectorDrawable(@DrawableRes resId: Int): Drawable =
    VectorDrawableCompat.create(this.resources, resId, this.theme) as Drawable

fun Context.getResBitmap(@DrawableRes resId: Int) : Bitmap = getResDrawable(resId).toBitmap()

@ColorInt
fun Context.getResColor(@ColorRes resId: Int) : Int = ContextCompat.getColor(this, resId)

fun Context.getResColorStateList(resId: Int) : ColorStateList =
    ContextCompat.getColorStateList(this, resId)!!

fun Context.getResDrawable(@DrawableRes resId : Int) : Drawable =
    ContextCompat.getDrawable(this, resId)!!

fun Context.getResFont(@FontRes resId: Int) : Typeface = ResourcesCompat.getFont(this, resId)!!

fun Context.createTintedDrawable(@DrawableRes drawableRes: Int,
                                 @ColorInt color: Int,
                                 mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN): Drawable {
    val drawable = getResDrawable(drawableRes)
    drawable.tint(color, mode)

    return drawable
}

fun Context.createTintedVectorDrawable(@DrawableRes drawableRes: Int,
                                       @ColorInt color: Int,
                                       mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN): Drawable {
    val drawable = getResVectorDrawable(drawableRes)
    drawable.tint(color, mode)

    return drawable
}

object ValueHolder {
    val VALUE = TypedValue()
}