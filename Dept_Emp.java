package com.company;

class Dept{
    private int deptno ;
    private String dname ;
    private String loc ;
    private Emp emps[] ;
    public void setEmps(Emp[] emps){
        this.emps = emps ;
    }
    public Emp[] getEmps(){
        return this.emps ;
    }
    public Dept(int deptno,String dname,String loc){
        this.deptno = deptno ;
        this.dname = dname ;
        this.loc = loc ;
    }
    public String getInfo(){
        return "部门编号:" + this.deptno + ",名称:" + this.dname + ",位置:" + this.loc ;
    }
}
class Emp{
    private int empno ;
    private String ename ;
    private String job ;
    private double sal ;
    private double comm ;
    private Dept dept ;
    private Emp mgr ;
    public void setMgr(Emp mgr){
        this.mgr = mgr ;
    }
    public  Emp getMgr(){
        return this.mgr ;
    }
    public void setDept(Dept dept){
        this.dept = dept ;
    }
    public Dept getDept(){
        return this.dept ;
    }
    public Emp(int empno,String ename,String job,double sal,double comm){
        this.empno = empno ;
        this.ename = ename ;
        this.job = job ;
        this.sal = sal ;
        this.comm = comm ;
    }
    public String getInfo(){
        return "雇员编号:" + this.empno + ",姓名:" + this.ename + ",职位:" + this.job + ",工资:" + this.sal + ",佣金:" + this.comm ;
    }
}
public class Dept_Emp{
    public static void main(String[] args) {
    //第一步：设置数据
        //1.产生各自的独立对象
        Dept dept = new Dept(10,"Accounting","New York");
        Emp ea = new Emp(1,"a","a1",400,100);
        Emp eb = new Emp(2,"b","b1",500,100);
        Emp ec = new Emp(3,"c","c1",600,100);
        //2.设置雇员和领导关系
        ea.setMgr(eb);
        eb.setMgr(ec);
        //3.设置雇员和部门关系
        ea.setDept(dept);
        eb.setDept(dept);
        ec.setDept(dept);
        dept.setEmps(new Emp[]{ea,eb,ec}) ;
        //第二步：取出信息
        //1.通过雇员找到领导信息
        System.out.println(ea.getInfo());
        System.out.println(ea.getMgr().getInfo());
        //2.根据部门找到所有的雇员及每个雇员的领导
        System.out.println("-------------------");
        System.out.println(dept.getInfo());
        for (int i = 0; i < dept.getEmps().length; i++) {
            System.out.println(dept.getEmps()[i].getInfo());
            if(dept.getEmps()[i].getMgr() != null){
                System.out.println("\t" +dept.getEmps()[i].getMgr().getInfo());
            }
        }

    }
}