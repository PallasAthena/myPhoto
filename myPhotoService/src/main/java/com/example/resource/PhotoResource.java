package com.example.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Photo;
import com.example.domain.Photos;
import com.example.service.PhotoService;

/**
 * <p>BookResource class.</p>
 *
 * @author Joy
 * @version $Id: $Id
 */
@Path("photos")
public class PhotoResource {
    private static final Logger LOGGER = Logger.getLogger(PhotoResource.class);
    @Autowired
    private PhotoService photoService;

    /**
     * get all photos
     * <p>getphotos.</p>
     *
     * @return a {@link com.example.domain.Photos} object.
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Photos getPhotos() {
        final Photos photos = photoService.getPhotos();
        PhotoResource.LOGGER.debug(photos);
        return photos;
    }

   
    /**
     * <p>getBookByQuery.</p>
     *
     * @param bookTime a {@link java.lang.String} object.
     * @return a {@link com.example.domain.Photo} object.
     */
    @Path("/photo")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Photo> getPhotoByQuery(@QueryParam("time") final String photoTime) {
        final List<Photo> photos = photoService.getPhotos(photoTime);
        PhotoResource.LOGGER.debug(photos);
        return photos;
    }

    /**
     * <p>savePhoto.</p>
     *
     * @param book a {@link com.example.domain.Photo} object.
     * @return a {@link com.example.domain.Photo} object.
     */
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML })
    public String savePhoto(final List<Photo> photoList) {
        return photoService.savePhoto(photoList);
    }

    

    /**
     * <p>deletePhoto.</p>
     *
     * @param photoId a {@link java.lang.Integer} object.
     * @return a {@link java.lang.String} object.
     */
    @Path("/{photoId:[0-9]*}")
    @DELETE
    public String deletePhoto(@PathParam("photoId") final Long photoId) {
        if (photoService.deletePhoto(photoId)) {
            return "Deleted photo id=" + photoId;
        } else {
            return "Deleted photo failed id=" + photoId;
        }
    }
}
