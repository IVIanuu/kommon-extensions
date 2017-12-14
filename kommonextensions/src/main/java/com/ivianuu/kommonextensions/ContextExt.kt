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

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.os.BatteryManager
import android.os.Build
import android.support.annotation.*
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Surface
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.ivianuu.kommonextensions.ValueHolder.VALUE

// INTENTS

/**
 * Returns the intent for the component
 */
inline fun <reified T : Any> Context.createIntent() = Intent(this, T::class.java)

/**
 * Returns the intent for the component and calls the initializer
 */
inline fun <reified T : Any> Context.createIntent(initializer: Intent.() -> Unit): Intent {
    val intent = createIntent<T>()
    initializer(intent)
    return intent
}

// RESOURCES

inline fun Context.getResAnim(@AnimRes resId: Int) : Animation = AnimationUtils.loadAnimation(this, resId)

inline fun Context.getResIntArray(@ArrayRes resId: Int) : IntArray = resources.getIntArray(resId)

inline fun Context.getResStringArray(@ArrayRes resId: Int) : Array<String> =
        resources.getStringArray(resId)

inline fun Context.getResTextArray(@ArrayRes resId: Int) : Array<CharSequence> =
        resources.getTextArray(resId)

/**
 * Returns the typed array for this resource
 */
inline fun Context.getResTypedArray(@ArrayRes resId: Int) : TypedArray = resources.obtainTypedArray(resId)

/**
 * Returns the boolean for this resource
 */
inline fun Context.getResBool(@BoolRes resId: Int) : Boolean = resources.getBoolean(resId)

/**
 * Returns the dimen for this resource
 */
@Px
inline fun Context.getResDimen(@DimenRes resId : Int) : Int = this.resources.getDimensionPixelSize(resId)

/**
 * Returns the float for this resource
 */
inline fun Context.getResFloat(@DimenRes resId: Int) : Float {
    val value = VALUE
    resources.getValue(resId, value, true)
    return value.float
}

/**
 * Returns the int for this resource
 */
inline fun Context.getResInt(@IntegerRes resId: Int) : Int = resources.getInteger(resId)

/**
 * Returns the vector drawable for this resource
 */
inline fun Context.getResVectorDrawable(@DrawableRes resId: Int): Drawable =
        VectorDrawableCompat.create(this.resources, resId, this.theme) as Drawable

/**
 * Returns the bitmap for this resource
 */
inline fun Context.getResBitmap(@DrawableRes resId: Int) : Bitmap = getResDrawable(resId).toBitmap()

/**
 * Returns the color for this resource
 */
@ColorInt
inline fun Context.getResColor(@ColorRes resId: Int) : Int = ContextCompat.getColor(this, resId)

/**
 * Returns the color state list for this resource
 */
inline fun Context.getResColorStateList(resId: Int) : ColorStateList =
        ContextCompat.getColorStateList(this, resId)

/**
 * Returns the drawable for this resource
 */
inline fun Context.getResDrawable(@DrawableRes resId : Int) : Drawable =
        ContextCompat.getDrawable(this, resId)

/**
 * Returns the font for this resource
 */
inline fun Context.getResFont(@FontRes resId: Int) : Typeface = ResourcesCompat.getFont(this, resId)!!

// TINTED DRAWABLES

/**
 * Returns the tinted drawable
 */
inline fun Context.createTintedDrawable(@DrawableRes drawableRes: Int,
                                 @ColorInt color: Int,
                                 mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN): Drawable {
    val drawable = getResDrawable(drawableRes)
    drawable.tint(color, mode)

    return drawable
}

/**
 * Returns the tinted vector drawable
 */
inline fun Context.createTintedVectorDrawable(@DrawableRes drawableRes: Int,
                                       @ColorInt color: Int,
                                       mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN): Drawable {
    val drawable = getResVectorDrawable(drawableRes)
    drawable.tint(color, mode)

    return drawable
}

object ValueHolder {
    val VALUE = TypedValue()
}

// DISPLAY

/**
 * Returns whether is portrait
 */
inline fun Context.isPortrait(): Boolean = !isLandscape()

/**
 * Returns whether is landscape
 */
inline fun Context.isLandscape(): Boolean {
    val rotation = getRotation()
    return rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270
}

/**
 * Returns the current rotation
 */
inline fun Context.getRotation(): Int = windowManager.defaultDisplay.rotation

val metrics = DisplayMetrics()

/**
 * Returns the screen height
 */
@Px
inline fun Context.getScreenHeight(): Int {
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.heightPixels
}

/**
 * Returns the screen width
 */
@Px
inline fun Context.getScreenWidth(): Int {
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.widthPixels
}

/**
 * Returns the real screen height
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@Px
inline fun Context.getRealScreenHeight(): Int {
    windowManager.defaultDisplay.getRealMetrics(metrics)
    return metrics.heightPixels
}

/**
 * Returns the real screen width
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@Px
inline fun Context.getRealScreenWidth(): Int {
    windowManager.defaultDisplay.getRealMetrics(metrics)
    return metrics.widthPixels
}

// DEVICE SPECIFIC
/**
 * Returns whether is tablet
 */
inline fun Context.isTablet(): Boolean =
        resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE

/**
 * Returns whether has navigation bar
 */
inline fun Context.hasNavigationBar(): Boolean {
    val id = resources.getIdentifier("config_showNavigationBar", "bool", "android")
    return id > 0 && resources.getBoolean(id)
}

// NETWORK

/**
 * Returns whether the device is connected
 */
@SuppressLint("MissingPermission")
inline fun Context.isConnected(): Boolean {
    val info = connectivityManager.activeNetworkInfo
    return info?.isConnected ?: false
}

/**
 * Returns whether connected to wifi
 */
@SuppressLint("MissingPermission")
inline fun Context.isConnectedWifi(): Boolean {
    val info = connectivityManager.activeNetworkInfo
    return info?.isConnected ?: false && info?.type == ConnectivityManager.TYPE_WIFI
}

/**
 * Returns whether connected to mobile
 */
@SuppressLint("MissingPermission")
inline fun Context.isConnectedMobile(): Boolean {
    val info = connectivityManager.activeNetworkInfo
    return info?.isConnected ?: false && info?.type == ConnectivityManager.TYPE_MOBILE
}


// POWER

/**
 * Returns whether the screen is on
 */
inline fun Context.isScreenOn(): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        powerManager.isInteractive
    } else {
        powerManager.isScreenOn
    }
}

/**
 * Returns whether the device is charging
 */
inline fun Context.isCharging(): Boolean {
    val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
    val intent = registerReceiver(null, intentFilter) ?: return false

    val plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
    return plugged == BatteryManager.BATTERY_PLUGGED_AC
            || plugged == BatteryManager.BATTERY_PLUGGED_USB
            || Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS
}

/**
 * Returns the current battery level
 * Or -1 if we cannot get the battery level
 */
inline fun Context.getBatteryLevel(): Int {
    val batteryIntent = registerReceiver(null,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)) ?: return -1
    val level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
    val scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)

    return if (level == -1 || scale == -1) {
        -1
    } else (level.toFloat() / scale.toFloat() * 100.0f).toInt()
}