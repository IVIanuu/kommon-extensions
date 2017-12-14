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

val currentSdk = Build.VERSION.SDK_INT

val isIceCreamSandwichMr1 = currentSdk >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1

val isJellyBean = currentSdk >= Build.VERSION_CODES.JELLY_BEAN

val isJellyBeanMr1 = currentSdk >= Build.VERSION_CODES.JELLY_BEAN_MR1

val isJellyBeanMr2 = currentSdk >= Build.VERSION_CODES.JELLY_BEAN_MR2

val isKitkat = currentSdk >= Build.VERSION_CODES.KITKAT

val isKitkatWatch = currentSdk >= Build.VERSION_CODES.KITKAT_WATCH

val isLollipop = currentSdk >= Build.VERSION_CODES.LOLLIPOP

val isLollipopMr1 = currentSdk >= Build.VERSION_CODES.LOLLIPOP_MR1

val isMarshmallow = currentSdk >= Build.VERSION_CODES.M

val isNougat = currentSdk >= Build.VERSION_CODES.N

val isNougatMr1 = currentSdk >= Build.VERSION_CODES.N_MR1

val isOreo = currentSdk >= Build.VERSION_CODES.O

val isOreoMr1 = currentSdk > Build.VERSION_CODES.O

inline fun aboveSdk(sdk: Int, func: () -> Unit) {
    if (currentSdk > sdk) func()
}

inline fun onSdk(sdk: Int, func: () -> Unit) {
    if (currentSdk >= sdk) func()
}

inline fun belowSdk(sdk: Int, func: () -> Unit) {
    if (currentSdk < sdk) func()
}

inline fun onIceCreamSandwichMr1(func:() -> Unit) {
    if (isIceCreamSandwichMr1) func()
}

inline fun onJellyBean(func:() -> Unit) {
    if (isJellyBean) func()
}

inline fun onJellyBeanMr1(func:() -> Unit) {
    if (isJellyBeanMr1) func()
}

inline fun onJellyBeanMr2(func:() -> Unit) {
    if (isJellyBeanMr2) func()
}

inline fun onKitKat(func:() -> Unit) {
    if (isKitkat) func()
}

inline fun onKitKatWatch(func:() -> Unit) {
    if (isKitkatWatch) func()
}

inline fun onLollipop(func:() -> Unit) {
    if (isLollipop) func()
}

inline fun onLollipopMr1(func:() -> Unit) {
    if (isLollipopMr1) func()
}

inline fun onMarshmallow(func:() -> Unit) {
    if (isMarshmallow) func()
}

inline fun onNougat(func:() -> Unit) {
    if (isNougat) func()
}

inline fun onNougatMr1(func:() -> Unit) {
    if (isNougatMr1) func()
}

inline fun onOreo(func:() -> Unit) {
    if (isOreo) func()
}

inline fun onOreoMr1(func:() -> Unit) {
    if (isOreoMr1) func()
}