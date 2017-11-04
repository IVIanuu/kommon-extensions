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

import android.content.res.Resources
import android.support.annotation.Px
import android.util.DisplayMetrics

@PublishedApi internal inline val systemMetrics: DisplayMetrics get() = Resources.getSystem().displayMetrics

/**
 * Get converted pixel value of this dp.
 */
inline val Int.dp: Int @Px get() = (this * systemMetrics.density).toInt()

/**
 * Get converted pixel value of this dp.
 */
inline val Float.dp: Int @Px get() = (this * systemMetrics.density).toInt()

/**
 * Get converted pixel value of this sp.
 */
inline val Int.sp: Int @Px get() = (this * systemMetrics.scaledDensity).toInt()

/**
 * Get converted pixel value of this sp.
 */
inline val Float.sp: Int @Px get() = (this * systemMetrics.scaledDensity).toInt()

/**
 * Get converted dp value of this pixel.
 */
inline fun dpOf(@Px px: Int): Int = (px / systemMetrics.density).toInt()

/**
 * Get converted dp value of this pixel.
 */
inline fun dpOf(px: Float): Int = (px / systemMetrics.density).toInt()

/**
 * Get converted sp value of this pixel.
 */
inline fun spOf(@Px px: Int): Int = (px / systemMetrics.scaledDensity).toInt()

/**
 * Get converted sp value of this pixel.
 */
inline fun spOf(px: Float): Int = (px / systemMetrics.scaledDensity).toInt()