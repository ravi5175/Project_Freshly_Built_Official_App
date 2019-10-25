package com.freshly_built.ravi.feedpost.Java;


public class blogViewModel {

    public static final int IMAGE_TYPE=1;
    public String title,subtitle,Image;
    public int type;

    public blogViewModel (int mtype, String mtitle, String msubtitle, String image)
    {
        this.Image=image;
        this.subtitle=msubtitle;
        this.title=mtitle;
        this.type=mtype;
    }





}
