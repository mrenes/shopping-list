package com.mrenes.shoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment

// Fragment
inline fun <reified T : Any> Fragment.getExtra(key: String): T? {
    return arguments?.getExtra(key)
}

inline fun <reified T : Any> Fragment.getExtraOrDefault(key: String, default: T? = null): T? {
    return getExtra(key) ?: default
}

// Bundle
inline fun <reified T : Any> Bundle?.getExtra(key: String): T? {
    return requireNotNull(this) {
        "Bundle was null."
    }.get(key) as? T
}
