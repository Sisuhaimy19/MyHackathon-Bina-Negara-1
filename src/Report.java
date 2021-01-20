
public class Report {
	private String IDNumber;
	private String ReportType;
	private String Location;
	private String Description;
	private String Status;
	
	public Report(String idNumber, String reportType, String location, String description, String status) {
		IDNumber = idNumber;
		ReportType = reportType;
		Location = location;
		Description = description;
		Status = status;
		
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getReportType() {
		return ReportType;
	}

	public void setReportType(String reportType) {
		ReportType = reportType;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
