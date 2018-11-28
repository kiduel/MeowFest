package com.example.android.meowfest.data;

public class Cat {
    String title;
    String timeStamp;
    String image_url;
    String description;

    public Cat(String title, String timeStamp, String image_url, String description) {
        this.title = title;
        this.timeStamp = timeStamp;
        this.image_url = image_url;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getDescription() {
        return description;
    }
}

