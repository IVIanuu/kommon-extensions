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
import android.os.Build
import android.view.View
import android.view.ViewGroup

/**
 * Makes the view visible
 */
fun View.setVisible() {
    visibility = View.VISIBLE
}

/**
 * Makes the view invisible
 */
fun View.setInvisible() {
    visibility = View.INVISIBLE
}

/**
 * Sets the view visibility to gone
 */
fun View.setGone() {
    visibility = View.GONE
}

/**
 * Sets the view visible or gone
 */
fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

/**
 * Sets the view visible or gone
 */
fun View.setVisible(predicate: () -> Boolean) = setVisible(predicate())

/**
 * Returns whether the view is visible
 */
fun View.isVisible() = visibility == View.VISIBLE

/**
 * Returns whether the view is invisible
 */
fun View.isInvisible() = visibility == View.INVISIBLE

/**
 * Returns whether the view is gone
 */
fun View.isGone() = visibility == View.GONE

/**
 * Sets the left padding
 */
fun View.setPaddingLeft(padding: Int) = setPadding(padding, paddingTop, paddingRight, paddingBottom)

/**
 * Sets the right padding
 */
fun View.setPaddingRight(padding: Int) = setPadding(paddingLeft, paddingTop, padding, paddingBottom)

/**
 * Sets the top padding
 */
fun View.setPaddingTop(padding: Int) = setPadding(paddingLeft, padding, paddingRight, paddingBottom)

/**
 * Sets the bottom padding
 */
fun View.setPaddingBottom(padding: Int) = setPadding(paddingLeft, paddingTop, paddingRight, padding)

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun View.setPaddingStart(padding: Int) = setPaddingRelative(padding, paddingTop, paddingEnd, paddingBottom)

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun View.setPaddingEnd(padding: Int) = setPaddingRelative(paddingStart, paddingTop, padding, paddingBottom)

/**
 * Sets the padding to left, top, right and bottom
 */
fun View.setAllPadding(padding: Int) {
    setPadding(padding, padding, padding, padding)
}

/**
 * Sets the values as padding
 */
fun View.setOptionalPadding(left: Int = paddingLeft,
                            top: Int = paddingTop,
                            right: Int = paddingRight,
                            bottom: Int = paddingBottom) {
    setPadding(left, top, right, bottom)
}

/**
 * Sets the values as padding
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun View.setOptionalRelativePadding(start: Int = paddingStart,
                                    top: Int = paddingTop,
                                    end: Int = paddingEnd,
                                    bottom: Int = paddingBottom) {
    setPaddingRelative(start, top, end, bottom)
}

/**
 * The left margin
 */
var View.marginLeft
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.leftMargin ?: 0
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.leftMargin = value }

/**
 * The top margin
 */
var View.marginTop
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.topMargin ?: 0
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.topMargin = value }

/**
 * The right margin
 */
var View.marginRight
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.rightMargin ?: 0
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.rightMargin = value }

/**
 * The bottom margin
 */
var View.marginBottom
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.bottomMargin ?: 0
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.bottomMargin = value }

/**
 * The start margin
 */
var View.marginStart
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.marginStart ?: 0
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.marginStart = value }

/**
 * The end margin
 */
var View.marginEnd
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.marginEnd ?: 0
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.marginEnd = value }

/**
 * Sets the margin to left, top, right and bottom
 */
fun View.setAllMargin(int: Int) {
    setOptionalMargin(int, int, int, int)
}

/**
 * Sets the margin to left, top, right and bottom
 */
fun View.setAllRelativeMargin(int: Int) {
    setOptionalRelativeMargin(int, int, int, int)
}

/**
 * Sets the values as margin
 */
fun View.setOptionalMargin(left: Int = marginLeft,
                           top: Int = marginTop,
                           right: Int = marginRight,
                           bottom: Int = marginBottom) {
    marginLeft = left
    marginTop = top
    marginRight = right
    marginBottom = bottom
}

/**
 * Sets the values as margin
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun View.setOptionalRelativeMargin(start: Int = marginStart,
                                   top: Int = marginTop,
                                   end: Int = marginEnd,
                                   bottom: Int = marginBottom) {
    marginStart = start
    marginTop = top
    marginEnd = end
    marginBottom = bottom
}

/**
 * Sets the height
 */
fun View.setHeight(height: Int) {
    resize(height = height)
}

/**
 * Sets the width
 */
fun View.setWidth(width: Int) {
    resize(width = width)
}

/**
 * Resizes the view
 */
fun View.resize(width: Int = getWidth(), height: Int = getHeight()) {
    val lp = layoutParams

    lp?.let {
        lp.width = width
        lp.height = height
        layoutParams = lp
    }
}