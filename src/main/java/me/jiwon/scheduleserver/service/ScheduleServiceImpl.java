package me.jiwon.scheduleserver.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import me.jiwon.scheduleserver.dto.ScheduleRequestDto;
import me.jiwon.scheduleserver.dto.ScheduleResponseDto;
import me.jiwon.scheduleserver.entity.Schedule;
import me.jiwon.scheduleserver.repository.ScheduleRepository;

public class ScheduleServiceImpl implements ScheduleService {
	//    @Autowired
	private final ScheduleRepository scheduleRepository;

	//    @Autowired (메서드 주입방법)
	//    public void setDi(MemoRepository memoRepository) {
	//        this.memoRepository = memoRepository;
	//    }

	@Transactional
	public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {
		// 해당 메모가 DB에 존재하는지 확인
		Schedule schedule = findSchedule(id);
		// memo 내용 수정
		schedule.update(requestDto);

		return id;
	}

	public Long deleteSchedule(Long id) {
		// 해당 스케줄이 DB에 존재하는지 확인
		Schedule schedule = findSchedule(id);

		// schedule 삭제
		scheduleRepository.delete(schedule);

		return id;
	}

	public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
		// RequestDto -> Entity
		Schedule schedule = new Schedule(requestDto);

		// DB 저장
		Schedule saveSchedule = scheduleRepository.save(schedule);

		// Entity -> ResponseDto
		ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

		return scheduleResponseDto;
	}

	public List<ScheduleResponseDto> getSchedule() {
		// DB 조회
		return scheduleRepository.findAllByOrderByModifiedAtDesc().stream().map(ScheduleResponseDto::new).toList();
	}

	public ScheduleResponseDto getScheduleByKeyword(Long id) {
		Schedule schedule = scheduleRepository.findById(id).orElseThrow(); //람다
		return new ScheduleResponseDto(schedule);
	}

	private Schedule findSchedule(Long id) {
		return scheduleRepository.findById(id).orElseThrow(() ->
			new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
		);
	}
}
