package me.jiwon.scheduleserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.jiwon.scheduleserver.service.ScheduleServiceImpl;

@ActiveProfiles("test")
public class ControllerTest {

	private MockMvc mvc;

	private Principal mockPrincipal;

	@MockBean
	ScheduleServiceImpl scheduleService;
}
