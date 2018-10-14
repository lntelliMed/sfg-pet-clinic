package com.lntellimed;

import com.lntellimed.controllers.ConstructorInjectedController;
import com.lntellimed.controllers.GetterInjectedController;
import com.lntellimed.controllers.MyController;
import com.lntellimed.controllers.PropertyInjectedController;
import com.lntellimed.examplebeans.FakeDataSource;
import com.lntellimed.examplebeans.FakeJmsBroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
		
		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
 		System.out.println(fakeDataSource.getUser());
 		
 		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
 		System.out.println(fakeJmsBroker.getUsername());
	}
}
