package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import model.Controller;

public class Main {

    private Controller controller;
    
    private Scanner reader;

    private Box container;

    public Main() {
        this.reader = new Scanner(System.in);
        this.controller = new Controller();
        this.container = new Box();
    }

    public static void main(String[] args) {
        Main main = new Main();

        int option = -1;
        do {

            option = main.getOptionShowMenu();
            main.executeOption(option);

        } while (option != 0);
    }

    public int getOptionShowMenu() {
        int option = 0;
        System.out.println(printMenu());

        option = validateIntegerOption();

        return option;
    }

    public String printMenu() {
        String head = "< --------------------------------------------------------------------- >\n" +
        "< -                               Opciones                            - >\n" +
        "< --------------------------------------------------------------------- >\n";
        String menu = 
                "1. Agregar registro\n" +
                "2. Imprimir arbol\n" + 
                "0. Salir";

        menu = container.box(menu, 26, "|", "-");

        return head + menu;
    }

    public void executeOption(int option) {
        String msg = "";

        switch (option) {
            case 1:
                msg = registryNames();
                System.out.println(msg);
                break;
            case 2:
                msg = printTree();
                System.out.println(msg);
                break;
            case 0:
                System.out.println("Exit program.");
                break;

            default:
                System.out.println("Invalid Option");
                break;
        }

        //wait(500);
        //cleanConsole();
    }

    public String registryNames() {
        String msg = "Hecho!";

        System.out.println("Ingrese los nombres para el arbol binario: ");
        reader.nextLine();
        String names = reader.nextLine();
        String [] namesSplitted = names.split(" ");
        ArrayList<String> namesArr = new ArrayList<>();
        Collections.addAll(namesArr, namesSplitted);
        controller.getBst().addNode(namesArr);
        return msg;
    }

    public String printTree() {
        return controller.getBst().printGraf();
    }
    
    /**
     * This function cleans the console, is just a stetic feature
     */
    private void cleanConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function waits for the time specified in miliseconds
     * 
     * @param miliseconds The miliseconds the program will stop
     */
    private void wait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function validates if the input of the user is an integer
     * returns -1 if the input is incorrect
     * 
     * @return The number the user digits if it is an int
     */
    public int validateIntegerOption() {
        int option = 0;

        if (reader.hasNextInt()) {
            option = reader.nextInt();
        } else {
            reader.nextLine();
            option = -1;
        }

        return option;
    }

    /**
     * This function validates if the input of the user is a double
     * returns -1 if the input is incorrect
     * 
     * @return The number the user digits if it is a double
     */
    public double validateDoubleOption() {
        double option = 0;

        if (reader.hasNextDouble()) {
            option = reader.nextDouble();
        } else {
            reader.nextLine();
            option = -1;
        }

        return option;
    }
}
