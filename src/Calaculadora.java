import java.util.Scanner;

public class Calaculadora {


    public static void startCalculato(){
        boolean turnOn = true;
        System.out.println("*************** Aplicacion Calculadora ***************");
        listAvailableOperations();
        while (turnOn) {
            listAvailableOperations(); // Listar operaciones disponibles
            int operationSelection = operationInput(); // Llamada a operationInput()
            operationSelector(operationSelection);

            System.out.println("Desea continuar con más operaciones? (si/no):");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            turnOn = validateAnswer(answer);
            if (!turnOn) {
                System.out.println("Saliendo de la calculadora...");
            }
        }

    }

    private static void operationSelector(int operationSelection) {
        System.out.println("Por favor ingrese el primer operador:");
        double firstOperator = getOperator();
        System.out.println("Por favor ingrese el segundo operador:");
        double secondOperator = getOperator();
        double result = performOperation(operationSelection, firstOperator, secondOperator);
        System.out.println("El resultado de la operacion es: " + result);
    }

    private static int operationInput(){

        int operationSelection = 0;
        Scanner scanner = new Scanner(System.in);

        while (operationSelection > 4 || operationSelection <= 0) {
            System.out.println("Ingrese la operacion deseada a realizar. \n");
            operationSelection = scanner.nextInt();
        }

        return operationSelection;
    }

    private static double getOperator(){
        Scanner scanner = new Scanner(System.in);
        double operator = scanner.nextDouble();
        return operator;
    }

    private static double performOperation(int operation, double firstNumber, double secondNumber){
        double result =  0;
        switch (operation){
            case 1:
                System.out.println("Realizando suma.... \n");
                result = performAddition(firstNumber,secondNumber);
                break;
            case 2:
                System.out.println("Realizando resta.... \n");
                result = performSubstraction(firstNumber,secondNumber);
                break;
            case 3:
                System.out.println("Realizando multiplicacion.... \n");
                result = performMultiplication(firstNumber,secondNumber);
                break;
            case 4:
                System.out.println("Realizando division.... \n");
                result = performDivision(firstNumber,secondNumber);
                break;
    }
    return result;
    }


    private static double performAddition(double firstNmuber, double secondNumber){
         double result = firstNmuber + secondNumber;
        return result;

    }

    private static double performSubstraction(double firstNmuber, double secondNumber){
        double result = 0;
        if(firstNmuber > secondNumber){
             result = firstNmuber - secondNumber;
        }else{
            result = firstNmuber + secondNumber;
        }
        return result;
    }

    private static double performMultiplication(double firstNmuber, double secondNumber){
        double result = firstNmuber * secondNumber;
        return result;
    }

    private static double performDivision(double firstNmuber, double secondNumber){
        double result = firstNmuber / secondNumber;
        return result;
    }

    private static boolean validateAnswer(String answer){
        answer = answer.toLowerCase();
        return answer.equals("si") || answer.equals("s") || answer.equals("yes") || answer.equals("y");
    }

    private static void listAvailableOperations(){
        System.out.println("Operaciones disponibles:  \n");
        System.out.println(" 1. Suma. \n");
        System.out.println(" 2. Resta. \n");
        System.out.println(" 3. Multiplicacion. \n");
        System.out.println(" 4. Division. \n");

    }



}
