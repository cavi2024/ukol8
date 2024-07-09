package cz.engeto.cavi.ukol8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


@RestController
public class MainArticlesController {

    private String importFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()); {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            return "Chyba při čtení souboru.";
        }
        return content.toString().trim();
    }

    @GetMapping("/scifi")
    public String getScifi() {
        return importFromFile("src/main/resources/scifi.txt");
    }

    @GetMapping("/romatic")
    public String getRomatic() {
        return importFromFile("src/main/resources/romatic.txt");
    }

    @GetMapping("/historic")
    public String getHistoric() {
        return importFromFile("src/main/resources/historic.txt");
    }
}

