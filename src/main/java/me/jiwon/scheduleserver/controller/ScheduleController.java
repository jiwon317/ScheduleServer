package me.jiwon.scheduleserver.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.jiwon.scheduleserver.dto.ScheduleRequestDto;
import me.jiwon.scheduleserver.dto.ScheduleResponseDto;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor

public class ScheduleController {

	@PostMapping("/schedule")
	public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
		return scheduleService.createSchedule(requestDto);
	}

	@GetMapping("/schedule")
	public List<ScheduleResponseDto> getSchedule() {
		return scheduleService.getSchedule();
	}

	@PutMapping("/schedule/{id}")
	public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
		return scheduleService.updateSchedule(id, requestDto);
	}

	@DeleteMapping("/schedule/{id}")
	public Long deleteSchedule(@PathVariable Long id) {
		return scheduleService.deleteSchedule(id);
	}
}
