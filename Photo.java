package com.mycompany.rojectcsc212;
public class Photo {
    private String path;
    private LinkedList<String> tags;

    public Photo(String p, LinkedList<String> t) {
        path = p;
        tags = t;
    }

    public String getPath() {
        return path;
    }

    public LinkedList<String> getTags() {
        return tags;
    }
}



