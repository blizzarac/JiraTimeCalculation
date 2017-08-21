# JiraTimeCalculation

## Parsing Jira time format
JiraTimeParser parser = new JiraTimeParser();
JiraDuration result = parser.parse("12w 23d 34h 45m");

result.weeks // 12
result.days // 23
result.hours // 34
result.minutes // 45

## Adding and substracting Time
JiraDuration duration1 = new JiraDuration(1, 2, 3, 4);
JiraDuration duration2 = new JiraDuration(5, 6, 7, 8);

JiraDuration result1 = duration1.plus(duration2);
result1.weeks // 6
result1.days // 8
result1.hours // 10
result1.minutes // 12

JiraDuration result2 = duration2.minus(duration1);
result.weeks // 4
result.days // 4
result.hours // 4
result.minutes // 4
