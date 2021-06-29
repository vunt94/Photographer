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

/**
 * This interface will define method about view table to implement.
 * <p>
 * Bugs: None
 *
 * @author Nguyen Tuan Vu
 */
public interface PageviewDAO {
    /**
     * Find the number of views page from database. The result contain an int number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    public int getNumberOfViewsPage() throws Exception;
    
    /**
     * Update the number of views page in database. The number of views page will 
     * be increased by 1 every time accessed the page
     *
     * @throws java.lang.Exception
     */
    public void updateNumberOfViewsPage() throws Exception;
}
