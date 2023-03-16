import java.util.Scanner;

public class Main {

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static int taxSixSpendings(int earnings) {
        int taxSix = earnings * 6 / 100;
        if (taxSix >= 0) {
            return taxSix;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        while (true){
            System.out.println("Выберите операцию и введите её номер:\n" +
            "1. Добавить новый доход\n" +
            "2. Добавить новый расход\n" +
            "3. Выбрать ситему налогооблажения\n" +
            "end " + "Завершить программу\n");

            String input = scanner.nextLine();
            if(input.equals("end")){
                break;
            }else {
                int operation = Integer.parseInt(input);

                switch (operation){
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        String spendStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                        int spend = Integer.parseInt(spendStr);
                        spendings += spend;
                        break;
                    case 3:
                        int tax = taxEarningsMinusSpendings(earnings, spendings);
                        int taxSix = taxSixSpendings(earnings);
                        if ( taxSix < tax){
                            System.out.println(
                                    "Мы советуем вам УСН доходы\n" +
                                    "Ваш налог составит: " + taxSix + " рублей\n" +
                                    "Налог на другой системе: " + tax + " рублей\n" +
                                    "Экономия: " + (tax - taxSix) + " рублей");
                        }else {
                            System.out.println(
                                    "Мы советуем вам УСН доходы минус расходы\n" +
                                    "Ваш налог составит: " + tax + " рублей\n" +
                                    "Налог на другой системе: " + taxSix + " рублей\n" +
                                    "Экономия: " + (taxSix - tax) + " рублей");
                        }

                        break;
                    default:
                        System.out.println("Такой операции нет");
                }
            }
        }
        System.out.println("Программа завершена!");

    }
}
