package me.jiwon.scheduleserver.dto;

import lombok.Getter;
import me.jiwon.scheduleserver.entity.Schedule;

@Getter

public class ScheduleResponseDto {

	private String title;
	private String content;
	private String username;

	public ScheduleResponseDto(Schedule schedule, String username) {
		this.title = schedule.getTitle();
		this.content = schedule.getContent();
		this.username = username;

	}
}

