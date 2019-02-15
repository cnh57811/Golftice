package com.cgavlabs.golftice.common

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment


/**
 * Pass arguments to a Fragment without the hassle of
 * creating a static newInstance() method for every Fragment.
 *
 * @return Returns an instance of Fragment as the specified generic type with the params applied as arguments
 */
inline fun <reified T : Fragment> instanceOf(vararg params: Pair<String, Any>) = T::class.java.newInstance().apply {
    arguments = bundleOf(*params)
}