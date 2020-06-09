package com.bean;

public class TriggerBean {
	private String SCHED_NAME ;
	private String TRIGGER_NAME ;
    private String TRIGGER_GROUP ;
    private String JOB_NAME ;
    private String JOB_GROUP ;
    private String DESCRIPTION ;
    private String NEXT_FIRE_TIME ;
    private String PREV_FIRE_TIME ;
    private int PRIORITY ;
    private String TRIGGER_STATE ;
    private String TRIGGER_TYPE ;
    private String START_TIME;
    private String END_TIME;
    private String CALENDAR_NAME;
    private short MISFIRE_INSTR;
    private String JOB_DATA;
    
    public  String getSCHED_NAME() {
		return SCHED_NAME;
	}
	public void setSCHED_NAME(String SCHED_NAME) {
		this.SCHED_NAME = SCHED_NAME;
	}
	public  String getTRIGGER_NAME() {
		return TRIGGER_NAME;
	}
	public void setTRIGGER_NAME(String TRIGGER_NAME) {
		this.TRIGGER_NAME = TRIGGER_NAME;
	}
	
	public String getTRIGGER_GROUP() {
		return TRIGGER_GROUP;
	}
	public void setTRIGGER_GROUP(String TRIGGER_GROUP) {
		this.TRIGGER_GROUP = TRIGGER_GROUP;
	}
	
	public String getJOB_NAME() {
		return JOB_NAME;
	}
	public void setJOB_NAME(String JOB_NAME) {
		this.JOB_NAME = JOB_NAME;
	}
	public String getJOB_GROUP() {
		return JOB_GROUP;
	}
	public void setJOB_GROUP(String JOB_GROUP) {
		this.JOB_GROUP = JOB_GROUP;
	}	
	
	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setNEXT_FIRE_TIME(String NEXT_FIRE_TIME) {
		this.NEXT_FIRE_TIME = NEXT_FIRE_TIME;
	}
	public String getNEXT_FIRE_TIME() {
		return NEXT_FIRE_TIME;
	}
	public void setPREV_FIRE_TIME(String PREV_FIRE_TIME) {
		this.PREV_FIRE_TIME = PREV_FIRE_TIME;
	}
	public String getPREV_FIRE_TIME() {
		return PREV_FIRE_TIME;
	}
	public void setPRIORITY(int PRIORITY) {
		this.PRIORITY = PRIORITY;
	}
	public int getPRIORITY() {
		return PRIORITY;
	}
	public void setTRIGGER_STATE(String TRIGGER_STATE) {
		this.TRIGGER_STATE = TRIGGER_STATE;
	}
	public String getTRIGGER_STATE() {
		return TRIGGER_STATE;
	}
	public void setTRIGGER_TYPE(String TRIGGER_TYPE) {
		this.TRIGGER_TYPE = TRIGGER_TYPE;
	}
	public String getTRIGGER_TYPE() {
		return TRIGGER_TYPE;
	}
	public void setSTART_TIME(String START_TIME) {
		this.START_TIME = START_TIME;
	}
	public String getSTART_TIME() {
		return START_TIME;
	}
	public void setEND_TIME(String END_TIME) {
		this.END_TIME = END_TIME;
	}
	public String getEND_TIME() {
		return END_TIME;
	}
	public void setCALENDAR_NAME(String CALENDAR_NAME) {
		this.CALENDAR_NAME = CALENDAR_NAME;
	}
	public String getCALENDAR_NAME() {
		return CALENDAR_NAME;
	}
	public void setMISFIRE_INSTR(short MISFIRE_INSTR) {
		this.MISFIRE_INSTR = MISFIRE_INSTR;
	}
	public short getMISFIRE_INSTR() {
		return MISFIRE_INSTR;
	}
	public void setJOB_DATA(String JOB_DATA) {
		this.JOB_DATA = JOB_DATA;
	}
	public String getJOB_DATA() {
		return JOB_DATA;
	}
}
