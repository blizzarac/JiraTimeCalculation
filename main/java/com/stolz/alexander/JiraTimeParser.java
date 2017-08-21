package sdkjfdsf.sdfjksdf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JiraTimeParser {
	public JiraDuration parse(String jiraTime) {
		final Pattern p = Pattern.compile("(?<weeks>\\d+w)*\\s*(?<days>\\d+d)*\\s*(?<hours>\\d+h)*\\s*(?<minutes>\\d+m)*");
		final Matcher m = p.matcher(jiraTime);
		
		int weeks = 0;
		int days = 0;
		int hours = 0;
		int minutes = 0;
		if (m.matches()) {
			final String weeksStr = m.group("weeks");
			if (weeksStr != null) {
				weeks = Integer.parseInt(weeksStr.substring(0, weeksStr.length()-1));
			}
			
			final String daysStr = m.group("days");
			if (daysStr != null) {
				days = Integer.parseInt(daysStr.substring(0, daysStr.length()-1));
			}
			
			final String hoursStr = m.group("hours");
			if (hoursStr != null) {
				hours = Integer.parseInt(hoursStr.substring(0, hoursStr.length()-1));
			}
			
			final String minutesStr = m.group("minutes");
			if (minutesStr != null) {
				minutes = Integer.parseInt(minutesStr.substring(0, minutesStr.length()-1));
			}
		}
		
		return new JiraDuration(weeks, days, hours, minutes);
	}
}
