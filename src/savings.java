// Hercy wants to save money for his first car.
// He puts money in the Leetcode bank every day.

// He starts by putting in $1 on Monday, the first day. 
// Every day from Tuesday to Sunday, he will put in $1 more than the day before. 
// On every subsequent Monday, he will put in $1 more than the previous Monday.
// Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

public class savings {
    static int totalAmount(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Give a minimum number of days!!");

        int k = n / 7;
        int res = (k * (2 * 28 + (k - 1) * 7)) / 2;

        for (int i = 0; i < n % 7; i++) {
            res += (k + 1) + i;
        }
        return res;
    }

}
