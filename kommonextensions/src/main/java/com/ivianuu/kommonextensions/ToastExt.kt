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

import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast
import android.widget.Toast.*

@PublishedApi
internal fun Context.make(message: CharSequence, duration: Int): Toast = makeText(this, message, duration)

@PublishedApi
internal fun Context.make(@StringRes message: Int, duration: Int): Toast = makeText(this, message, duration)

fun Context.toast(message: CharSequence, length: Int = LENGTH_SHORT): Toast = make(message, length).apply { show() }
fun Fragment.toast(message: CharSequence): Toast = activity.toast(message)
fun android.support.v4.app.Fragment.toast(message: CharSequence): Toast = activity!!.toast(message)
fun Dialog.toast(message: CharSequence): Toast = context.toast(message)

fun Context.toast(@StringRes message: Int): Toast = make(message, LENGTH_SHORT).apply { show() }
fun Fragment.toast(@StringRes message: Int): Toast = activity.toast(message)
fun android.support.v4.app.Fragment.toast(@StringRes message: Int): Toast = activity!!.toast(message)
fun Dialog.toast(@StringRes message: Int): Toast = context.toast(message)

fun Context.longToast(message: CharSequence): Toast = make(message, LENGTH_LONG).apply { show() }
fun Fragment.longToast(message: CharSequence): Toast = activity.longToast(message)
fun android.support.v4.app.Fragment.longToast(message: CharSequence): Toast = activity!!.longToast(message)
fun Dialog.longToast(message: CharSequence): Toast = context.longToast(message)

fun Context.longToast(@StringRes message: Int): Toast = make(message, LENGTH_LONG).apply { show() }
fun Fragment.longToast(@StringRes message: Int): Toast = activity.longToast(message)
fun android.support.v4.app.Fragment.longToast(@StringRes message: Int): Toast = activity!!.longToast(message)
fun Dialog.longToast(@StringRes message: Int): Toast = context.longToast(message)