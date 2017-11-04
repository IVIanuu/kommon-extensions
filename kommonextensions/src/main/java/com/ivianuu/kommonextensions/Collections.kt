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

import java.util.*

/**
 * Iterate the array using an index.
 */
inline fun <T> Array<T>.forEachByIndex(action: (T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        action(get(i))
    }
}

/**
 * Iterate the array using an index.
 */
inline fun <T> Array<T>.forEachWithIndex(action: (Int, T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        action(i, get(i))
    }
}

/**
 * Iterate the array backwards using an index.
 */
inline fun <T> Array<T>.forEachReversedByIndex(action: (T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        action(get(i))
        i--
    }
}

/**
 * Iterate the array backwards using an index.
 */
inline fun <T> Array<T>.forEachReversedWithIndex(action: (Int, T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        action(i, get(i))
        i--
    }
}

/**
 * Iterate the list using an index.
 */
inline fun <T> List<T>.forEachByIndex(action: (T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        action(get(i))
    }
}

/**
 * Iterate the list using an index.
 */
inline fun <T> List<T>.forEachWithIndex(action: (Int, T) -> Unit) {
    val lastIndex = size - 1
    for (i in 0..lastIndex) {
        action(i, get(i))
    }
}

/**
 * Iterate the list backwards using an index.
 */
inline fun <T> List<T>.forEachReversedByIndex(action: (T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        action(get(i))
        i--
    }
}

/**
 * Iterate the list backwards using an index.
 */
inline fun <T> List<T>.forEachReversedWithIndex(action: (Int, T) -> Unit) {
    var i = size - 1
    while (i >= 0) {
        action(i, get(i))
        i--
    }
}

/**
 * Shuffles this list
 */
fun MutableList<*>.shuffle() {
    Collections.shuffle(this)
}

/**
 * Returns a shuffled copy of this list
 */
fun <T> MutableList<T>.shuffled(): List<T> {
    val copy = toMutableList()
    copy.shuffle()
    return copy
}

/**
 * Swaps the to items
 */
fun MutableList<*>.swap(from: Int, to: Int) {
    Collections.swap(this, from, to)
}

/**
 * Returns a swapped copy of this list
 */
fun <T> List<T>.swapped(from: Int, to: Int): List<T> {
    val copy = toMutableList()
    copy.swap(from, to)
    return copy
}