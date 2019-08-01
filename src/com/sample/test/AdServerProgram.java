package com.sample.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AdServerProgram {
	
	public static void main(String[] args) throws FileNotFoundException {
		String file1 = args[0];
		String file2 = args[1];
		Scanner sc = new Scanner(System.in);
		String siteId = sc.nextLine();
		sc.close();
		AdServerProgram obj = new AdServerProgram();
		System.out.println(obj.findAdServer(file1, file2, siteId));
	}
	
	public String findAdServer(String file1, String file2, String siteId) throws FileNotFoundException {
		String adServerId = "-1";
		String seconPriceAdId = "-1";
		
		File fileP1 = new File(file1);
		Scanner sc1 = new Scanner(fileP1);
		
		while(sc1.hasNextLine()) {
			String line = sc1.nextLine();
			String[] temp = line.split(",");
			if(siteId.equals(temp[0])) {
				File fileP2 = new File(file2);
				Scanner sc2 = new Scanner(fileP2);
				int maxPrice = 0, secondMaxPrice = 0;
				
				while(sc2.hasNextLine()) {
					String advertisment = sc2.nextLine();
					String adTemp[] = advertisment.split(",");
					int priceWillingToPay = Integer.parseInt(adTemp[1]);
					int numOfWebsites = Integer.parseInt(adTemp[1]);
					Set<String> interestedSiteId = new HashSet<>();
					int i = 0;
					while(i < numOfWebsites) {
						interestedSiteId.add(adTemp[i + 2]);
						i++;
					}
					
					if(interestedSiteId.contains(siteId)) {
						if(priceWillingToPay >= Integer.parseInt(temp[1])) {
							if(priceWillingToPay > maxPrice) {
								seconPriceAdId = adServerId;
								secondMaxPrice = maxPrice;
								maxPrice = priceWillingToPay;
								adServerId = adTemp[0];
							}else if(priceWillingToPay > secondMaxPrice) {
								secondMaxPrice = priceWillingToPay;
								seconPriceAdId = adTemp[0];
							}
						}
					}
				}
				sc2.close();
			}
		}
		sc1.close();
		
		if(seconPriceAdId.equals("-1") && !adServerId.equals("-1")) {
			return adServerId;
		}else if(!seconPriceAdId.equals("-1") && !adServerId.equals("-1")) {
			return seconPriceAdId;
		}
		
		return adServerId;
	}

}
