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
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.AttrRes
import android.support.annotation.ColorInt
import android.support.annotation.Dimension
import android.support.annotation.Px

inline fun Context.resolveBooleanAttr(@AttrRes attr: Int): Boolean = resolveBooleanAttr(attr, false)

inline fun Context.resolveBooleanAttr(@AttrRes attr: Int, defaultValue: Boolean): Boolean {
    val array = getTypedArrayWithAttributes(attr)
    val bool = array.getBoolean(0, defaultValue)
    array.recycle()
    return bool
}

@ColorInt
inline fun Context.resolveColorAttr(@AttrRes attr: Int): Int = resolveColorAttr(attr, -1)

@ColorInt
inline fun Context.resolveColorAttr(@AttrRes attr: Int, @ColorInt defaultValue: Int): Int {
    val array = getTypedArrayWithAttributes(attr)
    val color = array.getColor(0, defaultValue)
    array.recycle()
    return color
}

inline fun Context.resolveColorStateListAttr(@AttrRes attr: Int): ColorStateList? =
        resolveColorStateListAttr(attr, null)

inline fun Context.resolveColorStateListAttr(@AttrRes attr: Int,
                                      defaultValue: ColorStateList?): ColorStateList? {
    val array = getTypedArrayWithAttributes(attr)
    val colorStateList = array.getColorStateList(0)
    array.recycle()
    return colorStateList ?: defaultValue
}

@Dimension
inline fun Context.resolveDimensionAttr(@AttrRes attr: Int): Float = resolveDimensionAttr(attr, -1f)

@Dimension
inline fun Context.resolveDimensionAttr(@AttrRes attr: Int, @Dimension defaultValue: Float): Float {
    val array = getTypedArrayWithAttributes(attr)
    val dimension = array.getDimension(0, defaultValue)
    array.recycle()
    return dimension
}

@Px
inline fun Context.resolveDimensionPixelOffsetAttr(@AttrRes attr: Int): Int =
        resolveDimensionPixelOffsetAttr(attr, -1)

@Px
inline fun Context.resolveDimensionPixelOffsetAttr(@AttrRes attr: Int, @Px defaultValue: Int): Int {
    val array = getTypedArrayWithAttributes(attr)
    val dimension = array.getDimensionPixelOffset(0, defaultValue)
    array.recycle()
    return dimension
}

@Px
inline fun Context.resolveDimensionPixelSizeAttr(@AttrRes attr: Int): Int =
        resolveDimensionPixelSizeAttr(attr, -1)

@Px
inline fun Context.resolveDimensionPixelSizeAttr(@AttrRes attr: Int, @Px defaultValue: Int): Int {
    val array = getTypedArrayWithAttributes(attr)
    val dimension = array.getDimensionPixelSize(0, defaultValue)
    array.recycle()
    return dimension
}

inline fun Context.resolveDrawableAttr(@AttrRes attr: Int): Drawable? = resolveDrawableAttr(attr, null)

inline fun Context.resolveDrawableAttr(@AttrRes attr: Int, defaultValue: Drawable?): Drawable? {
    val array = getTypedArrayWithAttributes(attr)
    val drawable = array.getDrawable(0)
    array.recycle()
    return drawable ?: defaultValue
}

inline fun Context.resolveFloatAttr(@AttrRes attr: Int): Float = resolveFloatAttr(attr, -1f)

inline fun Context.resolveFloatAttr(@AttrRes attr: Int, defaultValue: Float): Float {
    val array = getTypedArrayWithAttributes(attr)
    val floatValue = array.getFloat(0, defaultValue)
    array.recycle()
    return floatValue
}

inline fun Context.resolveFontAttr(@AttrRes attr: Int): Typeface? = resolveFontAttr(attr, null)

@TargetApi(Build.VERSION_CODES.O)
inline fun Context.resolveFontAttr(@AttrRes attr: Int, defaultValue: Typeface?): Typeface? {
    val array = getTypedArrayWithAttributes(attr)
    val font = array.getFont(0)
    array.recycle()
    return font ?: defaultValue
}

inline fun Context.resolveIntAttr(@AttrRes attr: Int): Int = resolveIntAttr(attr, -1)

inline fun Context.resolveIntAttr(@AttrRes attr: Int, defaultValue: Int): Int {
    val array = getTypedArrayWithAttributes(attr)
    val intValue = array.getInt(0, defaultValue)
    array.recycle()
    return intValue
}

inline fun Context.resolveIntegerAttr(@AttrRes attr: Int): Int = resolveIntegerAttr(attr, -1)

inline fun Context.resolveIntegerAttr(@AttrRes attr: Int, defaultValue: Int?): Int {
    val array = getTypedArrayWithAttributes(attr)
    val integer = array.getInteger(0, defaultValue!!)
    array.recycle()
    return integer
}

inline fun Context.resolveStringAttr(@AttrRes attr: Int): String? = resolveStringAttr(attr, null)

inline fun Context.resolveStringAttr(@AttrRes attr: Int, defaultValue: String?): String? {
    val array = getTypedArrayWithAttributes(attr)
    val string = array.getString(0)
    array.recycle()
    return string ?: defaultValue
}

inline fun Context.resolveTextAttr(@AttrRes attr: Int): CharSequence? = resolveStringAttr(attr, null)

inline fun Context.resolveTextAttr(@AttrRes attr: Int, defaultValue: CharSequence?): CharSequence? {
    val array = getTypedArrayWithAttributes(attr)
    val charSequence = array.getText(0)
    array.recycle()
    return charSequence ?: defaultValue
}

inline fun Context.resolveTextArrayAttr(@AttrRes attr: Int): Array<CharSequence>? =
        resolveTextArrayAttr(attr, null)

inline fun Context.resolveTextArrayAttr(@AttrRes attr: Int,
                                 defaultValue: Array<CharSequence>?): Array<CharSequence>? {
    val array = getTypedArrayWithAttributes(attr)
    val charSequence = array.getTextArray(0)
    array.recycle()
    return charSequence ?: defaultValue
}
 
inline fun Context.getTypedArrayWithAttributes(vararg attr: Int): TypedArray =
        theme.obtainStyledAttributes(attr)