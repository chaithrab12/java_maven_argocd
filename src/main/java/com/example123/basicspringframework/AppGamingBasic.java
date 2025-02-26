package com.example123.basicspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Configuration
public class AppGamingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(SpringHelloConfiguration.class);
		System.out.println(context.getBean("name"));
	}

}
