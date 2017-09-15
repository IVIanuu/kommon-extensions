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
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager

/**
 * Returns the intent for the component
 */
inline fun <reified T : Any> Context.IntentFor(): Intent = Intent(this, T::class.java)

// ATTRS

/**
 * Returns the attributes boolean
 */
fun Context.resolveBooleanAttr(@AttrRes attr: Int): Boolean {
    return resolveBooleanAttr(attr, false)
}

/**
 * Returns the attributes boolean
 */
fun Context.resolveBooleanAttr(@AttrRes attr: Int, defaultValue: Boolean): Boolean {
    val array = getTypedArrayWithAttributes(attr)
    val bool = array.getBoolean(0, defaultValue)
    array.recycle()
    return bool
}

/**
 * Returns the attributes color
 */
@ColorInt
fun Context.resolveColorAttr(@AttrRes attr: Int): Int {
    return resolveColorAttr(attr, -1)
}

/**
 * Returns the attributes color
 */
@ColorInt
fun Context.resolveColorAttr(@AttrRes attr: Int, @ColorInt defaultValue: Int): Int {
    val array = getTypedArrayWithAttributes(attr)
    val color = array.getColor(0, defaultValue)
    array.recycle()
    return color
}

/**
 * Returns the attributes color state list
 */
fun Context.resolveColorStateListAttr(@AttrRes attr: Int): ColorStateList? {
    return resolveColorStateListAttr(attr, null)
}

/**
 * Returns the attributes color state list
 */
fun Context.resolveColorStateListAttr(@AttrRes attr: Int,
                                      defaultValue: ColorStateList?
): ColorStateList? {
    val array = getTypedArrayWithAttributes(attr)
    val colorStateList = array.getColorStateList(0)
    array.recycle()
    return colorStateList ?: defaultValue
}

/**
 * Returns the attributes dimension
 */
@Dimension
fun Context.resolveDimensionAttr(@AttrRes attr: Int): Float {
    return resolveDimensionAttr(attr, -1f)
}

/**
 * Returns the attributes dimension
 */
@Dimension
fun Context.resolveDimensionAttr(@AttrRes attr: Int, @Dimension defaultValue: Float): Float {
    val array = getTypedArrayWithAttributes(attr)
    val dimension = array.getDimension(0, defaultValue)
    array.recycle()
    return dimension
}

/**
 * Returns the attributes dimension pixel offset
 */
@Px
fun Context.resolveDimensionPixelOffsetAttr(@AttrRes attr: Int): Int {
    return resolveDimensionPixelOffsetAttr(attr, -1)
}

/**
 * Returns the attributes dimension pixel offset
 */
@Px
fun Context.resolveDimensionPixelOffsetAttr(@AttrRes attr: Int, @Px defaultValue: Int): Int {
    val array = getTypedArrayWithAttributes(attr)
    val dimension = array.getDimensionPixelOffset(0, defaultValue)
    array.recycle()
    return dimension
}

/**
 * Returns the attributes dimension pixel size
 */
@Px
fun Context.resolveDimensionPixelSizeAttr(@AttrRes attr: Int): Int {
    return resolveDimensionPixelSizeAttr(attr, -1)
}

/**
 * Returns the attributes dimension pixel size
 */
@Px
fun Context.resolveDimensionPixelSizeAttr(@AttrRes attr: Int, @Px defaultValue: Int): Int {
    val array = getTypedArrayWithAttributes(attr)
    val dimension = array.getDimensionPixelSize(0, defaultValue)
    array.recycle()
    return dimension
}

/**
 * Returns the attributes drawable
 */
fun Context.resolveDrawableAttr(@AttrRes attr: Int): Drawable? {
    return resolveDrawableAttr(attr, null)
}

/**
 * Returns the attributes drawable
 */
fun Context.resolveDrawableAttr(@AttrRes attr: Int, defaultValue: Drawable?): Drawable? {
    val array = getTypedArrayWithAttributes(attr)
    val drawable = array.getDrawable(0)
    array.recycle()
    return drawable ?: defaultValue
}

/**
 * Returns the attributes float
 */
fun Context.resolveFloatAttr(@AttrRes attr: Int): Float {
    return resolveFloatAttr(attr, -1f)
}

/**
 * Returns the attributes float
 */
fun Context.resolveFloatAttr(@AttrRes attr: Int, defaultValue: Float): Float {
    val array = getTypedArrayWithAttributes(attr)
    val floatValue = array.getFloat(0, defaultValue)
    array.recycle()
    return floatValue
}

/**
 * Returns the attributes font
 */
