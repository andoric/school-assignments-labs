package cst8284.lab8.generic;

import java.util.Date;
import java.util.Calendar;

public class InterviewSlot implements Comparable<InterviewSlot>{
	Calendar cal = Calendar.getInstance();
	private Date startTime;
	private Integer duration;
	
	public InterviewSlot(Date start, Integer d) {
		startTime = start;
		duration = d;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date s) {
		startTime = s;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer d) {
		duration = d;
	}
	@Override
	public String toString() {
		return ("InterviewSlot Start: "+startTime+" Duration: "+duration);
	}

	@Override
	public int compareTo(InterviewSlot d) {
		if(startTime.before(d.getStartTime())) {
			return -1;
		}
		if(startTime.after(d.getStartTime())) {
			return 1;
		}
		return 0;
	}
	

}
