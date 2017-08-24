/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.Objects;

import com.imcs.DBConnection.ConnectionMaster;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Avishek
 */
public class Bonus extends Employee{
    
    private double bonus;    
    private int[] bonusRate = {10, 20, 30, 40};
    
    {
        bonus = 1.0;
    }

    public Bonus(int empID, int deptID, String empName, double empSal) {
        super(empID, deptID, empName, empSal);        
        this.bonus = bonus;
    }

    public Bonus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void calculateBonus(int salGrade, double salary){
        if(salGrade == 1)
            setBonus((bonusRate[salGrade]*salary)/100);
        else if(salGrade ==2)
            setBonus((bonusRate[salGrade]*salary)/100);
        else if(salGrade == 3)
            setBonus((bonusRate[salGrade]*salary)/100);
        else if(salGrade == 4)
            setBonus((bonusRate[salGrade]*salary)/100);
    }
    
    public void displayOutput(){
        System.out.println("Employee "+getEmpName()+" was assigned a bonus of "+getBonus()+" in the category "+getEmpSalGrade());
    }
    
    @Override
    public String toString(){
        return ("Employee Name: "+getEmpName()+"\n"+
                "Employee ID: "+getEmpID()+"\n"+
                "Department ID: "+getDeptID()+"\n"+
                "Salary: "+getEmpSal()+"\n"+
                "Salary Grade: "+getEmpSalGrade()+"\n"+
                "Bonus Offered: "+getBonus());
    }

    public void saveEmployeeData(ArrayList<Employee> empList) {
        Connection con = new ConnectionMaster().getDbCon();
        String query = "INSERT INTO `employee_project`.`employee` (`empno`, `deptno`, `salary`, `salgrade`) VALUES (?, ?, ?, ?);";
        Iterator<Employee> iterate = empList.iterator();
        try{
        while(iterate.hasNext()){
            Employee tep = iterate.next();
            PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
            ps.setInt(1, tep.getEmpID());
            ps.setInt(2, tep.getDeptID());
            ps.setDouble(3, tep.getEmpSal());
            ps.setInt(4, tep.getEmpSalGrade());
            
            boolean success = ps.execute();
            if(success){
                System.out.println("Employee "+tep.getEmpID()+" data saved!!");
            }else{
                System.out.println("Error in saving data for Employee: "+tep.getEmpID());
            }
        }
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
}
