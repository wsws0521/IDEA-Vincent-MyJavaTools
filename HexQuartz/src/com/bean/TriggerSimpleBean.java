package com.bean;

public class TriggerSimpleBean {
	private String SCHED_NAME;
	private String TRIGGER_NAME;
	private String TRIGGER_GROUP;
	private long REPEAT_COUNT;
	private long REPEAT_INTERVAL;
	private long TIMES_TRIGGERED;
	public String getSCHED_NAME() {
		return SCHED_NAME;
	}
	public void setSCHED_NAME(String sCHED_NAME) {
		SCHED_NAME = sCHED_NAME;
	}
	public String getTRIGGER_NAME() {
		return TRIGGER_NAME;
	}
	public void setTRIGGER_NAME(String tRIGGER_NAME) {
		TRIGGER_NAME = tRIGGER_NAME;
	}
	public String getTRIGGER_GROUP() {
		return TRIGGER_GROUP;
	}
	public void setTRIGGER_GROUP(String tRIGGER_GROUP) {
		TRIGGER_GROUP = tRIGGER_GROUP;
	}
	public long getREPEAT_COUNT() {
		return REPEAT_COUNT;
	}
	public void setREPEAT_COUNT(long rEPEAT_COUNT) {
		REPEAT_COUNT = rEPEAT_COUNT;
	}
	public long getREPEAT_INTERVAL() {
		return REPEAT_INTERVAL;
	}
	public void setREPEAT_INTERVAL(long rEPEAT_INTERVAL) {
		REPEAT_INTERVAL = rEPEAT_INTERVAL;
	}
	public long getTIMES_TRIGGERED() {
		return TIMES_TRIGGERED;
	}
	public void setTIMES_TRIGGERED(long tIMES_TRIGGERED) {
		TIMES_TRIGGERED = tIMES_TRIGGERED;
	}
}
