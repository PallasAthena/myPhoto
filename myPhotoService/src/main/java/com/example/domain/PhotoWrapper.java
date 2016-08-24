package com.example.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PhotoWrapper implements Serializable {
    private static final long serialVersionUID = 1L;

    private Photo photo;
    private String link;

    public PhotoWrapper() {

    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @XmlAttribute(name = "photoId")
    public Long getPhotoId() {
        return photo.getPhotoId();
    }

    @XmlAttribute(name = "photoTime")
    public String getPhotoTime() {
        return photo.getPhotoTime();
    }

    @XmlAttribute(name = "location")
    public String getLocation() {
        return photo.getLocation();
    }

    @XmlAttribute(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return photo + ":" + link;
    }
}
