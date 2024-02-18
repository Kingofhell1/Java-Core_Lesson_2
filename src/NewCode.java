import java.util.Random;
import java.util.Scanner;

public class NewCode {

    // Фишка игрока - человек.
    private static final char DOT_HUMAN = 'X';
    // Фишка игрока - компьютер.
    private static final char DOT_AI = '0';
    // Признак пустого поля.
    private static final char DOT_EMPTY = '*';
    // Инициализация сканера.
    private static final Scanner scanner = new Scanner(System.in);
    // Генератор случайных чисел.
    private static final Random random = new Random();
    // Двумерный массив, хранящий теущее состояние игрового поля.
    private static char[][] field;
    // Размерность игрового поля
    private static int fieldSizeX;
    // Размерность игрового поля.
    private static int fieldSizeY;

    // Выигрышная комбинация
    private static final int WIN_COUNT = 4;

    /**
     * Инициализация объектов игры
     */
    static void initialize(){
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++){
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn(){
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до 5) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn(){
        int x;
        int y;
        do{
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Поверка на ничью (все ячейки игрового поля заполнены фишками человека или компьютера)
     * @return
     */
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     * @param dot фишка игрока
     * @return результат проверки победы
     */
    static boolean checkWin(char dot) {

        //Проверка по горизонтали
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y <= fieldSizeY - WIN_COUNT; y++) {
                boolean win = true;
                for (int i = 0; i < WIN_COUNT; i++) {
                    if (field[x][y + i] != dot) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }


        // Проверка по вертикалям
        for (int x = 0; x <= fieldSizeX - WIN_COUNT; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                boolean win = true;
                for (int i = 0; i < WIN_COUNT; i++) {
                    if (field[x + i][y] != dot) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }


        // Проверка по диагоналям (левая верхняя - правая нижняя)
        for (int x = 0; x <= fieldSizeX - WIN_COUNT; x++) {
            for (int y = 0; y <= fieldSizeY - WIN_COUNT; y++) {
                boolean win = true;
                for (int i = 0; i < WIN_COUNT; i++) {
                    if (field[x + i][y + i] != dot) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }


        // Проверка по диагоналям (левая нижняя - правая верхняя)
        for (int x = 0; x <= fieldSizeX - WIN_COUNT; x++) {
            for (int y = WIN_COUNT - 1; y < fieldSizeY; y++) {
                boolean win = true;
                for (int i = 0; i < WIN_COUNT; i++) {
                    if (field[x + i][y - i] != dot) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        return false;
    }


    static boolean checkWinV2(char dot){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){

            }
        }
        return false;
    }

    static boolean check1(int x, int y, char dot, int win){
        //if (field[x][y + 1] == dot && field[x][y + 2] == dot && field[x][y + 3] == dot)
        return false;
    }

    static boolean check2(int x, int y, char dot, int win){
        return false;
    }

    static boolean check3(int x, int y, char dot, int win){
        return false;
    }

    static boolean check4(int x, int y, char dot, int win){
        return false;
    }


    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param s победный слоган
     * @return состояние игры
     */
    static boolean checkState(char dot, String s){
        if (checkWin(dot)){
            System.out.println(s);
            return true;
        }
        else if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        // Игра продолжается
        return false;
    }

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Вы победили!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if(!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

}
