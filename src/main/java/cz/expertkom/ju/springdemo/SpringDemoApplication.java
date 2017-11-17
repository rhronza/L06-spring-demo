package cz.expertkom.ju.springdemo;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import cz.expertkom.ju.springdemo.api.TestApi;
import cz.expertkom.ju.springdemo.api.impl.TestApiImpl;

@SpringBootApplication
@ComponentScan(basePackages = "cz.expertkom.ju")
public class SpringDemoApplication {

	@Autowired
	private Bus bus;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);

	}

	@Bean
	public TestApi testApi() {
		return new TestApiImpl();
	}

	@Bean
	public JSONProvider<?> jsonProvider() {
		JSONProvider<?> jsonProvider = new JSONProvider<>();
		jsonProvider.setDropRootElement(true);
		jsonProvider.setSupportUnwrapped(true);
		return jsonProvider;
	}

	@Bean
	public Server rsServer() {
		final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setProvider(jsonProvider());

		endpoint.setBus(bus);
		endpoint.setAddress("/experkom444/v1.0");
		endpoint.setServiceBeans(Arrays.<Object>asList(testApi()));
		return endpoint.create();
	}
}
