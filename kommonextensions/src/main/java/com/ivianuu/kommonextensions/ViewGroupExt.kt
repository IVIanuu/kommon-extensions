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

inline fun <V : View> ViewGroup.inflate(@LayoutRes res: Int, attachToThis: Boolean = false)
        = LayoutInflater.from(context).inflate(res, this, attachToThis) as V

operator inline fun ViewGroup.get(index: Int) = getChildAt(index)

inline fun ViewGroup.getOrNull(index: Int): View? = if (index in 0..lastIndex()) getChildAt(index) else null

operator inline fun ViewGroup.get(child: View) = indexOfChild(child)

operator inline fun ViewGroup.plusAssign(child: View) = addView(child)

operator inline fun ViewGroup.minusAssign(child: View) = removeView(child)

operator inline fun ViewGroup.contains(child: View) = get(child) != -1

inline fun ViewGroup.childs(): List<View> = (0 until childCount).map { getChildAt(it) }

inline fun ViewGroup.firstChild(): View = this[0]
inline fun ViewGroup.firstChildOrNull(): View? = if (isEmpty()) null else firstChild()
inline fun ViewGroup.lastChild(): View = this[lastIndex()]
inline fun ViewGroup.lastChildOrNull(): View? = if (isEmpty()) null else lastChild()

inline fun ViewGroup.isEmpty() = childCount == 0
inline fun ViewGroup.isNotEmpty() = !isEmpty()
inline fun ViewGroup.lastIndex() = childCount - 1

inline fun ViewGroup.forEachChild(action: (View) -> Unit) = childs().forEach(action)
inline fun ViewGroup.forEachChildIndexed(action: (Int, View) -> Unit) = childs().forEachIndexed(action)