package com.permissionx.guangcai

import androidx.fragment.app.FragmentActivity

object PersmissionX {
    private const val TAG = "InvisibleFragment"

    fun request(
        activity: FragmentActivity,
        vararg permisssions: String,
        callback: com.permissionx.guangcai.PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedfragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedfragment != null) {
            existedfragment as com.permissionx.guangcai.InvisibleFragment
        } else {
            val invisibleFragment = com.permissionx.guangcai.InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment,
                TAG
            ).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permisssions)


    }
}