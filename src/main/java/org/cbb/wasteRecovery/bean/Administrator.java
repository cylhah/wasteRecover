package org.cbb.wasteRecovery.bean;

import java.util.List;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Administrator {
    private int id;
    private int staid;
    private String username;
    private String password;

    private List<Employee> employeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaid() {
        return staid;
    }

    public void setStaid(int staid) {
        this.staid = staid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public Administrator() {
		// TODO Auto-generated constructor stub
	}
}
