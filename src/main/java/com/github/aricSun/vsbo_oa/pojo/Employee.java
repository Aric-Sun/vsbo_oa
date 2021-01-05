package com.github.aricSun.vsbo_oa.pojo;

/**
 * @author AricSun
 * @date 2021.01.05 11:50
 */
public class Employee {
    private int eId; //员工编牙
    private String password;
    private String ename;
    private String job;
    private int dId; // 部门标号

    public Employee() {
    }

    public Employee(int eId, String password, String ename, String job, int dId) {
        this.eId = eId;
        this.password = password;
        this.ename = ename;
        this.job = job;
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", password='" + password + '\'' +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", dId=" + dId +
                '}';
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }
}
