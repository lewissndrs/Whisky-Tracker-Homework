package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskyByDistilleryAndAge() {
		List<Whisky> result = whiskyRepository.findWhiskysByDistilleryNameAndAge("Highland Park",12);
		assertEquals(1,result.size());
	}

	@Test
	public void findAllWhiskiesForARegion(){
		List<Whisky> result = whiskyRepository.findWhiskysByDistilleryRegion("Speyside");
		assertEquals(3,result.size());
	}

	@Test
	public void findAllDistilleriesWith20YearWhisky(){
		List<Distillery> result = distilleryRepository.findDistilleryByWhiskiesAge(18);
		assertEquals(2,result.size());
	}

}