fun Context.resolveFontAttr(@AttrRes attr: Int): Typeface? {
    return resolveFontAttr(attr, null)
}

/**
 * Returns the attributes font
 */
@TargetApi(Build.VERSION_CODES.O)
fun Context.resolveFontAttr(@AttrRes attr: Int, defaultValue: Typeface?): Typeface? {
    val array = getTypedArrayWithAttributes(attr)
    val font = array.getFont(0)
    array.recycle()
    return font ?: defaultValue
}

/**
 * Returns the attributes int
 */
fun Context.resolveIntAttr(@AttrRes attr: Int): Int {
    return resolveIntAttr(attr, -1)
}

/**
 * Returns the attributes int
 */
fun Context.resolveIntAttr(@AttrRes attr: Int, defaultValue: Int): Int {
    val array = getTypedArrayWithAttributes(attr)
    val intValue = array.getInt(0, defaultValue)
    array.recycle()
    return intValue
}

/**
 * Returns the attributes integer
 */
fun Context.resolveIntegerAttr(@AttrRes attr: Int): Int {
    return resolveIntegerAttr(attr, -1)
}

/**
 * Returns the attributes integer
 */
fun Context.resolveIntegerAttr(@AttrRes attr: Int, defaultValue: Int?): Int {
    val array = getTypedArrayWithAttributes(attr)
    val integer = array.getInteger(0, defaultValue!!)
    array.recycle()
    return integer
}

/**
 * Returns the attributes string
 */
fun Context.resolveStringAttr(@AttrRes attr: Int): String? {
    return resolveStringAttr(attr, null)
}

/**
 * Returns the attributes string
 */
fun Context.resolveStringAttr(@AttrRes attr: Int, defaultValue: String?): String? {
    val array = getTypedArrayWithAttributes(attr)
    val string = array.getString(0)
    array.recycle()
    return string ?: defaultValue
}

/**
 * Returns the attributes text
 */
fun Context.resolveTextAttr(@AttrRes attr: Int): CharSequence? {
    return resolveStringAttr(attr, null)
}

/**
 * Returns the attributes text
 */
fun Context.resolveTextAttr(@AttrRes attr: Int, defaultValue: CharSequence?): CharSequence? {
    val array = getTypedArrayWithAttributes(attr)
    val charSequence = array.getText(0)
    array.recycle()
    return charSequence ?: defaultValue
}

/**
 * Returns the attributes text array
 */
fun Context.resolveTextArrayAttr(@AttrRes attr: Int): Array<CharSequence>? {
    return resolveTextArrayAttr(attr, null)
}

/**
 * Returns the attributes text array
 */
fun Context.resolveTextArrayAttr(@AttrRes attr: Int,
                                 defaultValue: Array<CharSequence>?): Array<CharSequence>? {
    val array = getTypedArrayWithAttributes(attr)
    val charSequence = array.getTextArray(0)
    array.recycle()
    return charSequence ?: defaultValue
}

private fun Context.getTypedArrayWithAttributes(vararg attr: Int): TypedArray {
    return theme.obtainStyledAttributes(attr)
}

// RESOURCES

/**
 * Returns the animation for this resource
 */
fun Context.getResAnim(@AnimRes resId: Int) : Animation {
    return AnimationUtils.loadAnimation(this, resId)
}

/**
 * Returns the int array for this resource
 */
fun Context.getResIntArray(@ArrayRes resId: Int) : IntArray {
    return resources.getIntArray(resId)
}

/**
 * Returns the string array for this resource
 */
fun Context.getResStringArray(@ArrayRes resId: Int) : Array<String> {
    return resources.getStringArray(resId)
}

/**
 * Returns the text array for this resource
 */
fun Context.getResTextArray(@ArrayRes resId: Int) : Array<CharSequence> {
    return resources.getTextArray(resId)
}

/**
 * Returns the typed array for this resource
 */
fun Context.getResTypedArray(@ArrayRes resId: Int) : TypedArray {
    return resources.obtainTypedArray(resId)
}

/**
 * Returns the boolean for this resource
 */
fun Context.getResBool(@BoolRes resId: Int) : Boolean {
    return resources.getBoolean(resId)
}

/**
 * Returns the dimen for this resource
 */
@Px
fun Context.getResDimen(@DimenRes resId : Int) : Int {
    return this.resources.getDimensionPixelSize(resId)
}

/**
 * Returns the float for this resource
 */
fun Context.getResFloat(@DimenRes resId: Int) : Float {
    val value = VALUE_HOLDER.VALUE
    resources.getValue(resId, value, true)
    return value.float
}

/**
 * Returns the int for this resource
 */
