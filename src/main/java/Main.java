import java.sql.*;

public class Main {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
           createTableCategories();
           createTablePosts();

           insertIntoCategories();
           insertIntoPosts();

            readEx("SELECT categories.title, count(posts.id) " +
                    "FROM categories INNER JOIN posts ON posts.category_id = categories.id " +
                    "GROUP BY categories.title;");

            readEx("SELECT * FROM posts");
            deleteEx("DELETE FROM posts WHERE category_id = 1;");
            readEx("SELECT * FROM posts");
            updateEx("UPDATE posts SET description='This is Programming. ' || description WHERE category_id = 3;");
            readEx("SELECT * FROM posts");

           dropTableEx("posts");
           dropTableEx("categories");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    private static void connect() throws SQLException {
        System.out.println("> Create connection");
        connection = DriverManager.getConnection("jdbc:sqlite:my_db.education_db");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
                System.out.println("> Connection close");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableCategories() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS categories (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " title TEXT\n" +
                " );");
        System.out.println("> Create categories table");
    }

    private static void createTablePosts() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS posts (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " title TEXT,\n" +
                " description TEXT,\n" +
                " category_id INTEGER\n" +
                " );");
        System.out.println("> Create posts table");
    }

    private static void dropTableEx(String table) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS " + table + ";");
        System.out.println("> Drop " + table + " table");
    }

    private static void insertIntoCategories() throws SQLException {
        statement.executeUpdate("INSERT INTO categories (title) VALUES ('Fruit');");
        statement.executeUpdate("INSERT INTO categories (title) VALUES ('Education');");
        statement.executeUpdate("INSERT INTO categories (title) VALUES ('Programming');");
    }

    private static void insertIntoPosts() throws SQLException {
        statement.executeUpdate("INSERT INTO posts (title,description, category_id) VALUES ('Apple', 'Red, green and ...', 1);");
        statement.executeUpdate("INSERT INTO posts (title,description, category_id) VALUES ('Math', 'Lesson math', 2);");
        statement.executeUpdate("INSERT INTO posts (title,description, category_id) VALUES ('Biology', 'gender', 2);");
        statement.executeUpdate("INSERT INTO posts (title,description, category_id) VALUES ('Orange', 'No Description', 1);");
        statement.executeUpdate("INSERT INTO posts (title,description, category_id) VALUES ('PHP', 'Programming language', 3);");
        statement.executeUpdate("INSERT INTO posts (title,description, category_id) VALUES ('Laravel', 'Php Framework', 3);");
        statement.executeUpdate("INSERT INTO posts (title,description, category_id) VALUES ('Kafka', 'Brocker messages', 3);");
    }

    private static void readEx(String query) throws SQLException {
        System.out.println("\n> Data:");
        try (ResultSet rs = statement.executeQuery(query)
        ) {
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void deleteEx(String query) throws SQLException {
        System.out.println("> Delete operation");
        statement.executeUpdate(query);
    }

    private static void updateEx(String query) throws SQLException {
        System.out.println("> Update operation");
        statement.executeUpdate(query);
    }

}
