
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] days = {31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        int a = convert(arriveAlice, days);
        int b = convert(leaveAlice, days);
        int c = convert(arriveBob, days);
        int d = convert(leaveBob, days);

        int start = Math.max(a, c);
        int end = Math.min(b, d);

        return Math.max(0, end - start + 1);
    }

    int convert(String date, int[] days) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }

        return day;
    }
}
