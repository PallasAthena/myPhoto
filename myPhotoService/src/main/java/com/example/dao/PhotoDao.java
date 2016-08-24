package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.example.domain.Photo;

/**
 * <p>BookDao class.</p>
 *
 * @author Joy
 * @version $Id: $Id
 */
@Repository
public class PhotoDao {
    private static final Logger LOGGER = Logger.getLogger(PhotoDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * <p>Constructor for BookDao.</p>
     */
    public PhotoDao() {
    }

    /**
     * <p>findById.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     * @return a {@link com.example.domain.Photo} object.
     */
    public List<Photo> findByTime(final String time) {
    	String queryByTime = "select * from simple_photo where phototime >= " + time;
        Query query = entityManager.createQuery(queryByTime);
        return((List<Photo>)(query.getResultList()));
        
    }

    /**
     * <p>findAll.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Photo> findAll() {
        return findAll(false, 0, 0);
    }

    /**
     * <p>findAll.</p>
     *
     * @param isPaging a boolean.
     * @param firstResult a int.
     * @param maxResults a int.
     * @return a {@link java.util.List} object.
     */
    public List<Photo> findAll(final boolean isPaging, final int firstResult, final int maxResults) {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Photo> cq = cb.createQuery(Photo.class);
        final TypedQuery<Photo> q = entityManager.createQuery(cq);
        if (isPaging) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    /**
     * <p>remove.</p>
     *
     * @param photoId a {@link java.lang.Integer} object.
     * @return a boolean.
     */
    @Transactional
    public boolean remove(final Long photoId) {
        final Photo photo0 = findById(photoId);
        if (photo0 != null) {
            entityManager.remove(photo0);
            return true;
        } else {
            return false;
        }
    }

    /**
    * <p>store.</p>
    *
    * @param entity a {@link com.example.domain.Photo} object.
    * @return a {@link com.example.domain.Photo} object.
    */
    @Transactional
    public Photo store(final Photo entity) {
        return entityManager.merge(entity);
    }

    /**
     * <p>save.</p>
     *
     * @param entity a {@link com.example.domain.Photo} object.
     */
    @Transactional
    public void save(final Photo entity) {
        entityManager.persist(entity);
    }
    
    @Transactional
    public Photo findById(final Long photoId) {
        return entityManager.find(Photo.class, photoId);
    }


}
