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
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.content.pm.ShortcutManager
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
import android.telecom.TelecomManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager

val Context.accessibilityManager get() = getSystemService(
        Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

val Context.accountManager get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

val Context.activityManager get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

val Context.alarmManager get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager

val Context.audioManager get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager

val Context.clipboardManager get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

val Context.connectivityManager get() = getSystemService(
        Context.CONNECTIVITY_SERVICE) as ConnectivityManager

val Context.keyguardManager get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

val Context.layoutInflater get() = getSystemService(
        Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

val Context.locationManager get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager

val Context.notificationManager get() = getSystemService(
        Context.NOTIFICATION_SERVICE) as NotificationManager

val Context.powerManager get() = getSystemService(Context.POWER_SERVICE) as PowerManager

val Context.searchManager get() = getSystemService(Context.SEARCH_SERVICE) as SearchManager

val Context.sensorManager get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager

val Context.telephonyManager get() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

val Context.vibrator get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

val Context.wallpaperManager get() = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager

val Context.wifiManager
    @SuppressLint("WifiManagerLeak")
    get() = getSystemService(Context.WIFI_SERVICE) as WifiManager

val Context.windowManager get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager

val Context.inputMethodManager get() = getSystemService(
        Context.INPUT_METHOD_SERVICE) as InputMethodManager

val Context.devicePolicyManager get() = getSystemService(
        Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

val Context.dropBoxManager get() = getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager

val Context.uiModeManager get() = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

val Context.downloadManager get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

val Context.storageManager get() = getSystemService(Context.STORAGE_SERVICE) as StorageManager

val Context.nfcManager get() = getSystemService(Context.NFC_SERVICE) as NfcManager

val Context.usbManager get() = getSystemService(Context.USB_SERVICE) as UsbManager

val Context.textServicesManager get() = getSystemService(
        Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

val Context.wifiP2pManager get() = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager

val Context.inputManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
get() = getSystemService(Context.INPUT_SERVICE) as InputManager

val Context.mediaRouter @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
get() = getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter

val Context.nsdManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
get() = getSystemService(Context.NSD_SERVICE) as NsdManager

val Context.displayManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
get() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

val Context.userManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
get() = getSystemService(Context.USER_SERVICE) as UserManager

val Context.bluetoothManager @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

val Context.appOpsManager @TargetApi(Build.VERSION_CODES.KITKAT)
get() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

val Context.captioningManager @TargetApi(Build.VERSION_CODES.KITKAT)
get() = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

val Context.consumerIrManager @TargetApi(Build.VERSION_CODES.KITKAT)
get() = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

val Context.printManager @TargetApi(Build.VERSION_CODES.KITKAT)
get() = getSystemService(Context.PRINT_SERVICE) as PrintManager

val Context.appWidgetManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

val Context.batteryManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager

val Context.cameraManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.CAMERA_SERVICE) as CameraManager

val Context.jobScheduler @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

val Context.launcherApps @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

val Context.mediaProjectionManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

val Context.mediaSessionManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

val Context.restrictionsManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

val Context.telecomManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.TELECOM_SERVICE) as TelecomManager

val Context.tvInputManager @TargetApi(Build.VERSION_CODES.LOLLIPOP)
get() = getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

val Context.subscriptionManager @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
get() = getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager

val Context.usageStatsManager @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
get() = getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

val Context.carrierConfigManager @TargetApi(Build.VERSION_CODES.M)
get() = getSystemService(Context.CARRIER_CONFIG_SERVICE) as CarrierConfigManager

val Context.fingerprintManager
    @TargetApi(Build.VERSION_CODES.M)
    get() = getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager

val Context.midiManager
    @TargetApi(Build.VERSION_CODES.M)
    get() = getSystemService(Context.MIDI_SERVICE) as MidiManager

val Context.networkStatsManager
    @TargetApi(Build.VERSION_CODES.M)
    get() = getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager

val Context.shortcutManager
    @TargetApi(Build.VERSION_CODES.N_MR1)
    get() = getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager