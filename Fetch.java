package com.cg.hibernatequery;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Fetch {
	public static void main(String[] args) {    
			    
			     StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
			        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
			          
			        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
			        Session session=factory.openSession();  
			                    
			    //Hibernate Named Query    
			  TypedQuery query = session.getNamedQuery("findEmployeeByName"); //alias or nickname   
			            query.setParameter("name","amit");   
			                    
		            List<Employee> employees=query.getResultList();   
		            
			    Iterator<Employee> itr=employees.iterator();    
			     while(itr.hasNext()){    
		    Employee e=itr.next();    
			    System.out.println(e);    
		     }    
		    session.close();     
		  }    
			
}
