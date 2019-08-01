package com.trn.googling.ood.designpattern.observer.model;

public class Employee {

    private int id;
    private String name;
    private double Salary;
    private String department;

    private static int counter;

    public Employee(String name, double salary, String department) {
        this.name = name;
        Salary = salary;
        this.department = department;

        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Salary=" + Salary +
                ", department='" + department + '\'' +
                '}';
    }
}
