package com.magang.jcb.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	@Value("${browser}")
	private String browser;
	
	@Value("${locationphoto}")
	private String locationphoto;
	
	public String getLocationphoto() {
		return locationphoto;
	}
	
	@Value("${srcItemWorklist}")
	private String srcItemWorklist;

	public String getSrcItemWorklist() {
		return srcItemWorklist;
	}
	
	@Value("${mid}")
	private String mid;
	
	@Value("${tid}")
	private String tid;
	
	@Value("${chooseoption}")
	private String chooseoption;
	
	@Value("${fillname}")
	private String fillname;
	
	@Value("${filladdress}")
	private String filladdress;
	
	@Value("${fillfloor}")
	private String fillfloor;

	@Value("${fillcategory}")
	private String fillcategory;
	
	@Value("${fillpic}")
	private String fillpic;
	
	@Value("${fillphone}")
	private String fillphone;
	
	@Value("${chooseposition}")
	private String chooseposition;
	
	@Value("${chooseaccp}")
	private String chooseaccp;
	
	@Value("${chooseissue}")
	private String chooseissue;
	
	@Value("${myusername}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Value("${messageLogin}")
	private String messageLogin;
	
	@Value("${m1}")
	private String m1;
	
	@Value("${m2}")
	private String m2;
	
	@Value("${m3}")
	private String m3;
	
	@Value("${m4}")
	private String m4;
	
	@Value("${m5}")
	private String m5;
	
	public String getMid() {
		return mid;
	}

	public String getTid() {
		return tid;
	}

	public String getChooseoption() {
		return chooseoption;
	}

	public String getFillname() {
		return fillname;
	}

	public String getFilladdress() {
		return filladdress;
	}

	public String getFillfloor() {
		return fillfloor;
	}

	public String getFillcategory() {
		return fillcategory;
	}

	public String getFillpic() {
		return fillpic;
	}

	public String getFillphone() {
		return fillphone;
	}

	public String getChooseposition() {
		return chooseposition;
	}

	public String getChooseaccp() {
		return chooseaccp;
	}

	public String getChooseissue() {
		return chooseissue;
	}

	@Value("${nik}")
	private String nik;
	
	@Value("${name}")
	private String name;
	
	@Value("${usernameU}")
	private String usernameU;
	
	@Value("${passwordU}")
	private String passwordU;
	
	@Value("${privilege}")
	private String privilege;
	
	@Value("${kota1}")
	private String kota1;
	
	@Value("${kota2}")
	private String kota2;
	
	@Value("${area1}")
	private String area1;
	
	@Value("${area2}")
	private String area2;
	
	@Value("${startDate}")
	private String startDate;
	
	@Value("${endDate}")
	private String endDate;
	
	@Value("${surveyor}")
	private String surveyor;
	
	@Value("${searchKeyCompleted}")
	private String searchKeyCompleted;
	
	@Value("${messageSurveyor}")
	private String messageSurveyor;
	
	public String getMessageSurveyor() {
		return messageSurveyor;
	}
	
	@Value("${txtLogin}")
	private String txtLogin;
	
	public String getTxtLogin() {
		return txtLogin;
	}
	
	public String getSearchKeyCompleted() {
		return searchKeyCompleted;
	}

	public String getSurveyor() {
		return surveyor;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getBrowser() {
		return browser;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getMessageLogin() {
		return messageLogin;
	}
	
	public String getM1() {
		return m1;
	}
	
	public String getM2() {
		return m2;
	}
	
	public String getM3() {
		return m3;
	}
	
	public String getM4() {
		return m4;
	}
	
	public String getM5() {
		return m5;
	}
	
	public String getNik() {
		return nik;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUsernameU() {
		return usernameU;
	}
	
	public String getPasswordU() {
		return passwordU;
	}
	
	public String getPrivilege() {
		return privilege;
	}
	
	public String getKota1() {
		return kota1;
	}
	
	public String getKota2() {
		return kota2;
	}
	
	public String getArea1() {
		return area1;
	}
	
	public String getArea2() {
		return area2;
	}
	
	@Value("${area}")
	private String area;
	
	@Value("${merchant}")
	private String merchant;
	
	@Value("${visit}")
	private String visit;
	
	@Value("${unvisit}")
	private String unvisit;
	
	@Value("${price}")
	private String price;
	
	@Value("${grand}")
	private String grand;
	
	public String getArea() {
		return area;
	}
	
	public String getMerchant() {
		return merchant;
	}
	
	public String getVisit() {
		return visit;
	}
	
	public String getUnvisit() {
		return unvisit;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getGrand() {
		return grand;
	}
	
	@Value("${search1}")
	private String search1;
	
	@Value("${notesreturn}")
	private String notesreturn;
	
	@Value("${notesreject}")
	private String notesreject;
	
	@Value("${search2}")
	private String search2;
	
	@Value("${search3}")
	private String search3;
	
	@Value("${search4}")
	private String search4;
	
	public String getSearch1() {
		return search1;
	}

	public String getNotesreturn() {
		return notesreturn;
	}

	public String getNotesreject() {
		return notesreject;
	}

	public String getSearch2() {
		return search2;
	}

	public String getSearch3() {
		return search3;
	}

	public String getSearch4() {
		return search4;
	}
}