fun Context.getResInt(@IntegerRes resId: Int) : Int {
    return resources.getInteger(resId)
}

/**
 * Returns the vector drawable for this resource
 */
fun Context.getResVectorDrawable(@DrawableRes resId: Int): Drawable {
    return VectorDrawableCompat.create(this.resources, resId, this.theme) as Drawable
}

/**
 * Returns the bitmap for this resource
 */
fun Context.getResBitmap(@DrawableRes resId: Int) : Bitmap {
    return getResDrawable(resId).toBitmap()
}

/**
 * Returns the color for this resource
 */
@ColorInt
fun Context.getResColor(@ColorRes resId: Int) : Int {
    return ContextCompat.getColor(this, resId)
}

/**
 * Returns the color state list for this resource
 */
fun Context.getResColorStateList(resId: Int) : ColorStateList {
    return ContextCompat.getColorStateList(this, resId)
}

/**
 * Returns the drawable for this resource
 */
fun Context.getResDrawable(@DrawableRes resId : Int) : Drawable {
    return ContextCompat.getDrawable(this, resId)
}

/**
 * Returns the font for this resource
 */
fun Context.getResFont(@FontRes resId: Int) : Typeface {
    return ResourcesCompat.getFont(this, resId)!!
}

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
@Px
fun Context.convertDpToPx(dp: Int): Int {
    val metrics = resources.displayMetrics
    return (dp * metrics.density).toInt()
}

/**
 * Converts px to dp
 */
fun Context.convertPxToDp(px: Int): Int {
    val metrics = resources.displayMetrics
    return (px / metrics.density).toInt()
}

private object VALUE_HOLDER {
    val VALUE = TypedValue()
}

// DISPLAY

/**
 * Returns whether is portrait
 */
fun Context.isPortrait(): Boolean {
    return !isLandscape()
}

/**
 * Returns whether is landscape
 */
