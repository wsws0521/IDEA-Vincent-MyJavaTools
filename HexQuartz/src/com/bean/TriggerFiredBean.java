package com.bean;

public class TriggerFiredBean {
	private String SCHED_NAME ;
	private String ENTRY_ID;
	private String TRIGGER_NAME ;
    private String TRIGGER_GROUP ;
    private String INSTANCE_NAME;
    private String FIRED_TIME;
    private String SCHED_TIME;
    private int PRIORITY ;    
    private String STATE;
    private String JOB_NAME ;
    private String JOB_GROUP ;
    private String IS_NONCONCURRENT;
    private String REQUESTS_RECOVERY;
    
    

    
    
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
	

	public void setPRIORITY(int PRIORITY) {
		this.PRIORITY = PRIORITY;
	}
	public int getPRIORITY() {
		return PRIORITY;
	}
	public String getENTRY_ID() {
		return ENTRY_ID;
	}
	public void setENTRY_ID(String eNTRY_ID) {
		ENTRY_ID = eNTRY_ID;
	}
	public String getINSTANCE_NAME() {
		return INSTANCE_NAME;
	}
	public void setINSTANCE_NAME(String iNSTANCE_NAME) {
		INSTANCE_NAME = iNSTANCE_NAME;
	}
	public String getFIRED_TIME() {
		return FIRED_TIME;
	}
	public void setFIRED_TIME(String fIRED_TIME) {
		FIRED_TIME = fIRED_TIME;
	}
	public String getSCHED_TIME() {
		return SCHED_TIME;
	}
	public void setSCHED_TIME(String sCHED_TIME) {
		SCHED_TIME = sCHED_TIME;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getIS_NONCONCURRENT() {
		return IS_NONCONCURRENT;
	}
	public void setIS_NONCONCURRENT(String iS_NONCONCURRENT) {
		IS_NONCONCURRENT = iS_NONCONCURRENT;
	}
	public String getREQUESTS_RECOVERY() {
		return REQUESTS_RECOVERY;
	}
	public void setREQUESTS_RECOVERY(String rEQUESTS_RECOVERY) {
		REQUESTS_RECOVERY = rEQUESTS_RECOVERY;
	}
	
}
