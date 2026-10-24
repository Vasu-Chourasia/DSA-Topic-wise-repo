class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        String start = arriveAlice.compareTo(arriveBob) > 0
                       ? arriveAlice : arriveBob;

        String end = leaveAlice.compareTo(leaveBob) < 0
                     ? leaveAlice : leaveBob;

        if (start.compareTo(end) > 0) {
            return 0;
        }

        int startDay = Integer.parseInt(start.substring(0, 2)) * 100
                     + Integer.parseInt(start.substring(3));

        int endDay = Integer.parseInt(end.substring(0, 2)) * 100
                   + Integer.parseInt(end.substring(3));

        int[] daysInMonth = {31, 28, 31, 30, 31, 30,
                             31, 31, 30, 31, 30, 31};

        int startMonth = startDay / 100;
        int startDate = startDay % 100;
        int endMonth = endDay / 100;
        int endDate = endDay % 100;

        int startTotal = startDate;
        for (int i = 0; i < startMonth - 1; i++) {
            startTotal += daysInMonth[i];
        }

        int endTotal = endDate;
        for (int i = 0; i < endMonth - 1; i++) {
            endTotal += daysInMonth[i];
        }

        return endTotal - startTotal + 1;
    }
}