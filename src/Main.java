// My first real Java application
/*
* I am going to make a calculator
* Hopefully this works out lol
*/
import java.util.*;

class Calculations {

    public void addition(int first_entry, int second_entry) {
        System.out.println(first_entry + second_entry);
    }

    public void multiplication(int first_entry, int second_entry) {
        System.out.println(first_entry * second_entry);
    }

    public void division(int first_entry, int second_entry) {
        System.out.println(first_entry / second_entry);
    }

    public void subtraction(int first_entry, int second_entry) {
        System.out.println(first_entry - second_entry);
    }

    public void percentages(int first_entry, int second_entry) {

        // handle if 0
        if (first_entry == 0) {
            System.out.println("Can not divide by 0."); // can not divide by zero.
        } else {
            // convert first_entry to double for percentage
            double percentage = (double) 100 / second_entry;

            // first_entry should be the percentage number
            // Example: 20% of 100
            System.out.println(first_entry * percentage);
        }
    }
} // addition, multiplication, division, subtraction, percentages

class Menu {

    public static List<Integer> prompt() {
        int number_one;
        int number_two;
        Scanner user_input = new Scanner(System.in);
        List<Integer> answers = new ArrayList<>();

        System.out.println("Please provide two numbers. Do not provide math operators. Just the numbers.");
        System.out.println("Please enter your first number.");
        number_one = user_input.nextInt();
        answers.add(number_one);
        System.out.println("Please enter your second number.");
        number_two = user_input.nextInt();
        answers.add(number_two);

        return answers;
    }

    public static void repeat() {
        // user input creation must be an integer
        Scanner user_input = new Scanner(System.in);

        System.out.println("Would you like to solve another problem?");
        String[] yes_or_no = {"1. Yes", "2. No"};
        int i;

        for (i = 0; i < yes_or_no.length; i++) {
            System.out.println(yes_or_no[i]);
        }

        int user_decision = user_input.nextInt();

        switch (user_decision) {
            case 1 -> menu_selection();
            case 2 -> {
                System.out.println("Good bye!");
                System.exit(0);
            }
            default -> {
                System.out.print("Not a valid entry! Try again!");
                Menu.repeat();
            }
        }
    }

    public static void menu_selection() {
        // initialize variables
        int number_one;
        int number_two;
        int i;

        // create a list of choices
        String[] menu_choices = {"1: Addition", "2: Subtraction", "3: Multiplication", "4: Division", "5: Percentages"};
        System.out.print("Please make a decision\n");

        for (i = 0; i < menu_choices.length; i++) {
            System.out.println(menu_choices[i]);
        }

        // user input creation must be an integer
        Scanner user_input = new Scanner(System.in);
        int user_decision = user_input.nextInt();

        switch (user_decision) {
            case 1 -> {
                List<Integer> numbers = prompt();
                number_one = numbers.get(0);
                number_two = numbers.get(1);
                System.out.println("Your addition answer is:");
                new Calculations().addition(number_one, number_two);
                repeat();
            }
            case 2 -> {
                List<Integer> numbers = prompt();
                number_one = numbers.get(0);
                number_two = numbers.get(1);
                System.out.println("Your subtraction answer is:");
                new Calculations().subtraction(number_one, number_two);
                repeat();
            }
            case 3 -> {
                List<Integer> numbers = prompt();
                number_one = numbers.get(0);
                number_two = numbers.get(1);
                System.out.println("Your division answer is:");
                new Calculations().division(number_one, number_two);
                repeat();
            }
            case 4 -> {
                List<Integer> numbers = prompt();
                number_one = numbers.get(0);
                number_two = numbers.get(1);
                System.out.println("Your multiplication answer is:");
                new Calculations().multiplication(number_one, number_two);
                repeat();
            }
            case 5 -> {
                List<Integer> numbers = prompt();
                number_one = numbers.get(0);
                number_two = numbers.get(1);
                System.out.println("Your percentage answer is:");
                new Calculations().percentages(number_one, number_two);
                repeat();
            }
            default -> {
                System.out.println("Not a valid selection.");
                Menu.menu_selection();
            }
        }
    }
}  // prompt, repeat, menu_selection

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello this is my calculator!"); // sout + tab

        Menu.menu_selection();
    }

}