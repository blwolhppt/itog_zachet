package sql.excel;


import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class task5sqlex {
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
            System.out.println("3. Ввести две строки в MySQL с выводом в консоль");
            System.out.println("4. Изменить порядок символов строки на обратный, результат сохранить в MySQL с последующим выводом в консоль.");
            System.out.println("5. Добавить одну строку в другую, результат сохранить в MySQL с последующим выводом в консоль");
            System.out.println("6. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран");
            System.out.println("7. Выход из программы");

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

                    System.out.println("Введите первую строку: ");
                    str1 = scan.nextLine();
                    System.out.println("Введите вторую строку: ");
                    str2 = scan.nextLine();

                    String query3 = "INSERT INTO " + table_name + " (id, text) VALUES (?,?), (?, ?);";
                    PreparedStatement statement3 = connection.prepareStatement(query3);
                    statement3.setInt(1, i);
                    statement3.setString(2, str1);
                    i++;
                    statement3.setInt(3, i);
                    statement3.setString(4, str2);
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

                    String query4 = "INSERT INTO " + table_name + " (id, text) VALUES (?,?);";
                    PreparedStatement statement4 = connection.prepareStatement(query4);

                    String dop_str_1 = new StringBuilder(str1).reverse().toString();
                    System.out.println(dop_str_1);


                    statement4.setInt(1, i);
                    statement4.setString(2, dop_str_1);
                    statement4.executeUpdate();
                    i++;

                    ResultSet result4 = statement4.executeQuery("SELECT * from " + table_name + ";");
                    System.out.println("Ведённые данные:");
                    while (result4.next()) {
                        System.out.print(Arrays.toString(result4.getString(1).split("  ")));
                        System.out.print(Arrays.toString(result4.getString(2).split("  ")));
                        System.out.println();
                    }
                }
                case 5 -> {

                    String query5 = "INSERT INTO " + table_name + " (id, text) VALUES (?,?);";
                    PreparedStatement statement5 = connection.prepareStatement(query5);

                    String l = str1.substring(0, 6) + str2 + str1.substring(6, str1.length());

                    statement5.setInt(1, i);
                    statement5.setBoolean(2, str1.contains(l));
                    statement5.executeUpdate();
                    i++;


                    ResultSet result5 = statement5.executeQuery("SELECT * from " + table_name + ";");
                    System.out.println("Ведённые данные:");
                    while (result5.next()) {
                        System.out.print(Arrays.toString(result5.getString(1).split(" ")));
                        System.out.print(Arrays.toString(result5.getString(2).split(" ")));
                        System.out.println();
                    }
                }
                case 6 -> {
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
