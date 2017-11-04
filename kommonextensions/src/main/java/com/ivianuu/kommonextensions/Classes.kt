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

/**
 * Returns The name of the class.
 */
fun Any.className(): String = this::class.java.name

/**
 * Returns The simple name of the class.
 */
fun Any.classSimpleName(): String = this::class.java.simpleName

/**
 * Returns The canonical name of the class.
 */
fun Any.classCanonicalName(): String = this::class.java.canonicalName