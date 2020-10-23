package be.vdab.oreilly;

public class Calculator {

    private Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = database.getData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

}
