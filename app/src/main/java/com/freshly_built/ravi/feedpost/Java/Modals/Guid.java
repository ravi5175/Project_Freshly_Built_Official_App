
package com.freshly_built.ravi.feedpost.Java.Modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Guid {

    @SerializedName("rendered")
    @Expose
    private String rendered;

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

}
