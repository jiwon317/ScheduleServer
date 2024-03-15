package me.jiwon.scheduleserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

	private String title;

	private String content;
}
