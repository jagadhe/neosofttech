package com.Neosoft.Companyemp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Neosoft.Companyemp.entity.Companyemp;
import com.Neosoft.Companyemp.repo.CompanyempRepo;
import com.Neosoft.Companyemp.service.CompanyempService;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = CompanyempApplicationTests.class)
class CompanyempApplicationTests {
	@Mock
	private CompanyempRepo companyemprepo;
	@InjectMocks
	private CompanyempService Companyempservice = new CompanyempService();

	@Test
	void register() {
		Companyemp e = new Companyemp();
		e.setId(1);
		e.setName("jaga");
		e.setSurname("deesh");
		e.setDob(new Date(1998, 05, 17));
		e.setDepartment("software engineer");
		e.setJoiningdate(new Date(2021, 9, 06));
		e.setSalary(65000.00);
		e.setPincode(517408);
		;
		when(Companyempservice.register(e)).thenReturn(e);
		Assertions.assertEquals(e, e);
	}

	@Test
	void getUser() {
		Companyemp e = new Companyemp();
		e.setId(1);
		e.setName("jaga");
		e.setSurname("deesh");
		e.setDob(new Date(1998, 05, 17));
		e.setDepartment("software engineer");
		e.setJoiningdate(new Date(2021, 9, 06));
		e.setSalary(65000.00);
		e.setPincode(517408);
		Companyemp e2 = new Companyemp();
		e2.setId(2);
		e2.setName("sai");
		e2.setSurname("jithendra");
		e2.setDob(new Date(1997, 06, 20));
		e2.setDepartment("software engineer");
		e2.setJoiningdate(new Date(2021, 9, 06));
		e2.setSalary(90000.00);
		e2.setPincode(517508);
		List<Companyemp> list = new ArrayList<Companyemp>();
		list.add(e);
		list.add(e2);
		when(companyemprepo.findByNameOrSurname("jaga","jithendra")).thenReturn(list);
		List<Companyemp> emp = Companyempservice.getUser(e);

		Assertions.assertEquals(0, emp.size());
	}
	@Test
	void getUserp() {
		Companyemp e = new Companyemp();
		e.setId(1);
		e.setName("jaga");
		e.setSurname("deesh");
		e.setDob(new Date(1998, 05, 17));
		e.setDepartment("software engineer");
		e.setJoiningdate(new Date(2021, 9, 06));
		e.setSalary(65000.00);
		e.setPincode(517408);
		Companyemp e2 = new Companyemp();
		e2.setId(2);
		e2.setName("sai");
		e2.setSurname("jithendra");
		e2.setDob(new Date(1997, 06, 20));
		e2.setDepartment("software engineer");
		e2.setJoiningdate(new Date(2021, 9, 06));
		e2.setSalary(90000.00);
		e2.setPincode(517508);
		List<Companyemp> list = new ArrayList<Companyemp>();
		list.add(e);
		list.add(e2);
		when(companyemprepo.findByNameOrPincode("sai",517508)).thenReturn(list);
		List<Companyemp> emp = Companyempservice.getUserp(e2);

		Assertions.assertEquals(0, emp.size());
	}
	@Test
	void sortbydodandjoingdate() {
		Companyemp e = new Companyemp();
		e.setId(1);
		e.setName("jaga");
		e.setSurname("deesh");
		e.setDob(new Date(1998, 05, 17));
		e.setDepartment("software engineer");
		e.setJoiningdate(new Date(2021, 9, 06));
		e.setSalary(65000.00);
		e.setPincode(517408);
		Companyemp e2 = new Companyemp();
		e2.setId(2);
		e2.setName("sai");
		e2.setSurname("jithendra");
		e2.setDob(new Date(1997, 06, 20));
		e2.setDepartment("software engineer");
		e2.setJoiningdate(new Date(2021, 9, 06));
		e2.setSalary(90000.00);
		e2.setPincode(517508);
		List<Companyemp> list = new ArrayList<Companyemp>();
		list.add(e);
		list.add(e2);
		when(companyemprepo.findByDobOrJoiningdate(new Date(1997, 06, 20), new Date(2021, 9, 06))).thenReturn(list);
		List<Companyemp> emp = Companyempservice.sortbydodandjoingdate(new Date(1997, 9, 20), new Date(2021, 9, 06));

		Assertions.assertEquals(2, emp.size());
	}
	

}
