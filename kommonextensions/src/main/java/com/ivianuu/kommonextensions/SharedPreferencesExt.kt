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

import android.content.SharedPreferences

inline fun SharedPreferences.getString(key: String) = getString(key, "")

inline fun SharedPreferences.getStringSet(key: String) = getStringSet(key, emptySet())

inline fun SharedPreferences.getInt(key: String) = getInt(key, 0)

inline fun SharedPreferences.getLong(key: String) = getLong(key, 0L)

inline fun SharedPreferences.getFloat(key: String) = getFloat(key, 0f)

inline fun SharedPreferences.getBoolean(key: String) = getBoolean(key, false)

inline fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    action(editor)
    editor.apply()
}