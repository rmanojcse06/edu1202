package edu.man.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/student.properties")
public class StudentConfiguration {
	@Value("student.id.startsWith")
	String startsWith;
	@Value("student.sortBy")
	String sortedBy;
	@Value("student.default.firstName")
	String defaultFirstName;
	@Value("student.default.lastName")
	String defaultLastName;
	@Value("student.default.rollNumber")
	String defaultRollNumber;
	
	@Override
	public String toString() {
		return "StudentConfiguration [startsWith=" + startsWith + ", sortedBy=" + sortedBy + ", defaultFirstName="
				+ defaultFirstName + ", defaultLastName=" + defaultLastName + ", defaultRollNumber=" + defaultRollNumber
				+ "]";
	}
	
	
	
}
