
public class Reporter {
	private String Name;
	private String ICNumber;
	private String PhoneNumber;
	private String Email;
	private Report reportInfo;
	
	public Reporter(String name, String iCNumber, String phoneNumber, String email, Report r) {
		Name = name;
		ICNumber = iCNumber;
		PhoneNumber = phoneNumber;
		Email = email;
		reportInfo = r;
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getICNumber() {
		return ICNumber;
	}

	public void setICNumber(String iCNumber) {
		ICNumber = iCNumber;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Report getReportInfo() {
		return reportInfo;
	}

	public void setReportInfo(Report reportInfo) {
		this.reportInfo = reportInfo;
	}

}