package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CustomerRepository customerRepo;
	
	@Test
	void findbyname() {
		List<Customer> list = customerRepo.findByName("이순신");
		System.out.println(list);
		assertEquals("이순신", list.get(0).getName());				
	}
	
	
	@Test
	void findall() {
		Iterable<Customer> list = customerRepo.findAll();
//		list.forEach(cust -> System.out.println(cust.getName()));
		
		Iterator<Customer> iter = list.iterator();
		while(iter.hasNext()) {
			Customer reuslt = iter.next();
			System.out.println(list.iterator().next().getName()); //주석 처리한 부분과 동일
		}
	}
	
		
	@Test
	void save() {
		Customer cust = new Customer();
		cust.setName("홍길동");
		cust.setPhone("010-1111");
		Customer result = customerRepo.save(cust);
		assertEquals(cust.getName(), result.getName());
	}

}
