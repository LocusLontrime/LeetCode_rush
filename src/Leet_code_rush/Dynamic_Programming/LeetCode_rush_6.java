package Leet_code_rush.Dynamic_Programming;

public class LeetCode_rush_6 { /** accepted **/

    static int[] jobDifficulty;
    static int d;
    static int[] max_job_cost_interval;
    static int[][] memo_min_schedule_costs;

    public static void main(String[] args) {

        int [] jobDifficulty = {6, 5, 4, 3, 2, 1, 9, 5, 9, 99, 1, 1, 4, 55, 989, 36, 12, 366, 999, 77, 626, 22, 77, 1001, 1, 98, 111, 123, 45, 54, 98, 1, 1, 7, 2, 3, 98}; //{1,1,1};
        int d = 12;

        long start = System.nanoTime();

        System.out.println(minDifficulty(jobDifficulty, d));

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

        //Q_sort_ints.array_print(jobDifficulty);

    }

    /**
     * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i)
     *
     * @param jobDifficulty - given an integer array jobDifficulty and the difficulty of the ith job is jobDifficulty[i]
     * @param d - an integer d - days quantity
     * @return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1
     */

    public static int minDifficulty(int[] jobDifficulty, int d) {

        if (jobDifficulty.length < d) return -1; // if the days' quantity exceeds the number of jobs then there is no solution

        LeetCode_rush_6.jobDifficulty = jobDifficulty;
        LeetCode_rush_6.d = d;

        max_job_cost_interval = new int[jobDifficulty.length]; // max job difficulty at the interval
        memo_min_schedule_costs = new int[jobDifficulty.length][d + 1];

        memo_fulfilling(); // memo table is being fulfilled with (-1)s

        int max_cost = 0;

        for (int i = LeetCode_rush_6.jobDifficulty.length - 1; i >= 0 ; i--) { // max job difficulty at the interval array fulfilling // it needs to reorganize to one cycle from bottom to up (done)

            if (LeetCode_rush_6.jobDifficulty[i] > max_cost) max_cost = LeetCode_rush_6.jobDifficulty[i];

            max_job_cost_interval[i] =  max_cost;

            //System.out.println("Max_job_cost_interval " + i + " = " + max_job_cost_interval[i]);
        }


        return min_diff_rec(0, 1);
    }

    public static int min_diff_rec (int i, int day) { //recursive algorithm

        //System.out.println("Now loading day " + day);

        if (day == d) {
            //System.out.println("Day = " + day + " max_job_cost_interval = " + max_job_cost_interval[i]);
            return max_job_cost_interval[i]; // if only one day remains we should do all the existing (at the time being) jobs
        }

        int max_job_cost = 0;
        int min_cost = Integer.MAX_VALUE; // for convenience

        if (memo_min_schedule_costs[i][day] == -1) {

            for (int j = i + 1; j <= jobDifficulty.length - (d - day); j++) {

                //System.out.println("i = " + i + " j = " + j);
                max_job_cost = Math.max(max_job_cost, jobDifficulty[j - 1]);

                //System.out.println("Max_job_cost = " + max_job_cost);
                min_cost = Math.min(min_cost, max_job_cost + min_diff_rec(j, day + 1)); // recursive seeker of the minimal difficulty of the schedule

                //System.out.println("Min cost = " + min_cost);

            }

            memo_min_schedule_costs[i][day] = min_cost;

        }

        return memo_min_schedule_costs[i][day]; //memo_min_schedule_costs[i][day];
    }

    public static void memo_fulfilling () {

        for (int i  = 0; i < memo_min_schedule_costs.length; i ++) {
            for (int j = 0; j < memo_min_schedule_costs[0].length; j ++) {
                memo_min_schedule_costs[i][j] = -1;
            }
        }

    }

}
