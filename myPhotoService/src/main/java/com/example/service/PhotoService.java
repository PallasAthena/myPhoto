package com.example.service;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PhotoDao;
import com.example.domain.Photo;
import com.example.domain.Photos;

@Service
/**
 * <p>BookService class.</p>
 *
 * @author hanl
 * @version $Id: $Id
 */
public class PhotoService {
    private static final Logger LOGGER = Logger.getLogger(PhotoService.class);
    @Autowired
    private PhotoDao photoDao;

    /**
     * <p>Constructor for BookService.</p>
     */
    public PhotoService() {
    }
    
    
    /**
     * <p>getPhotos.</p>
     *
     * @return a {@link com.example.domain.Photos} object.
     */
    public Photos getPhotos() {
        return new Photos(photoDao.findAll());
    }
    
    /**
     * <p>getPhotos.</p>
     *
     * @return a {@link com.example.domain.Photos} object.
     */
    public List<Photo> getPhotos(String photoTime) {	
        return photoDao.findByTime(photoTime);
    }
    
    

    /**
     * <p>savePhotos.</p>
     *
     * @param book a {@link com.example.domain.Photo} object.
     * @return a {@link com.example.domain.Photo} object.
     */
    public String savePhoto(final List<Photo> photoList) {
    	String saveFlag = "Success!";
    	Photo photoStored = null;
    	for (Photo photo:photoList){
    		photoStored = photoDao.store(photo);
    		if (photoStored == null){
    			saveFlag = "Failed";    
    			return saveFlag;
    		}
    	}
        return saveFlag;
    }


    /**
     * <p>deletePhoto.</p>
     *
     * @param photoId a {@link java.lang.Integer} object.
     * @return a boolean.
     */
    public boolean deletePhoto(final Long photoId) {
        return photoDao.remove(photoId);
    }
}
