package com.luteapp.alarmio.data.preference

import android.content.Intent

/**
 * A preference item that allows the user to select
 * an image from a file (the resulting preference
 * contains a valid image path / URI).
 */
class ImageFilePreferenceData(private val preference: com.luteapp.alarmio.data.PreferenceData, name: Int) : CustomPreferenceData(name) {

    override fun getValueName(holder: CustomPreferenceData.ViewHolder): String = ""

    override fun onClick(holder: CustomPreferenceData.ViewHolder) {
        holder.context.startActivity(Intent(holder.context, com.luteapp.alarmio.activities.FileChooserActivity::class.java).apply {
            putExtra(com.luteapp.alarmio.activities.FileChooserActivity.EXTRA_PREFERENCE, preference)
            putExtra(com.luteapp.alarmio.activities.FileChooserActivity.EXTRA_TYPE, "image/*")
        })
    }
}
