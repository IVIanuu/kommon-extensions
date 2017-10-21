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

@file:Suppress("UNCHECKED_CAST")

package com.ivianuu.kommonextensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Inflates the layout res
 */
fun <V : View> ViewGroup.inflate(@LayoutRes res: Int, attachToThis: Boolean = false)
        = LayoutInflater.from(context).inflate(res, this, attachToThis) as V

/**
 * Iterates trough all childs
 */
inline fun ViewGroup.forEach(func: (View) -> Unit) {
    for (i in 0 until childCount) {
        func(getChildAt(i))
    }
}

/**
 * Iterates trough all childs
 */
inline fun ViewGroup.forEachIndexed(func: (Int, View) -> Unit) {
    for (i in 0 until childCount) {
        func(i, getChildAt(i))
    }
}

/**
 * Returns the view at the index
 */
operator fun ViewGroup.get(index: Int) = getChildAt(index)

/**
 * Returns the index of the view
 */
operator fun ViewGroup.get(child: View) = indexOfChild(child)

/**
 * Adds the view
 */
operator fun ViewGroup.plusAssign(child: View) = addView(child)

/**
 * Removes the view
 */
operator fun ViewGroup.minusAssign(child: View) = removeView(child)

/**
 * Returns whether this group contains the view
 */
operator fun ViewGroup.contains(child: View) = get(child) != -1

/**
 * Iterator of a view group
 */
fun ViewGroup.children() = object : Iterable<View> {
    override fun iterator() = object : Iterator<View> {
        var index = 0
        override fun hasNext() = index < childCount
        override fun next() = get(index++)
    }
}