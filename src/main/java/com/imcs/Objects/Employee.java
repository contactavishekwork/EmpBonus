/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.Objects;

/**
 *
 * @author Avishek
 */
public class Employee {
    private int empID;
    private int deptID;
    private String empName;
    private double empSal;
    private int empSalGrade;

    public Employee() {
        empID = 0011;
        deptID = 0011;
        empName = "Default";
        empSal = 1.00;
        empSalGrade = 1;
    }

    public Employee(int empID, int deptID, String empName, double empSal) {
        this.empID = empID;
        this.deptID = deptID;
        this.empName = empName;
        this.empSal = empSal;        
    }
    
    /**
     * @return the empID
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @return the empSal
     */
    public double getEmpSal() {
        return empSal;
    }

    /**
     * @return the empSalGrade
     */
    public int getEmpSalGrade() {
        return empSalGrade;
    }

    /**
     * @param empID the empID to set
     */
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the deptID
     */
    public int getDeptID() {
        return deptID;
    }

    /**
     * @param deptID the deptID to set
     */
    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }
    
    /**
     * @param empSal the empSal to set
     */
    public void setEmpSal(double empSal) {
        this.empSal = empSal;
        
        if(empSal > 0 && empSal < 50000)
            setEmpSalGrade(1);
        else if(empSal >=50000 && empSal < 100000)
            setEmpSalGrade(2);
        else if(empSal >=100000 && empSal < 200000)
            setEmpSalGrade(3);
        else if(empSal >= 200000)
            setEmpSalGrade(4);
    }

    /**
     * @param empSalGrade the empSalGrade to set
     */
    private void setEmpSalGrade(int empSalGrade) {
        this.empSalGrade = empSalGrade;
    }

    @Override
    public String toString(){
        return ("Employee ID: "+empID+"\n"+
                "Employee Dept ID: "+getDeptID()+"\n"+
                "Employee Name: "+empName+"\n"+
                "Employee Salary: "+empSal+"\n"+
                "Employee Salary Grade: "+empSalGrade);
    }

    
    
}
