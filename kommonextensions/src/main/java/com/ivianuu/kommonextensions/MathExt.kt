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

inline fun Double.sin(): Double = Math.sin(this)

inline fun Double.cos(): Double = Math.cos(this)
inline fun Double.tan(): Double = Math.tan(this)
inline fun Double.asin(): Double = Math.asin(this)
inline fun Double.acos(): Double = Math.acos(this)
inline fun Double.atan(): Double = Math.atan(this)
inline fun Double.toRadians(): Double = Math.toRadians(this)
inline fun Double.toDegrees(): Double = Math.toDegrees(this)
inline fun Double.exp(): Double = Math.exp(this)
inline fun Double.log(): Double = Math.log(this)
inline fun Double.log10(): Double = Math.log10(this)
inline fun Double.sqrt(): Double = Math.sqrt(this)
inline fun Double.cbrt(): Double = Math.cbrt(this)
inline fun Double.IEEEremainder(divisor: Double): Double = Math.IEEEremainder(this, divisor)
inline fun Double.ceil(): Double = Math.ceil(this)
inline fun Double.floor(): Double = Math.floor(this)
inline fun Double.rint(): Double = Math.rint(this)
inline fun Double.atan2(x: Double): Double = Math.atan2(this, x)
inline fun Double.pow(exp: Double): Double = Math.pow(this, exp)
inline fun Double.round(): Long = Math.round(this)
inline fun Double.abs(): Double = Math.abs(this)
inline fun Double.ulp(): Double = Math.ulp(this)
inline fun Double.signum(): Double = Math.signum(this)
inline fun Double.sinh(): Double = Math.sinh(this)
inline fun Double.cosh(): Double = Math.cosh(this)
inline fun Double.tanh(): Double = Math.tanh(this)
inline fun Double.expm1(): Double = Math.expm1(this)
inline fun Double.log1p(): Double = Math.log1p(this)
inline fun Double.copySign(sign: Double): Double = Math.copySign(this, sign)
inline fun Double.exponent(): Int = Math.getExponent(this)
inline fun Double.next(direction: Double): Double = Math.nextAfter(this, direction)
inline fun Double.nextUp(): Double = Math.nextUp(this)
inline fun Double.scalb(scaleFactor: Int): Double = Math.scalb(this, scaleFactor)
inline fun Double.clamp(min: Double, max: Double): Double = Math.max(min, Math.min(this, max))