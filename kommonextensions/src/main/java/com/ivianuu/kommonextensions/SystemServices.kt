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