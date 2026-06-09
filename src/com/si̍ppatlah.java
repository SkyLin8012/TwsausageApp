package com;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class si̍ppatlah {
	int sausage;  //香腸數
	int[]Bnumbers = new int[4]; //老闆的骰子數
	int[]Cnumbers = new int[4]; //顧客的骰子數
	int Cnum ; //顧客的點數
	String CnumMsg;  //顧客顯示結果
	int Bnum ; //老闆的點數
	String BnumMsg;  //老闆顯示結果
	String result;  //結果
	
	
	 

	public si̍ppatlah(int sausage) {
		super();
		this.sausage = sausage;
		this.Cnumbers = getNum();		
		this.Cnum = rule(this.Cnumbers);
		this.CnumMsg = ruMsg(this.Cnum);
		/*
        result=("你的點數:"
        		+ Cnumbers[0] +"\t"
         		+ Cnumbers[1] +"\t"
        		+ Cnumbers[2] +"\t"
         		+ Cnumbers[3] +"\n"
         		+ "你的結果:" + this.Cnum 
        		);
        */        
        result+="\n";
        this.Bnumbers = getNum();		
		this.Bnum = rule(this.Bnumbers);
		this.BnumMsg=ruMsg(this.Bnum);
		/*
		result+=("老闆的點數:"
        		+ Bnumbers[0] + "\t"
         		+ Bnumbers[1] +"\t"
        		+ Bnumbers[2] +"\t"
         		+ Bnumbers[3] +"\n"
         		+ "老闆的結果:" + this.Bnum 
        		); 
		result+="\n";
		*/
		if(Cnum>Bnum)
		{
			result=("勝利!!\t 贈送香腸"+sausage+"根");
		}
		else if(Cnum==Bnum)
		{
			result=("平手!!\t 贈送香腸1根!");
		}
		else
		{
			result=("輸了!!\t 香腸數不變!");
		}
		
	}
	//Method	
	
	public int Cnum()
	{
		return this.Cnum;
	}
	public String CnumMsg()
	{
		return this.CnumMsg;
	}
	public int Bnum()
	{
		return this.Bnum;
	}
	public String BnumMsg()
	{
		return this.BnumMsg();
	}
	public int[] Bnumbers()
	{
		return this.Bnumbers;
	}
	public int[] Cnumbers()
	{
		return this.Cnumbers;
	}
	
	public String result()
	{
		return this.result;
	}
	public String show()
	{
		//System.out.println(result);
		return this.result;
		
	}
	public int[] getNum()
	{
		Random rand = new Random();
		int[] num = new int[4];
		for(int i=0; i< num.length; i++)
		{
			num[i] = rand.nextInt(6)+1;
			
		}
		Arrays.sort(num); //陣列排序
		while(num[0]==num[2]||num[1]==num[3]||isAllDifferent(num))
		{
			Arrays.sort(num); //陣列排序
			for(int i=0; i< num.length; i++)
			{
				num[i] = rand.nextInt(6)+1;
				
			}			
		}
		
		return num;
	}
	//取得點數資訊
	public String ruMsg(int num)
	{	
		
		if(num==12)
		{
			return"十八啦";
		}
		else if(num==3)
		{
			return"扁膣";
		}
		else if(num>99)
		{
			
			return "一色"+num/100;
		}
		else
		{
			return num+"點";
		}		
		
	}	
	
	public int rule(int[] numbers) {
		//判斷是否三個相同 直接失敗
		int rulen=0;
		Arrays.sort(numbers); //陣列排序
		//只要三個點相同，四個都不同也失敗(無面)，較重新擲骰
		
		if(numbers[0]==numbers[3])//四個都一樣(一色、豹子)
		{
			rulen = numbers[0]* 100;
		}
		else
		{
			//計算點數
			rulen = Getpoints(numbers);	
		}
		
		
		return rulen;
	}
	public static boolean isAllDifferent(int[] arr)
	{
		boolean t = true;
		for(int i=0; i<arr.length;i++)
		{
		   for(int j=i+1;j<arr.length;j++)
		   {
			   if(arr[i]==arr[j])
			   {
				   t=false;
			   }
		   }
		}
		return t;
	}
	public static int Getpoints(int[] arr)
	{
		int reuslt=0;
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		for(int i=0 ; i<arr.length;i++)
		{
			list.add(arr[i]);			
		}
		//由小到大檢查相鄰的兩個數是否相同
		for(int i=0; i<list.size()-1;i++)
		{
			if(list.get(i).equals(list.get(i+1))) {
				list.remove(i+1);
				list.remove(i);				
				break;
			}
			
		}
		for(int num : list)
		{
			//System.out.println(num);
			reuslt += num;
		}
		return reuslt;//6+6十八啦、1+2扁膣
	}
	
	
	
}
