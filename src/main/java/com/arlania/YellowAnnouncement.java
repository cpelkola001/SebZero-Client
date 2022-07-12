package com.arlania;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class YellowAnnouncement {

	private int time;

	private final Client instance = Client.instance;

	private List<String> text = new ArrayList<>();

	public YellowAnnouncement(List<String> text, int time) {
		this.text = text;
		this.time = time;
	}

	private int length = instance.builtTextList.size() - 1;

	private final int size = 329 - length * 15;

	ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

	public void process() {

		for (int i = 0; i < text.size(); i++) {
			instance.drawingArea.method385(0xffff00, text.get(i), (size + (15 * i)), 4);
		}

		scheduler.schedule(() -> {
			instance.yellowEnded = true;
			instance.yellowStarted = false;
			instance.yellowHasFinished = true;
			scheduler.shutdownNow();
		}, time, TimeUnit.SECONDS);
	}

}
