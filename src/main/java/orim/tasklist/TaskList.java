package orim.tasklist;

import orim.task.Task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int size() { // returns number of tasks
        return tasks.size();
    }

    public Task get(int index) { // returns ith task
        return tasks.get(index);
    }

    public void add(Task task) { // adds new task to the list
        tasks.add(task);
    }

    public Task delete(int index) { // deletes ith task
        Task temp = tasks.get(index);
        tasks.remove(index);
        return temp;
    }

}
