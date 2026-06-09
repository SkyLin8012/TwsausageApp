package com;

import java.util.Date;

public class twsausage {
	//field
	private String name;
	private int sausage;
	private int rice_sausage;
	private int tw_hotdog;
	private int tw_oden;
	private int drink;
	private int sum;
	private String winmsg;
	private String time;
	double discount;
	//Constructors
	public twsausage(String name, String sausage, String rice_sausage, String tw_hotdog, String tw_oden, String drink,String winmsg,String time,double discount)
	{
		super();
		this.name = name;
		this.winmsg =winmsg;
		this.time=time;
		this.sausage = isNullOrNotInterger(sausage)?0:Integer.parseInt(sausage);
		this.rice_sausage =isNullOrNotInterger(rice_sausage)?0:Integer.parseInt(rice_sausage);
		this.tw_hotdog = isNullOrNotInterger(tw_hotdog)?0:Integer.parseInt(tw_hotdog);
		this.tw_oden = isNullOrNotInterger(tw_oden)?0:Integer.parseInt(tw_oden);
		this.drink = isNullOrNotInterger(drink)?0:Integer.parseInt(drink);
		this.discount =discount;
		this.sum =(int)Math.round ((this.sausage * 45+
				   this.rice_sausage * 40+
				   this.tw_hotdog * 75+
				   this.tw_oden * 30+
				   this.drink * 25 )* discount);
		
	}
	public twsausage(String name, int sausage, int rice_sausage, int tw_hotdog, int tw_oden, int drink) {
		super();
		this.name = name;
		this.sausage = sausage;
		this.rice_sausage = rice_sausage;
		this.tw_hotdog = tw_hotdog;
		this.tw_oden = tw_oden;
		this.drink = drink;
		this.sum = sausage * 45+
				   rice_sausage * 40+
				   tw_hotdog * 75+
				   tw_oden * 30+
				   drink * 25;
	}
	public twsausage() {};
	//methods	
	//判斷是否為數字
	public static boolean isNullOrNotInterger(String str)
	{
		if(str==null || str.trim().isEmpty()||str.contains("-"))
		{
			return true;
		}
		try {
			Integer.parseInt(str);
			return false;
		}
		catch(NumberFormatException e) {
			return true;
		}
	}
	public String addnum(String Num)
	{
		int num = isNullOrNotInterger(Num)?1:Integer.parseInt(Num)+1;
		
		return Integer.toString(num);
	}
	public String decnum(String Num)
	{
		int num = isNullOrNotInterger(Num)?0:Integer.parseInt(Num)-1;
		if(num<0) num=0;
		
		return Integer.toString(num);
	}
	
	public String menu()
	{
		String txt =
				  "********炭烤香腸********\n"
				+ "顧客姓名: " + name +"\n";		
				if(this.sausage!=0)	txt	+=( "古早味烤腸 $45: " + sausage +" 根\n");
				if(this.rice_sausage!=0)txt	+=( "花生糯米腸 $40: " + rice_sausage+" 根\n");
				if(this.tw_hotdog!=0)txt	+=( "大腸包小腸 $75: " + tw_hotdog+" 份\n");
				if(this.tw_oden!=0)txt	+=( "綜合甜不辣 $30: " + tw_oden+" 份\n");
				if(this.drink!=0)txt	+=( "飲料 $25: " + drink+" 杯\n");
				if(discount==0.9) {txt	+=( "熟客打 9 折\n");}
				else if(discount==0.8) {txt	+=( "優惠卷打 8 折\n");}
				else if(discount==0.7) {txt	+=( "VIP卡打 7 折\n");}
				txt+= "----------------------\n"
				+ "總價: "+ sum + " 元"
				;
				if(winmsg != null && !winmsg.trim().isEmpty())txt += "\n"+winmsg;
				txt += time;
		
		return txt;
	}
	public String getName() {
		return name;
	}
	public int getSausage() {
		return sausage;
	}
	public void setSausage(int sausage) {
		this.sausage = sausage;
	}
	public int getRice_sausage() {
		return rice_sausage;
	}
	public void setRice_sausage(int rice_sausage) {
		this.rice_sausage = rice_sausage;
	}
	public int getTw_hotdog() {
		return tw_hotdog;
	}
	public void setTw_hotdog(int tw_hotdog) {
		this.tw_hotdog = tw_hotdog;
	}
	public int getTw_oden() {
		return tw_oden;
	}
	public void setTw_oden(int tw_oden) {
		this.tw_oden = tw_oden;
	}
	public int getDrink() {
		return drink;
	}
	public void setDrink(int drink) {
		this.drink = drink;
	}
	
	
	
}
