package ru.reeson2003.simpleobject.generator;

import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by Pavel Gavrilov
 */
public class SimpleObjectGeneratorTest {

    @Test
    public void generateTest() throws FileNotFoundException {
        SimpleObjectGenerator simpleObjectGenerator = SimpleObjectGenerator.builder()
                .className("Объект")
                .valueClassNamePrefix("Свойство")
                .valueClassPropertyNamePrefix("свойство")
                .genericTypePrefix("Тип")
                .build();
        String text = simpleObjectGenerator.generate(25);
        try (PrintWriter out = new PrintWriter("/Users/p.gavrilov/IdeaProjects/simple-object/Объект.java")) {
            out.println(text);
        }
    }
}