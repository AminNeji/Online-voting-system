package ovs;
import java.time.LocalDate;
import java.util.*;
public class election {
	private String name,location;
	private Date start_date;
	private Date end_date;
	private int ele_id;
	
	public election(int elec_id,String name, String location, Date start_date, Date end_date) {
		super();
		this.name = name;
		this.location = location;
		this.start_date = start_date;
		this.end_date = end_date;
		this.ele_id=elec_id;
	}
	
	public int getEle_id() {
		return ele_id;
	}

	public void setEle_id(int ele_id) {
		this.ele_id = ele_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

}
