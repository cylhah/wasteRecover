package org.cbb.wasteRecovery.daoTest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class EmployeeDaoTest {
    @Resource
    private EmployeeDao employeeDao;

    @Test
    public void InsertEmployee() throws Exception{
        Employee  employee=new  Employee();
        Timestamp ts=new Timestamp(new Date().getTime());
        employee.setCreateTime(ts);
        employee.setAdminid(17);
        employee.setUsername("qw");
        employee.setPassword("as");

        employee.setStaid(1);
        employeeDao.InsertEmployee(employee);
    }

    @Test
    public void selectByUsername() throws Exception{

        Employee  employee=employeeDao.selectByUsername("qw");
        System.out.println(employee);
    }

    @Test
    public void selectByNameAndPass() throws Exception{
        Employee  employee=new  Employee();
        employee.setUsername("qw");
        employee.setPassword("as");
        Employee  employee1=employeeDao.selectByNameAndPass(employee);
        System.out.println(employee1);
    }

    @Test
    public void updatePassword() throws Exception{
        Employee  employee=new  Employee();

        employee.setPassword("cv");
        employee.setId(4);
        employeeDao.updatePassword(employee);
        System.out.println(employee);
    }
}
