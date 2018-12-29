/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateInterface;

import java.io.Serializable;


public interface ServiceInterface<T, Id extends Serializable> {
    public void persist(T entity);
    public void update(T entity);
}
