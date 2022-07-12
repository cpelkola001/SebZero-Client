package com.arlania;

public class ClientStopWatch {

	private long time = System.currentTimeMillis();

	public ClientStopWatch headStart(long startAt) {
		time = System.currentTimeMillis() - startAt;
		return this;
	}

	public ClientStopWatch reset(long i) {
		time = i;
		return this;
	}

	public ClientStopWatch reset() {
		time = System.currentTimeMillis();
		return this;
	}

	public long elapsed() {
		return System.currentTimeMillis() - time;
	}

	public boolean elapsed(long time) {
		return elapsed() >= time;
	}
	
	public long getTime() {
		return time;
	}
	
	public ClientStopWatch() {
		time = 0;
	}
}