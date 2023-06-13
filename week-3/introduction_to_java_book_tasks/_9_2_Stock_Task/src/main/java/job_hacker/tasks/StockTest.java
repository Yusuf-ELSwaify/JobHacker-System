package job_hacker.tasks;

import job_hacker.tasks.models.Stock;

public class StockTest {
    public static void main(String[] args) {
        Stock s = new Stock("ORCL", "Oracle Corporation");
        s.setPreviousClosingPrice(34.5);
        s.setCurrentPrice(34.35);
        System.out.printf("Change Percent = %f%%\n", s.getChangePercent());
    }
}