package com.example.toolsshop;

import androidx.annotation.NonNull;

public class Perforator {
    private String title_perf;
    private String info_perf;
    private int imageResourceId_perf;

    public Perforator(String title_perf, String info_perf, int imageResourceId_perf) {
        this.title_perf = title_perf;
        this.info_perf = info_perf;
        this.imageResourceId_perf = imageResourceId_perf;
    }

    public String getTitle_perf() {
        return title_perf;
    }

    public void setTitle_perf(String title_perf) {
        this.title_perf = title_perf;
    }

    public String getInfo_perf() {
        return info_perf;
    }

    public void setInfo_perf(String info_perf) {
        this.info_perf = info_perf;
    }

    public int getImageResourceId_perf() {
        return imageResourceId_perf;
    }

    public void setImageResourceId_perf(int imageResourceId_perf) {
        this.imageResourceId_perf = imageResourceId_perf;
    }

    @NonNull
    @Override
    public String toString() {
        return title_perf;
    }
}
