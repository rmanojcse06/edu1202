package edu.man.activators;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans/student-beans.xml");
		try {
			edu.man.pojo.Student student = (edu.man.pojo.Student)context.getBean(edu.man.pojo.Student.class);
			System.out.println(student);
		}catch(org.springframework.beans.factory.NoUniqueBeanDefinitionException | org.springframework.beans.factory.BeanInitializationException e) {
			e.printStackTrace();			
		}
		System.out.println("\n\n Updating Singleton bean inside Prototype bean");
		edu.man.pojo.Student firstSingleton = (edu.man.pojo.Student)context.getBean("firstSingleton");
		firstSingleton.setFirstName("XXXX");
		edu.man.pojo.Student singletonInsidePrototype = (edu.man.pojo.Student)context.getBean("singletonInsidePrototype");
		System.out.println("\n\tsingletonInsidePrototype => "+singletonInsidePrototype);
		System.out.println("\t");
		edu.man.pojo.Student prototypeInsideSingleton = (edu.man.pojo.Student)context.getBean("prototypeInsideSingleton");
		prototypeInsideSingleton.setFirstName("Mary");
		System.out.println("\n\tprototypeInsideSingleton => "+prototypeInsideSingleton 
				+";\n\tsingletonInsidePrototype => "+singletonInsidePrototype
		);
		edu.man.pojo.Student singletonInsideSingleton = (edu.man.pojo.Student)context.getBean("singletonInsideSingleton");
		singletonInsideSingleton.setLastName("Manuel");
		System.out.println("\n\tprototypeInsideSingleton => "+prototypeInsideSingleton 
				+";\n\tsingletonInsidePrototype => "+singletonInsidePrototype
				+";\n\tsingletonInsideSingleton => "+singletonInsideSingleton
		);
		
		
		System.out.println(" \n\n\n SERVICE :: ");
		edu.man.service.StudentService studentService = (edu.man.service.StudentService)context.getBean(edu.man.service.StudentService.class);
		java.util.List list = studentService.getStudents();
		list.stream().forEach(System.out::println);
		
		System.out.println("\n");
		
		java.util.Map<String,edu.man.pojo.Student> map = studentService.getStudentByRoll();
		map.forEach((k,v)->System.out.println("k="+k+"; v="+v));
		
	}
}
