package com.example.restservice;

import com.example.restservice.Date.CompanyEntity;
import com.example.restservice.Date.DataBaseRepository;
import com.example.restservice.Service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class CompanyServiceTest {
	@InjectMocks
	CompanyService companyService;
	@Mock
	DataBaseRepository dataBaseRepository;


	@Test
	public void shouldReturnAllCompanyWhenFindAll() {

		// given
		HashMap<Long, CompanyEntity> expect = new HashMap<Long, CompanyEntity>();
		CompanyEntity companyEntity1 = new CompanyEntity(1L, "Thoughtworks", "西安");
		CompanyEntity companyEntity2 = new CompanyEntity(2L, "Bilibili", "上海");
		expect.put(companyEntity1.getId(),companyEntity1);
		expect.put(companyEntity2.getId(), companyEntity2);

		// when
		Mockito.when(dataBaseRepository.getCompanyDataBase()).thenReturn(expect);
		Map<Long, CompanyEntity> actual = companyService.findAll();
		// then
		Assertions.assertEquals(expect,actual);
	}

}
