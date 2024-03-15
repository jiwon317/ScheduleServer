package me.jiwon.scheduleserver.service;

import me.jiwon.scheduleserver.dto.ScheduleRequestDto;
import me.jiwon.scheduleserver.dto.ScheduleResponseDto;

public interface ScheduleService {

	ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto);

	ScheduleListResponseDto readSchedules();

	ScheduleResponseDto updateSchedule(Long scheduleId, ScheduleRequestDto scheduleRequestDto);

	ScheduleResponseDto DeleteSchedule(Long scheduleId, ScheduleRequestDto scheduleRequestDto);
}