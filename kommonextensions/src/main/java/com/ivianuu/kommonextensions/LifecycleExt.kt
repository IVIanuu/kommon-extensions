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

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner

fun Lifecycle.doOnCreate(action: (owner: LifecycleOwner) -> Unit) =
        addObserver(onCreate = action)

fun Lifecycle.doOnStart(action: (owner: LifecycleOwner) -> Unit) =
    addObserver(onStart = action)

fun Lifecycle.doOnResume(action: (owner: LifecycleOwner) -> Unit) =
    addObserver(onResume = action)

fun Lifecycle.doOnPause(action: (owner: LifecycleOwner) -> Unit) =
    addObserver(onPause = action)

fun Lifecycle.doOnStop(action: (owner: LifecycleOwner) -> Unit) =
    addObserver(onStop = action)

fun Lifecycle.doOnDestroy(action: (owner: LifecycleOwner) -> Unit) =
    addObserver(onDestroy = action)

fun Lifecycle.addObserver(
    onCreate: ((owner: LifecycleOwner) -> Unit)? = null,
    onStart: ((owner: LifecycleOwner) -> Unit)? = null,
    onResume: ((owner: LifecycleOwner) -> Unit)? = null,
    onPause: ((owner: LifecycleOwner) -> Unit)? = null,
    onStop: ((owner: LifecycleOwner) -> Unit)? = null,
    onDestroy: ((owner: LifecycleOwner) -> Unit)? = null
) : LifecycleObserver {
    val observer = object : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            onCreate?.invoke(owner)
        }

        override fun onStart(owner: LifecycleOwner) {
            onStart?.invoke(owner)
        }

        override fun onResume(owner: LifecycleOwner) {
            onResume?.invoke(owner)
        }

        override fun onPause(owner: LifecycleOwner) {
            onPause?.invoke(owner)
        }

        override fun onStop(owner: LifecycleOwner) {
            onStop?.invoke(owner)
        }

        override fun onDestroy(owner: LifecycleOwner) {
            onDestroy?.invoke(owner)
            removeObserver(this)
        }
    }
    addObserver(observer)
    return observer
}