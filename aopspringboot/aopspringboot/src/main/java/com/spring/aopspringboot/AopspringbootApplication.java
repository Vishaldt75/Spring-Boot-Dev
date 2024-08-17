package com.spring.aopspringboot;

import com.spring.aopspringboot.DAO.AccountDAO;
import com.spring.aopspringboot.DAO.MembershipDAO;
import com.spring.aopspringboot.service.TrafficService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopspringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficService trafficService)
	{
		return runner ->{
			//demoTheBeforeAdvice(accountDAO,membershipDAO);

			//demotheAfterAdvice(accountDAO);
			//demotheAfterThrowingAdvice(accountDAO);

			//demoTheAfterAdviceNew(accountDAO);

			//demoTheArroundAdvice(trafficService);
			//demoTheAroundAdviceHandleException(trafficService);
			demoTheAroundAdviceRethrowException(trafficService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficService trafficService) {
		System.out.println("\nMain Program : demoTheAroundAdviceRethrowException()");
		System.out.println("Calling getFortune");

		boolean tripWire=true;

		String data=trafficService.getFortune(tripWire);

		System.out.println("My Fortune is : "+data);
	}

	private void demoTheAroundAdviceHandleException(TrafficService trafficService) {
		System.out.println("\nMain Program : demoTheAroundAdviceHandleException()");
		System.out.println("Calling getFortune");

		boolean tripWire=true;
		String data=trafficService.getFortune(tripWire);

		System.out.println("My Fortune is : "+data);
	}

	private void demoTheArroundAdvice(TrafficService trafficService) {

		System.out.println("\nMain Program : demoTheArroundAdvice()");
		System.out.println("Calling getFortune");

		String data=trafficService.getFortune();

		System.out.println("My Fortune is : "+data);
	}

	private void demoTheAfterAdviceNew(AccountDAO accountDAO) {
		List<Account> theAccount=null;
		try {
			boolean tripWire=false;
			theAccount=accountDAO.findAccounts(tripWire);
		}catch (Exception exception)
		{
			System.out.println("Main Program : Caught Exception in demoTheAfterAdviceNew: "+exception);
		}

		System.out.println("Main Program : demoTheAfterAdviceNew()");
		System.out.println("---------------------------------------");
		System.out.println(theAccount);
		System.out.println("\n");
	}

	private void demotheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> theAccount=null;
		try {
			boolean tripWire=true;
			theAccount=accountDAO.findAccounts(tripWire);
		}catch (Exception exception)
		{
			System.out.println("Main Program : Caught Exception : "+exception);
		}

		System.out.println("Main Program : demotheAfterThrowingAdvice()");
		System.out.println("---------------------------------------");
		System.out.println(theAccount);
		System.out.println("\n");
	}

	private void demotheAfterAdvice(AccountDAO accountDAO) {
		List<Account> theAccount=accountDAO.findAccounts();
		System.out.println("Main Program : demotheAfterAdvice()");
		System.out.println("---------------------------------------");
		System.out.println(theAccount);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {
		Account account=new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");
		accountDAO.addAccount(account,true);
		accountDAO.doWork();
		accountDAO.setName("Vishal");
		accountDAO.setServiceCode("23445");
		String name=accountDAO.getName();
		String serviceCode=accountDAO.getServiceCode();

		membershipDAO.addMembers();
		membershipDAO.goToSleep();
	}


}
