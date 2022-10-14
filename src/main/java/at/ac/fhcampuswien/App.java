package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber() {
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        double maxResult = 0;
        int attemp = 1;
        double input;
        do {
            System.out.print("Number " + attemp + ": ");
            input = scanner.nextDouble();
            if (input > 0) {
                if (input > maxResult) {
                    maxResult = input;
                }
                attemp++;
            } else if (attemp == 1) {
                System.out.println("No number entered.");
            }
        } while (input > 0);
        if (attemp > 1) {
            System.out.println("The largest number is " + String.format("%.2f", maxResult));
        }
        scanner.close();



    }

    //todo Task 2
    public void stairs(){
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int numberOfRows = scanner.nextInt();
        scanner.close();
        if (numberOfRows > 0) {
            int currentNumber = 1;
            for (int currentRow = 1; currentRow <= numberOfRows; ++currentRow) {
                for (int currentColumn = 0; currentColumn < currentRow; ++currentColumn) {
                    System.out.print(currentNumber + " ");
                    currentNumber++;
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid number!");
        }


    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here
        int rows = 6;
        int stars = 1;
        int spaces = rows - 1;
        for(int currentRow=0; currentRow<rows; currentRow++){
            String currentLine = "";
            for(int numberOfSpaces = 0; numberOfSpaces < spaces; numberOfSpaces++){
                currentLine+=" ";
                //System.out.print(" ");
            }
            for(int numberOfStars = 0; numberOfStars < stars; numberOfStars++)
            {
                currentLine+="*";
                //System.out.print("*")
            }
            System.out.println(currentLine);
            //System.out.println()
            spaces -= 1;
            stars += 2;
        }
    }



    //todo Task 4
    public void printRhombus(){
        // input your solution here

        Scanner scanner = new Scanner(System.in);
        System.out.print("h: ");
        int h = scanner.nextInt();
        System.out.print("c: ");
        char c = scanner.next().charAt(0);
        scanner.close();
        if(h % 2 != 0){
            int chars = 0;
            int halfHeight = h / 2 + 1;
            int spaces = halfHeight - 1;
            StringBuilder builder = new StringBuilder();

            for(int currentRow = 1; currentRow <= h; currentRow++)
            {
                String currentLine = "";
                String previousChars = "";
                String nextChars = "";

                for(int currentSpaces = 0; currentSpaces < spaces; currentSpaces++ )
                {
                    currentLine += " ";
                }

                if(currentRow <= halfHeight)
                {
                    //superior triangle
                    for(int currentCharPosition = currentRow-1; currentCharPosition > 0; --currentCharPosition)
                    {
                        previousChars += Character.toString((int)(c - currentCharPosition));
                    }
                    nextChars = builder.append(previousChars).reverse().toString();
                    chars++;
                    if(currentRow < halfHeight)
                    {
                        --spaces;
                    }
                    else if(currentRow == halfHeight)
                    {
                        ++spaces;
                    }
                    builder = new StringBuilder();
                }
                else
                {
                    //inferior triangle
                    for(int currentCharPosition = (h - currentRow); currentCharPosition > 0; --currentCharPosition)
                    {
                        previousChars += Character.toString((int) (c - currentCharPosition));
                    }
                    nextChars = builder.append(previousChars).reverse().toString();
                    chars--;
                    spaces++;
                    builder = new StringBuilder();
                }
                currentLine += previousChars + Character.toString(c) + nextChars;
                System.out.println(currentLine);
            }

        }else
        {
            System.out.println("Invalid number!");
        }
    }

    //todo Task 5
    public void marks(){
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        int attemptCounter = 1;
        int markCounter = 0;
        int currentMark = 1;
        int negativeMarks = 0;
        double sumMarks = 0;
        while (currentMark != 0)
        {
            System.out.print("Mark " + attemptCounter + ": ");
            currentMark = scanner.nextInt();
            if (currentMark > 0 && currentMark <= 5) {
                attemptCounter++;
                markCounter++;
                sumMarks += currentMark;
                if (currentMark == 5) {
                    negativeMarks++;
                }
            } else if(currentMark != 0 ){
                System.out.println("Invalid mark!");
            }
        }

        scanner.close();
        System.out.println("Average: " + String.format("%.2f", (sumMarks / markCounter)));
        System.out.println("Negative marks: " + negativeMarks);

    }

    //todo Task 6
    public void happyNumbers(){
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = scanner.nextInt();
        scanner.close();

        boolean isHappyNumber = false, isSadNumber = false;
        boolean firstFour = false;
        while(!isHappyNumber && !isSadNumber)
        {
            if (n == 1)
                isHappyNumber = true;
            else
            {
                int squaredSum = 0;
                String numberString = String.valueOf(n);
                for(int position = 0; position < numberString.length(); position++)
                {
                    int digit = Integer.parseInt(numberString.substring(position, position + 1));
                    squaredSum += Math.pow(digit, 2);
                }
                if (squaredSum == 4 && !firstFour)
                    firstFour = true;
                else if (squaredSum == 4 && firstFour)
                    isSadNumber = true;
                else {
                    n = squaredSum;
                }
            }
        }
        if (isHappyNumber)
            System.out.println("Happy number!");
        else
            System.out.println("Sad number!");




    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}