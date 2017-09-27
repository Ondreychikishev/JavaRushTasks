package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Scanner;

public interface PersonScanner {
    Scanner read() throws IOException;

    void close() throws IOException;
}
