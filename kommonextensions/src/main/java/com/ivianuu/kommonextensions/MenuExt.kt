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
import android.view.View
import android.view.ViewGroup

fun Menu.find(id: Int): MenuItem = findItem(id)!!
fun Menu.findNullable(id: Int): MenuItem? = findItem(id)

fun Menu.first(): MenuItem  = this[0]
fun Menu.firstOrNull(): MenuItem?  = if (isEmpty()) null else first()
fun Menu.last(): MenuItem  = this[lastIndex()]
fun Menu.lastOrNull(): MenuItem?  = if (isEmpty()) null else last()

fun Menu.isEmpty(): Boolean = size() == 0
fun Menu.isNotEmpty() = !isEmpty()

fun Menu.lastIndex(): Int = size() - 1

fun Menu.forEach(action: (MenuItem) -> Unit) = items().forEach(action)
fun Menu.forEachIndexed(action: (Int, MenuItem) -> Unit) = items().forEachIndexed(action)

operator fun Menu.get(index: Int) = getItem(index)

fun Menu.getOrNull(index: Int): MenuItem? = if (index in 0..lastIndex()) getItem(index) else null

operator fun Menu.get(item: MenuItem) = items().indexOfFirst { it == item }

operator fun Menu.contains(item: MenuItem) = get(item) != -1

fun Menu.items(): List<MenuItem> = (0 until size()).map { get(it) }