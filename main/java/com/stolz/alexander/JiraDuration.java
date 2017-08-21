package sdkjfdsf.sdfjksdf;

public class JiraDuration {
	public final int weeks;
	public final int days;
	public final int hours;
	public final int minutes;
	
	public JiraDuration(int weeks, int days, int hours, int minutes) {
		this.weeks = weeks;
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public int toMinutes() {
		return minutes + hours*60 + days*8*60 + weeks*5*8*60;
	}
	
	public JiraDuration plus(JiraDuration other) {
		return new JiraDuration(
				this.weeks + other.weeks, 
				this.days + other.days, 
				this.hours + other.hours, 
				this.minutes + other.minutes);
	}
	
	public JiraDuration minus(JiraDuration other) {
		return new JiraDuration(
				this.weeks - other.weeks, 
				this.days - other.days, 
				this.hours - other.hours, 
				this.minutes - other.minutes);
	}
	
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		boolean first = true;
		
		if (weeks != 0) {
			builder.append(weeks + "w");
			first = false;
		}
		
		if (days != 0) {
			if(!first) builder.append(" ");
			builder.append(days + "d");
		}
		
		if (hours != 0) {
			if(!first) builder.append(" ");
			builder.append(hours + "h");
		}
		
		if (minutes != 0) {
			if(!first) builder.append(" ");
			builder.append(minutes + "m");
		}
		
		return builder.toString();
	}
}
