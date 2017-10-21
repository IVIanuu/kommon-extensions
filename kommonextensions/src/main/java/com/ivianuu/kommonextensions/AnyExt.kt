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

import android.os.Build

/**
 * The current sdk
 */
val currentSdk = Build.VERSION.SDK_INT

/**
 * Whether is running on ice cream sandwich mr1 or not
 */
val isIceCreamSandwichMr1 = currentSdk >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1

/**
 * Whether is running on jelly bean or not
 */
val isJellyBean = currentSdk >= Build.VERSION_CODES.JELLY_BEAN

/**
 * Whether is running on jelly bean mr1 or not
 */
val isJellyBeanMr1 = currentSdk >= Build.VERSION_CODES.JELLY_BEAN_MR1

/**
 * Whether is running on jelly bean mr2 or not
 */
val isJellyBeanMr2 = currentSdk >= Build.VERSION_CODES.JELLY_BEAN_MR2

/**
 * Whether is running on kitkat or not
 */
val isKitkat = currentSdk >= Build.VERSION_CODES.KITKAT

/**
 * Whether is running on kitkat watch or not
 */
val isKitkatWatch = currentSdk >= Build.VERSION_CODES.KITKAT_WATCH

/**
 * Whether is running on lollipop or not
 */
val isLollipop = currentSdk >= Build.VERSION_CODES.LOLLIPOP

/**
 * Whether is running on lollipop mr1 or not
 */
val isLollipopMr1 = currentSdk >= Build.VERSION_CODES.LOLLIPOP_MR1

/**
 * Whether is running on marshmallow or not
 */
val isMarshmallow = currentSdk >= Build.VERSION_CODES.M

/**
 * Whether is running on nougat or not
 */
val isNougat = currentSdk >= Build.VERSION_CODES.N

/**
 * Whether is running on nougat mr1 or not
 */
val isNougatMr1 = currentSdk >= Build.VERSION_CODES.N_MR1

/**
 * Whether is running on oreo or not
 */
val isOreo = currentSdk >= Build.VERSION_CODES.O

/**
 * Invokes the function if the sdk is greater or equal to the current sdk
 */
inline fun onSdk(sdk: Int, func: () -> Unit) {
    if (currentSdk >= sdk) func()
}

/**
 * Invokes the function on ics mr1 and above
 */
inline fun onIceCreamSandwichMr1(func:() -> Unit) {
    if (isIceCreamSandwichMr1) func()
}

/**
 * Invokes the function on jelly bean and above
 */
inline fun onJellyBean(func:() -> Unit) {
    if (isJellyBean) func()
}

/**
 * Invokes the function on jelly bean mr1 and above
 */
inline fun onJellyBeanMr1(func:() -> Unit) {
    if (isJellyBeanMr1) func()
}

/**
 * Invokes the function on jelly bean mr2 and above
 */
inline fun onJellyBeanMr2(func:() -> Unit) {
    if (isJellyBeanMr2) func()
}

/**
 * Invokes the function on kit kat and above
 */
inline fun onKitKat(func:() -> Unit) {
    if (isKitkat) func()
}

/**
 * Invokes the function on kit kat watch and above
 */
inline fun onKitKatWatch(func:() -> Unit) {
    if (isKitkatWatch) func()
}

/**
 * Invokes the function on lollipop and above
 */
inline fun onLollipop(func:() -> Unit) {
    if (isLollipop) func()
}

/**
 * Invokes the function on lollipop mr1 and above
 */
inline fun onLollipopMr1(func:() -> Unit) {
    if (isLollipopMr1) func()
}

/**
 * Invokes the function on marshmallow and above
 */
inline fun onMarshmallow(func:() -> Unit) {
    if (isMarshmallow) func()
}

/**
 * Invokes the function on nougat and above
 */
inline fun onNougat(func:() -> Unit) {
    if (isNougat) func()
}

/**
 * Invokes the function on nougat mr1 and above
 */
inline fun onNougatMr1(func:() -> Unit) {
    if (isNougatMr1) func()
}

/**
 * Invokes the function on oreo and above
 */
inline fun onOreo(func:() -> Unit) {
    if (isOreo) func()
}