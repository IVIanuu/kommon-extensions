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

import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.app.usage.NetworkStatsManager
import android.app.usage.UsageStatsManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.*
import android.content.pm.LauncherApps
import android.content.pm.ShortcutManager
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.fingerprint.FingerprintManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.midi.MidiManager
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.storage.StorageManager
import android.print.PrintManager
import android.support.annotation.*
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.telecom.TelecomManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.Surface
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager
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

// ATTRS



// RESOURCES

/**
 * Returns the animation for this resource
 */
fun Context.getResAnim(@AnimRes resId: Int) : Animation = AnimationUtils.loadAnimation(this, resId)

/**
 * Returns the int array for this resource
 */
fun Context.getResIntArray(@ArrayRes resId: Int) : IntArray = resources.getIntArray(resId)

/**
 * Returns the string array for this resource
 */
fun Context.getResStringArray(@ArrayRes resId: Int) : Array<String> =
        resources.getStringArray(resId)

/**
 * Returns the text array for this resource
 */
fun Context.getResTextArray(@ArrayRes resId: Int) : Array<CharSequence> =
        resources.getTextArray(resId)

/**
 * Returns the typed array for this resource
 */
fun Context.getResTypedArray(@ArrayRes resId: Int) : TypedArray = resources.obtainTypedArray(resId)

/**
 * Returns the boolean for this resource
 */
fun Context.getResBool(@BoolRes resId: Int) : Boolean = resources.getBoolean(resId)

/**
 * Returns the dimen for this resource
 */
@Px
fun Context.getResDimen(@DimenRes resId : Int) : Int = this.resources.getDimensionPixelSize(resId)

/**
 * Returns the float for this resource
 */
fun Context.getResFloat(@DimenRes resId: Int) : Float {
    val value = VALUE
    resources.getValue(resId, value, true)
    return value.float
}

/**
 * Returns the int for this resource
 */
fun Context.getResInt(@IntegerRes resId: Int) : Int = resources.getInteger(resId)

/**
 * Returns the vector drawable for this resource
 */
fun Context.getResVectorDrawable(@DrawableRes resId: Int): Drawable =
        VectorDrawableCompat.create(this.resources, resId, this.theme) as Drawable

/**
 * Returns the bitmap for this resource
 */
fun Context.getResBitmap(@DrawableRes resId: Int) : Bitmap = getResDrawable(resId).toBitmap()

/**
 * Returns the color for this resource
 */
@ColorInt
fun Context.getResColor(@ColorRes resId: Int) : Int = ContextCompat.getColor(this, resId)

/**
 * Returns the color state list for this resource
 */
fun Context.getResColorStateList(resId: Int) : ColorStateList =
        ContextCompat.getColorStateList(this, resId)

/**
 * Returns the drawable for this resource
 */
fun Context.getResDrawable(@DrawableRes resId : Int) : Drawable =
        ContextCompat.getDrawable(this, resId)

/**
 * Returns the font for this resource
 */
fun Context.getResFont(@FontRes resId: Int) : Typeface = ResourcesCompat.getFont(this, resId)!!

// TINTED DRAWABLES

/**
 * Returns the tinted drawable
 */
fun Context.createTintedDrawable(@DrawableRes drawableRes: Int,
                                 @ColorInt color: Int,
                                 mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN): Drawable {
    val drawable = getResDrawable(drawableRes)
    drawable.tint(color, mode)

    return drawable
}

/**
 * Returns the tinted vector drawable
 */
fun Context.createTintedVectorDrawable(@DrawableRes drawableRes: Int,
                                       @ColorInt color: Int,
                                       mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN): Drawable {
    val drawable = getResVectorDrawable(drawableRes)
    drawable.tint(color, mode)

    return drawable
}

// CONVERT

/**
 * Converts dp to pixels
 */
fun Context.convertDpToPx(dp: Int): Float {
    val metrics = resources.displayMetrics
    return (dp * metrics.density)
}

/**
 * Converts px to dp
 */
fun Context.convertPxToDp(px: Int): Int {
    val metrics = resources.displayMetrics
    return (px / metrics.density).toInt()
}

private object ValueHolder {
    val VALUE = TypedValue()
}

// DISPLAY

/**
 * Returns whether is portrait
 */
fun Context.isPortrait(): Boolean = !isLandscape()

/**
 * Returns whether is landscape
 */
fun Context.isLandscape(): Boolean {
    val rotation = getRotation()
    return rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270
}

/**
 * Returns the current rotation
 */
fun Context.getRotation(): Int = windowManager.defaultDisplay.rotation

private val metrics = DisplayMetrics()

/**
 * Returns the screen height
 */
@Px
fun Context.getScreenHeight(): Int {
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.heightPixels
}

/**
 * Returns the screen width
 */
@Px
fun Context.getScreenWidth(): Int {
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.widthPixels
}

/**
 * Returns the real screen height
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@Px
fun Context.getRealScreenHeight(): Int {
    windowManager.defaultDisplay.getRealMetrics(metrics)
    return metrics.heightPixels
}

/**
 * Returns the real screen width
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@Px
fun Context.getRealScreenWidth(): Int {
    windowManager.defaultDisplay.getRealMetrics(metrics)
    return metrics.widthPixels
}

// DEVICE SPECIFIC
/**
 * Returns whether is tablet
 */
fun Context.isTablet(): Boolean =
        resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE

/**
 * Returns whether has navigation bar
 */
fun Context.hasNavigationBar(): Boolean {
    val id = resources.getIdentifier("config_showNavigationBar", "bool", "android")
    return id > 0 && resources.getBoolean(id)
}

// NETWORK

/**
 * Returns whether the device is connected
 */
@SuppressLint("MissingPermission")
fun Context.isConnected(): Boolean {
    val info = connectivityManager.activeNetworkInfo
    return info?.isConnected ?: false
}

/**
 * Returns whether connected to wifi
 */
@SuppressLint("MissingPermission")
fun Context.isConnectedWifi(): Boolean {
    val info = connectivityManager.activeNetworkInfo
    return info?.isConnected ?: false && info?.type == ConnectivityManager.TYPE_WIFI
}

/**
 * Returns whether connected to mobile
 */
@SuppressLint("MissingPermission")
fun Context.isConnectedMobile(): Boolean {
    val info = connectivityManager.activeNetworkInfo
    return info?.isConnected ?: false && info?.type == ConnectivityManager.TYPE_MOBILE
}


// POWER

/**
 * Returns whether the screen is on
 */
fun Context.isScreenOn(): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        powerManager.isInteractive
    } else {
        powerManager.isScreenOn
    }
}

/**
 * Returns whether the device is charging
 */
fun Context.isCharging(): Boolean {
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
fun Context.getBatteryLevel(): Int {
    val batteryIntent = registerReceiver(null,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)) ?: return -1
    val level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
    val scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)

    return if (level == -1 || scale == -1) {
        -1
    } else (level.toFloat() / scale.toFloat() * 100.0f).toInt()
}