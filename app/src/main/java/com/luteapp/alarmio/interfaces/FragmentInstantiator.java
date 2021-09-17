package com.luteapp.alarmio.interfaces;

import androidx.annotation.Nullable;

import com.luteapp.alarmio.fragments.BasePagerFragment;

public interface FragmentInstantiator {
    @Nullable
    BasePagerFragment newInstance(int position);
    @Nullable
    String getTitle(int position);
}
