package com.company;

class Province{
    private int pid ;
    private String pname;
    private City cities[] ;
    public Province(int pid,String pname){
        this.pid = pid ;
        this.pname = pname ;
    }
    public void setCities(City cities[]){
        this.cities = cities ;
    }
    public City[] getCities(){
        return this.cities ;
    }
    public String getInfo(){
        return "省份编号：" + this.pid + "名称：" + this.pname ;
    }
}
class City{
    private int cid ;
    private String cname;
    private Province province;
    public void setProvince(Province province){
        this.province = province ;
    }

    public Province getProvince() {
         return this.province ;
    }

    public City(int cid, String cname){
        this.cid = cid ;
        this.cname = cname ;
    }
    public String getInfo(){
        return "城市编号：" + this.cid + "名称：" + this.cname ;
    }
}
public class TestPC {
    public static void main(String[] args) {
        Province p = new Province(1,"江西");
        City c1 = new City(1,"南昌");
        City c2 = new City(2,"九江");
        City c3 = new City(3,"赣州");
        c1.setProvince(p);
        c2.setProvince(p);
        c3.setProvince(p);
        p.setCities(new City[] {c1,c2,c3}) ;
        System.out.println(p.getInfo());
        for (int i = 0; i < p.getCities().length; i++) {
            System.out.println(p.getCities()[i].getInfo());
        }
    }
}
