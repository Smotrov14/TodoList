import java.util.Scanner;



public class Main {
    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (LIST, ADD, EDIT, DELETE, EXIT):");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toUpperCase();
            String remainingText = parts.length > 1 ? parts[1].trim() : "";

            if (command.equals("EXIT")) {
                break;
            }

            int number = -1;
            if (remainingText.matches("^\\d+.*")) {
                String numberStr = remainingText.replaceAll("^(\\d+).*", "$1");
                number = Integer.parseInt(numberStr);
                remainingText = remainingText.replaceAll("^\\d+\\s*", "").trim();
            }

            switch (command) {
                case "LIST":
                    if (todoList.getTodos().isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        var list = todoList.getTodos();
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(i + " - " + list.get(i));
                        }
                    }
                    break;

                case "ADD":
                    if (number == -1) {
                        todoList.add(remainingText);
                    } else if (number >= 0 ) {
                        todoList.add(number, remainingText);
                    }
                    break;

                case "EDIT":
                    if (number >= 0 && number < todoList.getTodos().size()) {
                        todoList.edit(remainingText, number);
                    } else {
                        System.out.println("Неверный индекс для редактирования задачи.");
                    }
                    break;

                case "DELETE":
                    if (number >= 0 && number < todoList.getTodos().size()) {
                        todoList.delete(number);
                    } else {
                        System.out.println("Неверный индекс для удаления задачи.");
                    }
                    break;

                default:
                    System.out.println("Неизвестная команда: " + command);
            }
        }

    }
}
