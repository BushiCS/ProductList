import java.util.*;

public class Main {
    static List<String> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию (введите номер)");
            String input = sc.nextLine();

            if (input.equals("end")) {
                break;
            }
            try {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1 -> {
                        System.out.println("Какую покупку хотите добавить?");
                        input = sc.nextLine();
                        products.add(input);
                        System.out.println("Итого в списке покупок: " + products.size());
                    }
                    case 2 -> listOut();
                    case 3 -> {
                        listOut();
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        input = sc.nextLine();
                        try {
                            int delOperation = Integer.parseInt(input) - 1;
                            System.out.println("Покупка " + products.get(delOperation) + " удалена");
                            products.remove(delOperation);
                        } catch (NumberFormatException e) {
                            if (products.remove(input)) {
                                System.out.println("Покупка " + input + " удалена");
                            } else {
                                System.out.println("Такого продукта нет");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Введите текст для поиска");
                        input = sc.nextLine();
                        for (int i = 0; i < products.size(); i++) {
                            String queryLower = input.toLowerCase();
                            String itemLower = products.get(i).toLowerCase();
                            if (itemLower.contains(queryLower)) {
                                System.out.println((i + 1) + ". " + products.get(i));
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода: введите число");
            }
        }
    }

    public static void listOut() {
        System.out.println("Список покупок: ");
        ListIterator<String> it = products.listIterator();
        while (it.hasNext()) {
            String element = it.next();
            int index = it.nextIndex();
            System.out.println(index + ". " + element);
        }
    }
}

