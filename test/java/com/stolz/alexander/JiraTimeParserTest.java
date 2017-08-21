package sdkjfdsf.sdfjksdf;

import org.junit.Assert;
import org.junit.Test;


public class JiraTimeParserTest {

	
	@Test
	public void parseShouldReturnNotNull() {
		// given
		JiraTimeParser sut = new JiraTimeParser();
		
		// when
		JiraDuration result = sut.parse("");
		
		// then
		Assert.assertNotNull(result);
	}
	
	@Test
	public void parseShouldWorkForWeeks() {
		// given
		JiraTimeParser sut = new JiraTimeParser();
		
		// when
		JiraDuration result = sut.parse("12w");
		
		// then
		Assert.assertEquals(12, result.weeks);
	}
	
	@Test
	public void parseShouldWorkForDays() {
		// given
		JiraTimeParser sut = new JiraTimeParser();
		
		// when
		JiraDuration result = sut.parse("7d");
		
		// then
		Assert.assertEquals(7, result.days);
	}
	
	@Test
	public void parseShouldWorkForHours() {
		// given
		JiraTimeParser sut = new JiraTimeParser();
		
		// when
		JiraDuration result = sut.parse("7h");
		
		// then
		Assert.assertEquals(7, result.hours);
	}
	
	@Test
	public void parseShouldWorkForMinutes() {
		// given
		JiraTimeParser sut = new JiraTimeParser();
		
		// when
		JiraDuration result = sut.parse("7m");
		
		// then
		Assert.assertEquals(7, result.minutes);
	}
	
	@Test
	public void parseShouldWorkForCompleteInput() {
		// given
		JiraTimeParser sut = new JiraTimeParser();
		
		// when
		JiraDuration result = sut.parse("23w 34d 55h 7m");
		
		// then
		Assert.assertEquals(23, result.weeks);
		Assert.assertEquals(34, result.days);
		Assert.assertEquals(55, result.hours);
		Assert.assertEquals(7, result.minutes);
	}
}
