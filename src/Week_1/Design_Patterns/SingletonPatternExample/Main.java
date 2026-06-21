package Week_1.Design_Patterns.SingletonPatternExample;

public class Main {
    static void main() {
        Logger logger = Logger.getLogger();
        System.out.println(logger.hashCode());

        Logger logger1 = Logger.getLogger();
        System.out.println(logger1.hashCode());

        System.out.println(logger == logger1);
    }
}
