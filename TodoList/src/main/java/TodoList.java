import java.util.ArrayList;

public class TodoList {

    private final ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
    }

    public void add(int index, String todo) {
        if (index >= 0 && index <= todoList.size()) {
            todoList.add(index, todo);
        } else {
            todoList.add(todo);
        }
    }

    public void edit(String todo, int index) {
        if (index >= 0 && index < todoList.size()) {
            todoList.set(index, todo);
        } else {
            System.out.println("Неверный индекс для редактирования задачи.");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < todoList.size()) {
            todoList.remove(index);
        } else {
            System.out.println("Неверный индекс для удаления задачи.");
        }
    }

    public ArrayList<String> getTodos() {
        return todoList;
    }
}