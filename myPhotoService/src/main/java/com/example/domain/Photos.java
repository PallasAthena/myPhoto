package com.example.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Books class.</p>
 *
 * @author hanl
 * @version $Id: $Id
 */
@XmlRootElement(name = "photos")
public class Photos implements Serializable {
    private static final long serialVersionUID = -5070487415443208853L;
    private List<Photo> photoList;

    /**
     * <p>Constructor for photos.</p>
     */
    public Photos() {
        super();
    }

    /**
     * <p>Constructor for Books.</p>
     *
     * @param bookList a {@link java.util.List} object.
     */
    public Photos(final List<Photo> photoList) {
        super();
        this.photoList = photoList;
    }

    /**
     * <p>Getter for the field <code>bookList</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    @XmlElement(name = "photo")
    @XmlElementWrapper
    public List<Photo> getPhotoList() {
        return photoList;
    }

    /**
     * <p>Setter for the field <code>bookList</code>.</p>
     *
     * @param bookList a {@link java.util.List} object.
     */
    public void setBookList(final List<Photo> photoList) {
        this.photoList = photoList;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "{" + photoList + "}";
    }
}
