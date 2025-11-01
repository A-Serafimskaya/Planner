
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TasksTest {

    @Test
    public void shouldFindTheMatchST() {
        SimpleTask simpleTask = new SimpleTask(3, "Проект 21");
        Task task = new Task(3);

        boolean actual = simpleTask.matches("проект");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindTheMatchSTCase() {
        SimpleTask simpleTask = new SimpleTask(3, "Проект 21");
        Task task = new Task(3);

        boolean actual = simpleTask.matches("Проект");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindTheMatchST() {
        SimpleTask simpleTask = new SimpleTask(3, "Проект 21");
        Task task = new Task(3);

        boolean actual = simpleTask.matches("доклад");

        Assertions.assertFalse(actual);
    }


    @Test
    public void shouldFindTheMatchEpic() {
        String[] subtasks = {
                "Подготовить доклад",
                "Провести совещание",
                "Согласовать проект"
        };
        Epic epic = new Epic(3, subtasks);

        Task task = new Task(3);

        boolean actual = epic.matches("доклад");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindTheMatchEpicCase() {
        String[] subtasks = {
                "Подготовить доклад",
                "Провести совещание",
                "Согласовать проект"
        };
        Epic epic = new Epic(3, subtasks);

        Task task = new Task(3);

        boolean actual = epic.matches("Доклад");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindTheMatchEpic() {
        String[] subtasks = {
                "Подготовить доклад",
                "Провести совещание",
                "Согласовать проект"
        };
        Epic epic = new Epic(3, subtasks);

        Task task = new Task(3);

        boolean actual = epic.matches("релиз");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindTheMatchMeeting() {

        Meeting meeting = new Meeting(
                55,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Task task = new Task(55);

        boolean actual = meeting.matches("приложение");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindTheMatchMeetingCase() {

        Meeting meeting = new Meeting(
                55,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Task task = new Task(55);

        boolean actual = meeting.matches("Приложение");

        Assertions.assertTrue(actual);
    }


    @Test
    public void shouldNotFindTheMatchMeeting() {

        Meeting meeting = new Meeting(
                55,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Task task = new Task(55);

        boolean actual = meeting.matches("совещание");

        Assertions.assertFalse(actual);
    }
}
