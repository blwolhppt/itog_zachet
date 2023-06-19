package sql.excel;


import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class task7sqlex {
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
            System.out.println("3. Ввести одномерный массив и сохранить в MySQL с последующим выводом в консоль. Отсортировать массив и сохранить в MySQL с последующим выводом в консоль.");
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

                    int[] mas = new int[15];

                    Scanner scanner = new Scanner(System.in);
                    for (int a = 0; a < 15; a++) {
                        mas[a] = scanner.nextInt();
                    }

                    boolean isSorted = false;
                    int buf;
                    while (!isSorted) {
                        isSorted = true;
                        for (int a = 0; a < mas.length - 1; a++) {
                            if (mas[a] > mas[a + 1]) {
                                isSorted = false;

                                buf = mas[a];
                                mas[a] = mas[a + 1];
                                mas[a + 1] = buf;
                            }
                        }
                    }
                    System.out.println(Arrays.toString(mas));


                    String query3 = "INSERT INTO " + table_name + " (id, text) VALUES (?,?);";
                    PreparedStatement statement3 = connection.prepareStatement(query3);
                    statement3.setInt(1, i);
                    statement3.setString(2, Arrays.toString(mas));
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
