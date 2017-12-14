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

import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.widget.TextView

// COMPOUND DRAWABLES

inline var  TextView.compoundDrawableLeft: Drawable?
    get() {
        return if (compoundDrawables.isEmpty()) {
            null
        } else {
            compoundDrawables[0]
        }
    }
    set(value) {
        setOptionalCompoundDrawables(left = value)
    }

inline var  TextView.compoundDrawableStart: Drawable?
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() {
        return if (compoundDrawablesRelative.isEmpty()) {
            null
        } else {
            compoundDrawablesRelative[0]
        }
    }
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    set(value) {
        setOptionalRelativeCompoundDrawables(start = value)
    }

inline var  TextView.compoundDrawableTop: Drawable?
    get() {
        return if (compoundDrawables.isEmpty()) {
            null
        } else {
            compoundDrawables[1]
        }
    }
    set(value) {
        setOptionalCompoundDrawables(top = value)
    }

inline var  TextView.compoundDrawableRight: Drawable?
    get() {
        return if (compoundDrawables.isEmpty()) {
            null
        } else {
            compoundDrawables[2]
        }
    }
    set(value) {
        setOptionalCompoundDrawables(right = value)
    }

inline var  TextView.compoundDrawableEnd: Drawable?
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() {
        return if (compoundDrawablesRelative.isEmpty()) {
            null
        } else {
            compoundDrawablesRelative[2]
        }
    }
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    set(value) {
        setOptionalRelativeCompoundDrawables(end = value)
    }

inline var  TextView.compoundDrawableBottom: Drawable?
    get() {
        return if (compoundDrawables.isEmpty()) {
            null
        } else {
            compoundDrawables[3]
        }
    }
    set(value) {
        setOptionalCompoundDrawables(bottom = value)
    }

inline fun TextView.setOptionalCompoundDrawables(left: Drawable? = compoundDrawableLeft,
                                          top: Drawable? = compoundDrawableTop,
                                          right: Drawable? = compoundDrawableRight,
                                          bottom: Drawable? = compoundDrawableBottom) {
    setCompoundDrawables(left, top, right, bottom)
}

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun TextView.setOptionalRelativeCompoundDrawables(start: Drawable? = compoundDrawableStart,
                                                  top: Drawable? = compoundDrawableTop,
                                                  end: Drawable? = compoundDrawableEnd,
                                                  bottom: Drawable? = compoundDrawableBottom) {
    setCompoundDrawablesRelative(start, top, end, bottom)
}