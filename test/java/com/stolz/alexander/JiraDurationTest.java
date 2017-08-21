package sdkjfdsf.sdfjksdf;

import org.junit.Assert;
import org.junit.Test;

public class JiraDurationTest {

	@Test
	public void shouldCalculateCorrectMinutesForMinutesInput() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(0, 0, 0, 56);
		// when
		int result = sut.toMinutes();
		
		// then
		Assert.assertEquals(56, result);
	}
	
	@Test
	public void shouldCalculateCorrectMinutesForHoursInput() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(0, 0, 1, 0);
		// when
		int result = sut.toMinutes();
		
		// then
		Assert.assertEquals(60, result);
	}
	
	@Test
	public void shouldCalculateCorrectMinutesForDaysInput() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(0, 1, 0, 0);
		// when
		int result = sut.toMinutes();
		
		// then
		Assert.assertEquals(8 * 60, result);
	}
	
	@Test
	public void shouldCalculateCorrectMinutesForWeeksInput() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(1, 0, 0, 0);
		// when
		int result = sut.toMinutes();
		
		// then
		Assert.assertEquals(5 * 8 * 60, result);
	}
	
	@Test
	public void shouldCalculateCorrectMinutesForFullInput() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(1, 1, 1, 1);
		// when
		int result = sut.toMinutes();
		
		// then
		Assert.assertEquals(5 * 8 * 60 + 8*60 + 60 + 1, result);
	}

	@Test
	public void shouldAddTwoJiraDurationsCorrectly() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(1, 1, 1, 1);
		final JiraDuration sut2 = new JiraDuration(1, 2, 3, 4);
		
		// when
		JiraDuration result = sut.plus(sut2);
		
		// then
		Assert.assertEquals(2, result.weeks);
		Assert.assertEquals(3, result.days);
		Assert.assertEquals(4, result.hours);
		Assert.assertEquals(5, result.minutes);
	}
	
	@Test
	public void shouldSubstractTwoJiraDurationsCorrectly() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(2, 3, 4, 5);
		final JiraDuration sut2 = new JiraDuration(1, 1, 1, 1);
		
		// when
		JiraDuration result = sut.minus(sut2);
		
		// then
		Assert.assertEquals(1, result.weeks);
		Assert.assertEquals(2, result.days);
		Assert.assertEquals(3, result.hours);
		Assert.assertEquals(4, result.minutes);
	}

	@Test
	public void shouldReturnCorrectStringForWeeks() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(2, 0, 0, 0);
		
		// when
		String result = sut.toString();
		
		// then
		Assert.assertEquals("2w", result);
	}
	
	@Test
	public void shouldReturnCorrectStringForDays() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(0, 3, 0, 0);
		
		// when
		String result = sut.toString();
		
		// then
		Assert.assertEquals("3d", result);
	}
	
	@Test
	public void shouldReturnCorrectStringForHours() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(0, 0, 4, 0);
		
		// when
		String result = sut.toString();
		
		// then
		Assert.assertEquals("4h", result);
	}
	
	@Test
	public void shouldReturnCorrectStringForMinutes() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(0, 0, 0, 5);
		
		// when
		String result = sut.toString();
		
		// then
		Assert.assertEquals("5m", result);
	}
	
	@Test
	public void shouldReturnCorrectStringForFullInput() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(1, 2, 3, 4);
		
		// when
		String result = sut.toString();
		
		// then
		Assert.assertEquals("1w 2d 3h 4m", result);
	}
	
	@Test
	public void shouldReturnCorrectStringForFullInputMissingDays() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(1, 0, 3, 4);
		
		// when
		String result = sut.toString();
		
		// then
		Assert.assertEquals("1w 3h 4m", result);
	}
	
	@Test
	public void shouldReturnCorrectStringForFullInputMissingHours() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(1, 2, 0, 4);
		
		// when
		String result = sut.toString();
		
		// then
		Assert.assertEquals("1w 2d 4m", result);
	}
	
	@Test
	public void shouldReturnCorrectStringForFullInputMissingMinutes() throws Exception {
		// given
		final JiraDuration sut = new JiraDuration(1, 2, 3, 0);
		
		// when
		String result = sut.toString();
		
		// then
		Assert.assertEquals("1w 2d 3h", result);
	}

}
