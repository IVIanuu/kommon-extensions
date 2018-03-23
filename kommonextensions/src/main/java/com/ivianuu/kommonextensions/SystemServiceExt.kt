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

import android.accessibilityservice.AccessibilityService
import android.accounts.AccountManager
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.app.usage.UsageStatsManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.*
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
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
import android.telecom.TelecomManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager
import java.util.*
import kotlin.reflect.KClass

private val SERVICES = HashMap<KClass<*>, String>().apply {
    if (Build.VERSION.SDK_INT > 22) {
        this[SubscriptionManager::class] = TELEPHONY_SUBSCRIPTION_SERVICE
        this[UsageStatsManager::class] = USAGE_STATS_SERVICE
    }
    if (Build.VERSION.SDK_INT > 21) {
        this[AppWidgetManager::class] = APPWIDGET_SERVICE
        this[BatteryManager::class] = BATTERY_SERVICE
        this[CameraManager::class] = CAMERA_SERVICE
        this[JobScheduler::class] = JOB_SCHEDULER_SERVICE
        this[LauncherApps::class] = LAUNCHER_APPS_SERVICE
        this[MediaProjectionManager::class] = MEDIA_PROJECTION_SERVICE
        this[MediaSessionManager::class] = MEDIA_SESSION_SERVICE
        this[RestrictionsManager::class] = RESTRICTIONS_SERVICE
        this[TelecomManager::class] = TELECOM_SERVICE
        this[TvInputManager::class] = TV_INPUT_SERVICE
    }
    if (Build.VERSION.SDK_INT > 19) {
        this[AppOpsManager::class] = APP_OPS_SERVICE
        this[CaptioningManager::class] = CAPTIONING_SERVICE
        this[ConsumerIrManager::class] = CONSUMER_IR_SERVICE
        this[PrintManager::class] = PRINT_SERVICE
    }
    if (Build.VERSION.SDK_INT > 18) {
        this[BluetoothManager::class] = BLUETOOTH_SERVICE
    }
    if (Build.VERSION.SDK_INT > 17) {
        this[DisplayManager::class] = DISPLAY_SERVICE
        this[UserManager::class] = USER_SERVICE
    }
    if (Build.VERSION.SDK_INT > 16) {
        this[InputManager::class] = INPUT_SERVICE
        this[MediaRouter::class] = MEDIA_ROUTER_SERVICE
        this[NsdManager::class] = NSD_SERVICE
    }
    this[AccessibilityService::class] = ACCESSIBILITY_SERVICE
    this[AccountManager::class] = ACCOUNT_SERVICE
    this[ActivityManager::class] = ACTIVITY_SERVICE
    this[AlarmManager::class] = ALARM_SERVICE
    this[AudioManager::class] = AUDIO_SERVICE
    this[ClipboardManager::class] = CLIPBOARD_SERVICE
    this[ConnectivityManager::class] = CONNECTIVITY_SERVICE
    this[DevicePolicyManager::class] = DEVICE_POLICY_SERVICE
    this[DownloadManager::class] = DOWNLOAD_SERVICE
    this[DropBoxManager::class] = DROPBOX_SERVICE
    this[InputMethodManager::class] = INPUT_METHOD_SERVICE
    this[KeyguardManager::class] = KEYGUARD_SERVICE
    this[LayoutInflater::class] = LAYOUT_INFLATER_SERVICE
    this[LocationManager::class] = LOCATION_SERVICE
    this[NfcManager::class] = NFC_SERVICE
    this[NotificationManager::class] = NOTIFICATION_SERVICE
    this[PowerManager::class] = POWER_SERVICE
    this[SearchManager::class] = SEARCH_SERVICE
    this[SensorManager::class] = SENSOR_SERVICE
    this[StorageManager::class] = STORAGE_SERVICE
    this[TelephonyManager::class] = TELEPHONY_SERVICE
    this[TextServicesManager::class] = TEXT_SERVICES_MANAGER_SERVICE
    this[UiModeManager::class] = UI_MODE_SERVICE
    this[UsbManager::class] = USB_SERVICE
    this[Vibrator::class] = VIBRATOR_SERVICE
    this[WallpaperManager::class] = WALLPAPER_SERVICE
    this[WifiP2pManager::class] = WIFI_P2P_SERVICE
    this[WifiManager::class] = WIFI_SERVICE
    this[WindowManager::class] = WINDOW_SERVICE
}

inline fun <reified T : Any> Context.systemService(): T {
    return getSystemServiceCompat(T::class)
}

@Suppress("UNCHECKED_CAST")
fun <T : Any> Context.getSystemServiceCompat(serviceClass: KClass<T>): T {
    if (Build.VERSION.SDK_INT >= 23) {
        return getSystemService(serviceClass.java)
    }

    val serviceName = systemServiceName(serviceClass)
    return if (serviceName != null)
        getSystemService(serviceName) as T
    else
        throw IllegalArgumentException("missing system service $serviceClass")
}

fun <T : Any> Context.systemServiceName(serviceClass: KClass<T>): String? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        getSystemServiceName(serviceClass.java)
    } else {
        SERVICES[serviceClass]
    }
}