package assignment14.session1.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import assignment14.session1.bean.Person;
 
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {
     
    @Transactional(readOnly=true)
    public List<?> selectAll() {
        List<?> personList = getHibernateTemplate().find("from Person");
        System.out.println("Total Persons: " + personList.size());
        return personList;
    }
     
      
    @Transactional(readOnly=false)
    public void insert(final String Name){
        System.out.println("Create new person " + Name);
        Person person = getHibernateTemplate().execute(new HibernateCallback<Person>() {
 
            public Person doInHibernate(Session session) throws HibernateException {
            	Person person = new Person();
            	person.setName(Name);
            	person.setEmail("ajay@gmail.com");
                session.saveOrUpdate(person);
                return person;
            }
        });
        System.out.println("Person created " + person);
    }
     
//    @Transactional(readOnly=false)
//    public void savePerson(Person person){
//        System.out.println("Create new person " + person);
//        Configuration c = new Configuration();
//    	c.configure("hibernate.cfg.xml");
//    	
//    	@SuppressWarnings("deprecation")
//		SessionFactory sf = c.buildSessionFactory();
//    	System.out.println("session factory "+sf);
//        Session session = sf.openSession();
//    	Transaction tran = session.beginTransaction();
//        session.save(person);
//        System.out.println("Person created " + person); 
//        tran.commit();
//        session.close();
//    } 
}
