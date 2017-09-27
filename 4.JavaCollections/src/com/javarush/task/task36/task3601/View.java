package com.javarush.task.task36.task3601;

/**
 * Created by chikishev-93 on 09.09.17.
 */
public class View {
    private Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
