public class helper {
    helper(){}

    static public void printTask(Task t, int size) {
        System.out.println("Got it. I've added this task:\n" + t.toString());
        System.out.println("Now you have" + size + "tasks in the list.");
    }
}
