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

import android.util.Patterns

/**
 * Returns whether this char sequence is a email or not
 */
fun CharSequence.isEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()

/**
 * Returns whether this char sequence is a ip or not
 */
fun CharSequence.isIp() = Patterns.IP_ADDRESS.matcher(this).matches()

/**
 * Returns whether this char sequence is a email or not
 */
fun CharSequence.isUrl() = Patterns.WEB_URL.matcher(this).matches()

/**
 * Returns whether this char sequence is a phone number or not
 */
fun CharSequence.isPhone() = Patterns.PHONE.matcher(this).matches()