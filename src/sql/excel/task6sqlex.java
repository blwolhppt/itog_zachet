package sql.excel;


import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class task6sqlex {
    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        String str1 = "";
        String str2 = "";
        int i = 1;
        String chosen_table_name = "";

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlURL = "jdbc:mysql://localhost/test";
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "AAfr2083");
        System.out.println("Вы успешно законнектились к базе данных!");

        String s = "";
        int x = 0;
        String table_name = "";

        while (!"8".equals(s)) {
            System.out.println("1. Вывести все таблицы из MySQL");
            System.out.println("2. Создать таблицу в MySQL");
            System.out.println("3. Ввести две матрицы с клавиатуры и каждую из них сохранить в MySQL с последующим выводом в консоль. Перемножить матрицу, сохранить перемноженную матрицу в MySQL и вывести в консоль.");
            System.out.println("4. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран");
            System.out.println("5. Выход из программы");

            s = scan.nextLine();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода числа!");
            }
            switch (x) {
                case 1 -> {

                    Statement statement = connection.createStatement();
                    ResultSet res = statement.executeQuery("Show tables;");
                    System.out.println("Таблицы из текущей базы данных: ");
                    while (res.next()) {
                        System.out.println(res.getString(1));
                    }
                }
                case 2 -> {

                    System.out.println("Введите название таблицы для создания: ");
                    table_name = scan.nextLine();

                    Statement statement2 = connection.createStatement();
                    String query2 = "CREATE TABLE IF NOT EXISTS " + table_name + " (id int, text VARCHAR(255));";
                    statement2.executeUpdate(query2);

                    System.out.println("Таблица создана.");
                    ResultSet result_after_all = statement2.executeQuery("SHOW TABLES;");
                    System.out.println("Таблицы в базе данных: ");
                    while (result_after_all.next()) {
                        System.out.print(result_after_all.getString(1));
                        System.out.println();
                    }
                }
                case 3 -> {

                    System.out.println("Введите первый массив: ");
                    int[][] mas_one = new int[7][];
                    Scanner scanner_one = new Scanner(System.in);
                    for (int a = 0; a < 7; a++) {
                        mas_one[a] = new int[7];
                        for (int j = 0; j < 7; j++) {
                            mas_one[a][j] = scanner_one.nextInt();
                        }
                    }
                    String s1 = new String();
                    for (int q = 0; q < 7; q++) {
                        for (int j = 0; j < 7; j++) {
                            String a = String.valueOf(mas_one[q][j]);
                            s1 = s1 + " " +a;
                        }
                    }

                    System.out.println("Введите второй массив: ");
                    int[][] mas_two = new int[7][];
                    Scanner scanner_two = new Scanner(System.in);
                    for (int a = 0; a < 7; a++) {
                        mas_two[a] = new int[7];
                        for (int j = 0; j < 7; j++) {
                            mas_two[a][j] = scanner_two.nextInt();
                        }
                    }

                    String s2 = new String();
                    for (int q = 0; q < 7; q++) {
                        for (int j = 0; j < 7; j++) {
                            String a = String.valueOf(mas_one[q][j]);
                            s2 = s2 + " " +a;
                        }
                    }

                    int[][] end_array = new int[mas_one.length][mas_two[0].length];

                    for (int a = 0; a < mas_one.length; a++) {
                        for (int j = 0; j < mas_two[0].length; j++) {
                            for (int k = 0; k < mas_two.length; k++) {
                                end_array[a][j] += mas_one[a][k] * mas_two[k][j];
                            }
                        }
                    }

                    String s3 = new String();
                    for (int q = 0; q < 7; q++) {
                        for (int j = 0; j < 7; j++) {
                            String a = String.valueOf(end_array[q][j]);
                            s3 = s3 + " " +a;
                        }
                    }

                    String query3 = "INSERT INTO " + table_name + " (id, text) VALUES (?,?), (?, ?), (?, ?);";
                    PreparedStatement statement3 = connection.prepareStatement(query3);
                    statement3.setInt(1, i);
                    statement3.setString(2, s1);
                    i++;


                    statement3.setInt(3, i);
                    statement3.setString(4, s2);
                    i++;

                    statement3.setInt(5, i);
                    statement3.setString(6, s3);
                    statement3.executeUpdate();
                    i++;

                    ResultSet result3 = statement3.executeQuery("SELECT * from " + table_name + ";");
                    System.out.println("Ведённые данные:");
                    while (result3.next()) {
                        System.out.print(Arrays.toString(result3.getString(1).split(" ")));
                        System.out.print(Arrays.toString(result3.getString(2).split(" ")));
                        System.out.println();
                    }
                }

                case 4 -> {
                    System.out.println("Введите название файла с расширением: ");
                    String file = scan.nextLine();
                    Statement statement7 = connection.createStatement();
                    String query7 = "SELECT 'ID', 'RESULT' UNION ALL SELECT * FROM " + table_name + " INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/" + file + "' CHARACTER SET cp1251 ";
                    statement7.executeQuery(query7);
                    System.out.println("Данные успешно эксплоатированы!");
                }
            }
        }
    }
}
