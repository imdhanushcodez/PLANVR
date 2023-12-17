package com.example.planvr;

public class builderdata {
    int img;
    String name,address,phone;

    public builderdata() {
    }

    public builderdata(int img, String name, String address, String phone) {
        this.img = img;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
