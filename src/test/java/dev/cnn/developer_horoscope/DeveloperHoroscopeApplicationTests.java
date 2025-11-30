package dev.cnn.developer_horoscope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeveloperHoroscopeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getFortuneTesting_shouldReturnGoodDay() throws Exception {

		mockMvc.perform(get("/fortune/testing"))
				.andExpect(status().isOk())
				.andExpect(content().string("Today is a good day"));
	}

}
