package pl.mps.kodilla.hibernate.manytomany.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mps.kodilla.hibernate.manytomany.Company;
import pl.mps.kodilla.hibernate.manytomany.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testFindSpecifiedEmployee() {
        //Given
        Employee jhonSmith = new Employee("John", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        lindaKovalsky.getCompanies().add(softwareMachine);
        softwareMachine.getEmployees().add(lindaKovalsky);
        jhonSmith.getCompanies().add(softwareMachine);
        jhonSmith.getCompanies().add(dataMaesters);
        softwareMachine.getEmployees().add(jhonSmith);
        dataMaesters.getEmployees().add(jhonSmith);
        String expected = "Smith";

        //When
        employeeDao.save(jhonSmith);
        String actual = employeeDao.retrieveEmployeeByLastName("Smith").get(0).getLastname();

        //Than
        Assert.assertEquals(expected, actual);

        //CleanUp
        try {
            employeeDao.delete(jhonSmith);
            employeeDao.delete(lindaKovalsky);
            companyDao.delete(softwareMachine);
            companyDao.delete(dataMaesters);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testFindSpecifiedCompany() {
        //Given
        Employee jhonSmith = new Employee("John", "Smith");
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Masters");
        jhonSmith.getCompanies().add(softwareMachine);
        jhonSmith.getCompanies().add(dataMaesters);
        softwareMachine.getEmployees().add(jhonSmith);
        dataMaesters.getEmployees().add(jhonSmith);
        String expected = "Software Machine";

        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        String actual = companyDao.retrieveCompanyByBeginning("Sof").get(0).getName();

        //Than
        Assert.assertEquals(expected, actual);

        //CleanUp
        try {
            companyDao.delete(softwareMachine);
            companyDao.delete(dataMaesters);
            employeeDao.delete(jhonSmith);
        } catch (Exception e) {
            //do nothing
        }
    }
}