fun Context.isLandscape(): Boolean {
    return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

/**
 * Returns the current rotation
 */
fun Context.getRotation(): Int {
    return windowManager.defaultDisplay.rotation
}

/**
 * Returns the screen height
 */
@Px
fun Context.getScreenHeight(): Int {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.heightPixels
}

/**
 * Returns the screen width
 */
@Px
fun Context.getScreenWidth(): Int {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.widthPixels
}

/**
 * Returns the real screen height
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@Px
fun Context.getRealScreenHeight(): Int {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getRealMetrics(metrics)
    return metrics.heightPixels
}

/**
 * Returns the real screen width
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@Px
fun Context.getRealScreenWidth(): Int {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getRealMetrics(metrics)
    return metrics.widthPixels
}

// DEVICE SPECIFIC
/**
 * Returns whether is tablet
 */
fun Context.isTablet(): Boolean {
    return resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
}

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

// SYSTEM SERVICES

/**
 * Returns the accessibility manager
 */
val Context.accessibilityManager get() = getSystemService(
        Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

/**
 * Returns the account manager
 */
val Context.accountManager get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

/**
 * Returns the activity manager
 */
val Context.activityManager get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

/**
 * Returns the alarm manager
 */
val Context.alarmManager get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager

/**
 * Returns the audio manager
 */
val Context.audioManager get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager

/**
 * Returns the clipboard manager manager
 */
val Context.clipboardManager get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

/**
 * Returns the connectivity manager
 */
val Context.connectivityManager get() = getSystemService(
        Context.CONNECTIVITY_SERVICE) as ConnectivityManager

/**
 * Returns the keyguard manager
 */
val Context.keyguardManager get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

/**
 * Returns the layout inflater
 */
val Context.layoutInflater get() = getSystemService(
        Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

/**
 * Returns the location manager
 */
val Context.locationManager get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager

/**
 * Returns the notification manager
 */
val Context.notificationManager get() = getSystemService(
        Context.NOTIFICATION_SERVICE) as NotificationManager

/**
 * Returns the power manager
 */
val Context.powerManager get() = getSystemService(Context.POWER_SERVICE) as PowerManager

/**
 * Returns the search manager
 */
val Context.searchManager get() = getSystemService(Context.SEARCH_SERVICE) as SearchManager

/**
 * Returns the sensor manager
 */
val Context.sensorManager get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager

/**
 * Returns the telephony manager
 */
val Context.telephonyManager get() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

/**
 * Returns the vibrator
 */
val Context.vibrator get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

/**
 * Returns the wallpaper manager
 */
val Context.wallpaperManager get() = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager

/**
 * Returns the wifi manager
 */
val Context.wifiManager
    @SuppressLint("WifiManagerLeak")
    get() = getSystemService(Context.WIFI_SERVICE) as WifiManager

/**
 * Returns the window manager
 */
val Context.windowManager get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager

/**
 * Returns the input method manager
 */
val Context.inputMethodManager get() = getSystemService(
        Context.INPUT_METHOD_SERVICE) as InputMethodManager

/**
 * Returns the device policy manager
 */
val Context.devicePolicyManager get() = getSystemService(
        Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

/**
 * Returns the drop box manager
 */
val Context.dropBoxManager get() = getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager

/**
 * Returns the ui mode manager
 */
val Context.uiModeManager get() = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

/**
 * Returns the download manager
 */
val Context.downloadManager get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

/**
 * Returns the storage manager
 */
val Context.storageManager get() = getSystemService(Context.STORAGE_SERVICE) as StorageManager

/**
 * Returns the nfc manager
 */
val Context.nfcManager get() = getSystemService(Context.NFC_SERVICE) as NfcManager

/**
 * Returns the usb manager
 */
val Context.usbManager get() = getSystemService(Context.USB_SERVICE) as UsbManager

/**
 * Returns the text services manager
 */
val Context.textServicesManager get() = getSystemService(
        Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

/**
 * Returns the wifi p2p manager
 */
val Context.wifiP2pManager get() = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager

/**
 * Returns the input manager
 */
val Context.inputManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
get() = getSystemService(Context.INPUT_SERVICE) as InputManager

/**
 * Returns the media router
 */
val Context.mediaRouter @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
get() = getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter

/**
 * Returns the nsd manager
 */
val Context.nsdManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
get() = getSystemService(Context.NSD_SERVICE) as NsdManager

/**
 * Returns the display manager
 */
val Context.displayManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
get() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

/**
 * Returns the user manager
 */
val Context.userManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
get() = getSystemService(Context.USER_SERVICE) as UserManager

/**
 * Returns the bluetooth manager
 */
val Context.bluetoothManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

/**
 * Returns the app ops manager
 */
val Context.appOpsManager @TargetApi(Build.VERSION_CODES.KITKAT)
get() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

/**
 * Returns the captioning manager
 */
val Context.captioningManager @TargetApi(Build.VERSION_CODES.KITKAT)
get() = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

/**
 * Returns the consumer ir manager
 */
val Context.consumerIrManager @TargetApi(Build.VERSION_CODES.KITKAT)
get() = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

/**
 * Returns the print manager
 */
val Context.printManager @TargetApi(Build.VERSION_CODES.KITKAT)
get() = getSystemService(Context.PRINT_SERVICE) as PrintManager

/**
 * Returns the app widget manager
 */
val Context.appWidgetManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

/**
 * Returns the battery manager
 */
val Context.batteryManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager

/**
 * Returns the camera manager
 */
val Context.cameraManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.CAMERA_SERVICE) as CameraManager

/**
 * Returns the job scheduler
 */
val Context.jobScheduler @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

/**
 * Returns the launcher apps
 */
val Context.launcherApps @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

/**
 * Returns the media projection manager
 */
val Context.mediaProjectionManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

/**
 * Returns the media session manager
 */
val Context.mediaSessionManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

/**
 * Returns the restrictions manager
 */
val Context.restrictionsManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

/**
 * Returns the telecom manager
 */
val Context.telecomManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.TELECOM_SERVICE) as TelecomManager

/**
 * Returns the tv input manager
 */
val Context.tvInputManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

/**
 * Returns the subscription manager
 */
val Context.subscriptionManager @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
get() = getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager

/**
 * Returns the usage stats manager
 */
val Context.usageStatsManager @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
get() = getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

/**
 * Returns the carrier config manager
 */
val Context.carrierConfigManager @TargetApi(Build.VERSION_CODES.M)
get() = getSystemService(Context.CARRIER_CONFIG_SERVICE) as CarrierConfigManager

/**
 * Returns the fingerprint manager
 */
val Context.fingerprintManager
    @TargetApi(Build.VERSION_CODES.M)
    get() = getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager

/**
 * Returns the midi manager
 */
val Context.midiManager
    @TargetApi(Build.VERSION_CODES.M)
    get() = getSystemService(Context.MIDI_SERVICE) as MidiManager

/**
 * Returns the network stats manager
 */
val Context.networkStatsManager
    @TargetApi(Build.VERSION_CODES.M)
    get() = getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager

/**
 * Returns the shortcut manager
 */
val Context.shortcutManager
    @TargetApi(Build.VERSION_CODES.N_MR1)
    get() = getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager