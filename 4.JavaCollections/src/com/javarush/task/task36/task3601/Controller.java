package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chikishev-93 on 09.09.17.
 */
public class Controller {
    private Model model = new Model();

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }
}

