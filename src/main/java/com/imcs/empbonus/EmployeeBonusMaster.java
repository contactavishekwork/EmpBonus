/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.empbonus;

import com.imcs.Objects.Bonus;
import com.imcs.Objects.Employee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avishek
 */
public class EmployeeBonusMaster {
    
    private static ArrayList<Employee> empList = new ArrayList<>(); 
    
    public static void main(String[] args) {
        Employee emp  = new Employee();
        
        try {            
            System.out.println("Enter Employee ID: ");
            int ID = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            System.out.println("Enter Department ID: ");
            int deptID = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            System.out.println("Enter Employee Name: ");
            String empName = new BufferedReader(new InputStreamReader(System.in)).readLine();
            System.out.println("Enter Employee Salary: ");
            double empSal = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());            
            emp.setEmpID(ID);
            emp.setDeptID(deptID);
            emp.setEmpName(empName);
            emp.setEmpSal(empSal);
            empList.add(emp);
            Bonus bns = new Bonus(ID, deptID, empName, empSal);
            bns.calculateBonus(deptID, empSal);
            bns.saveEmployeeData(empList);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeBonusMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
