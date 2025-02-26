package com.example123.basicspringframework;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringHelloConfiguration {


		@Bean
		public String name(){
			return "Chaithra";
		}
	

}
