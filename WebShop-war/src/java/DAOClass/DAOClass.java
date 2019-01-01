/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClass;

import EntityClasses.ProductEntity;
import HibernateInterface.ServiceInterface;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;



public class DAOClass implements ServiceInterface {
    private Session session;         //used to physically connect to the database.
    private Transaction transaction;    
    
    
    
    
    public DAOClass(){
        
    }
    
    
    public Session openSession() {
       session = getSessionFactory().openSession();

       return session;

    }
    
    
    
    public Session openSessionWithTransaction() {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();

        return session;

    }
    
    
    
    public void closeCurrentSession() {

        session.close();

    }
    
    
    
    public void closeSessionWithTransaction() {
        transaction.commit();
        session.close();
        

    }
    
    
    
    private static SessionFactory getSessionFactory() {                 //Interface containing the details of the database

        Configuration configuration = new Configuration().configure();

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()

                .applySettings(configuration.getProperties());

        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        return sessionFactory;

    }
    
    
    
    public void setCurrentSession(Session currentSession) {

        this.session = currentSession;

    }
    
    
    
    public Session getCurrentSession() {

        return session;

    }

    @Override
    public void persist(Object entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public boolean checkPass(String id, String password) {
          String hql = "SELECT password from UserEntity where userName='" + id +"'";
          Query query = session.createQuery(hql);
          List list = query.list();
          String pass = list.toString().replaceAll("\\[", "").replaceAll("\\]","");
          
       
          if(pass.equals(password)) {
              return true;
          }
          else {
             return false;
          }
            
    }
    
    
    public void increaseAmountOrder(int price, int orderID){
        Query query = session.createQuery("update OrderEntity set totalprice=totalprice +'" + price + "'where orderid='" + orderID + "'");
        int result = query.executeUpdate();
    }
    
    public void giveAPointToUser(String userName){
        Query query = session.createQuery("update UserEntity set points=points +'" + 1 + "'where userName='" + userName + "'");
        int result = query.executeUpdate();
    }
    
    
     public List getListOfProducts(){
         Query q = session.createQuery("select e.articleID, e.name,e.price,e.quantity from ProductEntity e");
         List<Object[]> listOfItems= (List<Object[]>)q.list();
  
        
      
        
        
        return listOfItems;
    }
}
