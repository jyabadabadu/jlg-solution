package com.javier.usersmanage.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;


@Aspect
public class LoggerAspect {
	
	private static int veces = 1;
	
	Logger log = Logger.getLogger(this.getClass());

	@Before("execution(* list(..))")
	public void imprimirlog(){
		log.info("Se ha llamado a método list : " + veces);
		veces++;
	}
	
}
