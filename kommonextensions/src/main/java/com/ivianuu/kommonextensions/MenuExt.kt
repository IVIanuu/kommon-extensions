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

import android.view.Menu
import android.view.MenuItem

operator fun Menu.get(index: Int): MenuItem =
    getItem(index) ?: throw IndexOutOfBoundsException("Index: $index, Size: $size")

operator fun Menu.contains(item: MenuItem) = indexOfItem(item) != -1

inline val Menu.size get() = size()

fun Menu.isEmpty() = size == 0

fun Menu.isNotEmpty() = size != 0

fun Menu.indexOfItem(item: MenuItem): Int {
    return (0 until size)
        .firstOrNull { getItem(it) == item } ?: -1
}

inline fun Menu.forEach(action: (MenuItem) -> Unit) {
    for (i in 0 until size) {
        action(getItem(i))
    }
}

inline fun Menu.forEachIndexed(action: (Int, MenuItem) -> Unit) {
    for (i in 0 until size) {
        action(i, getItem(i))
    }
}

operator fun Menu.iterator() = object : MutableIterator<MenuItem> {
    private var index = 0
    override fun hasNext() = index < size
    override fun next() = getItem(index++)
    override fun remove() = removeItem(getItem(--index).itemId)
}

val Menu.items: Sequence<MenuItem>
    get() = object : Sequence<MenuItem> {
        override fun iterator(): Iterator<MenuItem> = iterator()
    }