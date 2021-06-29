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
package session;

import dao.PageviewDAO;
import dao.impl.PageviewDAOImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * This class implement HttpSessionListener, has method that catch
 * sessionCreated event to count the number of views access page
 * <p>
 * Bugs: None
 *
 * @author Nguyen Tuan Vu
 */
public class SessionListener implements HttpSessionListener{
    
    /**
     * Get number of views page. The number of views page in View table will be 
     * returned and format to list of 6 numbers. The result is a list of 
     * <code>java.lang.String</code> objects
     *
     * @return a list of <code>java.lang.String</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public static List<String> getNumberOfViewsPage() throws Exception{
        List<String> listNumberOfViewsPage = new ArrayList<>();
        PageviewDAO pageviewDAO = new PageviewDAOImpl();
        int numberOfViewsPage = pageviewDAO.getNumberOfViewsPage();
        // format number of views page to 6 numbers
        String formatNumberOfViewPage = String.format("%06d", numberOfViewsPage);
        for (int i = formatNumberOfViewPage.length() - 1; i >= 0; i--) {
            listNumberOfViewsPage.add(formatNumberOfViewPage.charAt(i) + "");
        }
        return listNumberOfViewsPage;
    }
    
    /**
     * Catch sessionCreated event. When session is created, this method will
     * catch that event, then update the number of views page in View table 
     * in database, then push list viewPage to session
     *
     * @param se the session event. It is a
     * <code>javax.servlet.http.HttpSessionEvent;</code> object
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        try {           
            PageviewDAO pageviewDAO = new PageviewDAOImpl();
            pageviewDAO.updateNumberOfViewsPage();
            HttpSession session = se.getSession();
//            session.setMaxInactiveInterval(15*60);
            session.setAttribute("view", getNumberOfViewsPage());
        } catch (Exception ex) {
            Logger.getLogger(SessionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    /**
     * Catch Destroyed event.
     *
     * @param se the session event. It is a
     * <code>javax.servlet.http.HttpSessionEvent;</code> object
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        
    }
    
}
