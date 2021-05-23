package app.server;

public class Test {

    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Test test = new Test();

        Double value1 = new Double(45d);
        test.setValue(value1);

        Double value2 = new Double(30d);
        Double value3 = value1 + value2;
        test.setValue(value3);

        System.out.println(test.getValue());
    }
}
