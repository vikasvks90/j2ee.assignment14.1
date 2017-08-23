package assignment14.session1.service;

import java.io.IOException;

import org.hibernate.MappingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import assignment14.session1.dao.PersonDao;
 
public class PersonService {
    private static ApplicationContext ctx;
    public static void main(String[] args) throws MappingException, IOException {

        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonService) ctx.getBean("personService");
        personService.execute();
    }
 
    @Transactional(readOnly = false)
    public void execute() {
    	ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	PersonDao personDao = (PersonDao) ctx.getBean("personDao");
        personDao.insert("Ajay");
        System.out.println("List of persons: " + personDao.selectAll());
    }
 
}
