package com.example.surendrasingh.newfoodorder;

public class food {
    String name,prize,image,desc;

    public food(String name, String prize, String image, String desc) {
        this.name = name;
        this.prize = prize;
        this.image = image;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getPrize() {
        return prize;
    }

    public String getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
