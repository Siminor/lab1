/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starter;

import entity.Studentyi;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 *
 * 
 */
public class Main {

    public static void main(String[] args) {
     SessionFactory sf = HibernateUtil1.getSessionFactory();
        Session s = sf.openSession();
        
       Query query = s.createQuery("from  Studentyi s where Status='enrolled'"); //lab 1 task 1
        //Query query = s.createQuery("from  Studentyi s where Status='enrolled' Order by StatusDate Limit 1"); //lab 1 task 2
       List<Studentyi> sts = (List<Studentyi>) query.list();
 
       for (Studentyi st : sts){
        System.out.println(st.getImya()+ " "+ st.getFamiliya()+ " "+ st.getOtchestvo() + " " + st.getGruppyi().getNazvanie());
        } 
       s.close();
    }

}