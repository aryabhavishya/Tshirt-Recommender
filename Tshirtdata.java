package com.naehas.org;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Tshirtdata  
{  
	static String outputpreference;
	static String colour;
	static String gender;
	static String size;
	public static void main(String[] args)   
	{  	
		Scanner sc=new Scanner(System.in);

		String name = null;
		boolean flag = false;
		do
		{
			System.out.println("Enter Colour");
			colour=sc.nextLine().toUpperCase();
			try
			{
				System.out.println("Enter Gender");
				gender=sc.nextLine().toUpperCase();
				System.out.println("Enter Size");
				size=sc.nextLine().toUpperCase();
				System.out.println("Please Enter Your Preference of Sorting \n 1) Rating \n 2) Price \n 3) Both");
				outputpreference=sc.nextLine().toUpperCase();
				if((gender.equals("M") || gender.equals("F") || gender.equals("U"))&&
					(size.equals("S") || size.equals("M") || size.equals("L")  || size.equals("XL") || size.equals("XXL") || size.equals("XXXL"))&&
					(outputpreference.equals("PRICE") || outputpreference.equals("RATING") || outputpreference.equals("BOTH")))
				{
					flag=false;
				}
				else
				{
					flag=true;
					throw new Exception();
				}
			}
			catch(Exception e)
			{
				System.out.println("Please Enter Valid Input!!!");
			}
		}while(flag);

		Tshirt tshirt=new Tshirt();
		tshirt.setColour(colour);
		tshirt.setChoice(outputpreference);
		tshirt.setGender(gender);
		tshirt.setSize(size);

		parseForCsvFiles("C:\\Users\\ASUS\\Downloads\\Stores",tshirt);
	}
	public static void parseForCsvFiles(String parentDirectory,Tshirt tshirt){

		ArrayList<Tshirt> tshirtdetails=new ArrayList<>();
		double price1,rating1;
		String [] storeData=null;
		int i=1;
		File[] filesInDirectory = new File(parentDirectory).listFiles();
		for(File f : filesInDirectory){
			if(f.isDirectory()){
				parseForCsvFiles(f.getAbsolutePath(),tshirt);
			}
			String filePath = f.getAbsolutePath();
			String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
			if("csv".equals(fileExtenstion)){
				try   
				{  
					BufferedReader br = new BufferedReader(new FileReader(f));  
					br.readLine();
					String line="";
					while ((line = br.readLine()) != null) 
					{  
						if(!line.isEmpty())
						{
							storeData = line.split("\\|");
							if(tshirt.getColour().equals(storeData[2].toUpperCase()) && 
									tshirt.getSize().equals(storeData[4].toUpperCase()) && 
									tshirt.getGender().equals(storeData[3].toUpperCase()))
							{
								if(tshirt.getChoice().toUpperCase().equals("PRICE"))
								{
									price1=Double.parseDouble(storeData[5]);
									Tshirt tshirt2=new Tshirt(storeData[1],tshirt.getColour(),tshirt.getSize(),tshirt.getGender(),price1,Double.parseDouble(storeData[6]),storeData[0]);
									tshirtdetails.add(tshirt2);
								}
								else if(tshirt.getChoice().equals("RATING"))
								{
									rating1=Double.parseDouble(storeData[6]);
									Tshirt tshirt2=new Tshirt(storeData[1],tshirt.getColour(),tshirt.getSize(),tshirt.getGender(),Double.parseDouble(storeData[5]),rating1,storeData[0]);
									tshirtdetails.add(tshirt2);
								}
								else if(tshirt.getChoice().equals("BOTH"))
								{
									price1=Double.parseDouble(storeData[5]);
									rating1=Double.parseDouble(storeData[6]);
									Tshirt tshirt2=new Tshirt(storeData[1],tshirt.getColour(),
											tshirt.getSize(),tshirt.getGender(),
											Double.parseDouble(storeData[5]),rating1,storeData[0]);
									tshirtdetails.add(tshirt2);
								}
							}
						}
					}
				}

				catch (IOException e)   
				{  
					e.printStackTrace();  
				} 
			}
		}
		try
		{
			if(tshirtdetails.isEmpty())
			{
				throw new Exception();
			}
			else
			{
				Collections.sort(tshirtdetails,new Sorting());
				System.out.println("Tshirt Found The Details are:- ");
				for(Tshirt t:tshirtdetails)
				{
					System.out.println(i++ +" "+ t);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("No Tshirt Found!!!!");
		}
	}

}
