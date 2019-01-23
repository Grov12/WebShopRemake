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
        
    }
    
    
    
    public boolean checkPass(String id, String password) {
          String hql = "SELECT password from UserEntity where userName='" + id +"'";
          Query query = session.createQuery(hql);
          String pass = (String) query.uniqueResult();
        
      
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
      public void decreaseQuantityFromProducts(String name){
        Query query = session.createQuery("update ProductEntity set quantity=GREATEST(quantity-1,0) where name='" + name + "'");
        int result = query.executeUpdate();
        System.out.println("Result " + result);
    }
      
      
       public void increaseQuantityToProducts(String name){
        Query query = session.createQuery("update ProductEntity set quantity=quantity+1 where name='" + name + "'");
        int result = query.executeUpdate();
        System.out.println("Result " + result);
    }
      
      
      public boolean checkIfPossible(String name){
        Query query = session.createQuery("SELECT quantity from ProductEntity where name='" + name +"'");
        int m = (int) query.uniqueResult();
       
        System.out.println(m);
        
        if(m > 0) {
            return true;
        }
        
        else {
            return false;
        }
        
     
    }

      public void deleteUser(String name) {
          Query query = session.createQuery("DELETE FROM UserEntity where userName='" + name +"'");
          int result = query.executeUpdate();
      }
      
      public int getPointsFromUser(String name){
        Query query = session.createQuery("SELECT points from UserEntity where userName='" + name + "'");
        int pass = (int) query.uniqueResult();
        
        return pass;
        
        
    }
       public String getPassword(String email){
        Query query = session.createQuery("SELECT password from UserEntity where email='" + email + "'");
        String pass =(String) query.uniqueResult();
        
        return pass;
        
        
    }
      
      
}
