/*
 * Copyright(C) 2021,  vunthe141507.
 * J3.L.P0017
 * Java Web
 *
 * Record of change:
 * DATE                Version           AUTHOR            DESCRIPTION
 * 16/6/2021             1.0              VuNT           Fix variable name
 * 21/6/2021             2.0              VuNT      Fix package dao and dao.impl
 * 23/6/2021             3.0              VuNT           Answer the question
 */
package dao;

import entity.Contact;

/**
 * This interface will define method about Contact table to implement.
 * <p>
 * Bugs: None
 *
 * @author Nguyen Tuan Vu
 */
public interface ContactDAO {
    /**
     * Find the Contact. The result contain a Contact of 
     * <code>entity.Contact</code> objects
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    public Contact getContact() throws Exception;
}
