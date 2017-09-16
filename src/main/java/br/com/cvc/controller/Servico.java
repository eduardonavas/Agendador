package br.com.cvc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
//@ComponentScan({"br.com.cvc.servico", "br.com.cvc.controller" ,"br.com.cvc.view"})
public class Servico {
	
	public static void main(String[] args){
		SpringApplication.run(Servico.class, args);
	}
}
