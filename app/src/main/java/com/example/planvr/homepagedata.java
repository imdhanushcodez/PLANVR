package com.example.planvr;

public class homepagedata {
    int vrimg;
    String porjectname;

    public homepagedata() {
    }

    public homepagedata(int vrimg, String porjectname) {
        this.vrimg = vrimg;
        this.porjectname = porjectname;
    }

    public int getVrimg() {
        return vrimg;
    }

    public void setVrimg(int vrimg) {

        this.vrimg = vrimg;
    }

    public String getPorjectname() {
        return porjectname;
    }

    public void setPorjectname(String porjectname) {
        this.porjectname = porjectname;
    }
}
