package com.hibernate;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.entity.MyClass;

public class Test {

	public static void main(String[] args) {
	
		MyClass student=new MyClass();
		student.setId(1);
		student.setName("kanhaiya");
		MyClass student1=new MyClass();
		student1.setId(2);
		student1.setName("MSN");
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.save(student1);
		Criteria cre=session.createCriteria(MyClass.class);
		ArrayList<MyClass> list=(ArrayList) cre.list();
		for(MyClass m :list)
		{
			System.out.println(m.getId()+" -- "+m.getName());
		}
		session.getTransaction().commit();
		//MyClass c=(MyClass)session.get(MyClass.class, 2);
		//System.out.println(c.getId()+" "+c.getName());
		
		session.close();
		sf.close();
		
	}

}
