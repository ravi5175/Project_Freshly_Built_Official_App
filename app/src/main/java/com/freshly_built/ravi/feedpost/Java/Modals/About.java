
package com.freshly_built.ravi.feedpost.Java.Modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class About {

    @SerializedName("href")
    @Expose
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
