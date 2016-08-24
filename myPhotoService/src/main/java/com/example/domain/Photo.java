package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "simple_photo")
@XmlRootElement
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int NAME_LENGTH = 100;

    private Long photoId;
    private String photoTime;
    private String location;

    public Photo() {
        super();
    }

    public Photo(final Long photoId) {
        this.photoId = photoId;
    }

    public Photo(final String photoTime) {
        this.photoTime = photoTime;
    }

    public Photo(final Long photoId, final String photoTime) {
        super();
        this.photoId = photoId;
        this.photoTime = photoTime;
    }

    public Photo(final Long photoId, final String photoTime, String location) {
        this.photoId = photoId;
        this.photoTime = photoTime;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EMP_SEQ")
    @SequenceGenerator(name = "EMP_SEQ")
    @Column(unique = true, nullable = false, name = "PHOTOID")
    @XmlAttribute(name = "photoId")
    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(final Long photoId) {
        this.photoId = photoId;
    }

    @Column(length = Photo.NAME_LENGTH, name = "PHOTOTIME")
    @XmlAttribute(name = "photoTime")
    public String getPhotoTime() {
        return photoTime;
    }

    public void setPhotoName(final String photoTime) {
        this.photoTime = photoTime;
    }

    @Column(length = Photo.NAME_LENGTH, name = "LOCATION")
    @XmlAttribute(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return photoId + ":" + photoTime + ":" + location;
    }
}
