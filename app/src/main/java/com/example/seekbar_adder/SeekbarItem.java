package com.example.seekbar_adder;

import android.widget.SeekBar;
import android.widget.TextView;

class SeekbarItem {

    TextView min,max;
    SeekBar seekbar;
    SeekbarItem(TextView min, SeekBar seekbar, TextView max){
    this.min=min;
    this.seekbar=seekbar;
    this.max=max;
    }

    public SeekBar getSeekbar() {
        return seekbar;
    }

    public TextView getMax() {
        return max;
    }

    public TextView getMin() {
        return min;
    }
}
