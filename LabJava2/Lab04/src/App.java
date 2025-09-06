import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("AAAAGH CONTAAAAAAS!!!!");
        App.create(2, 100);
        App.delete(1);
    }

    public static void create(int numero, float saldo) throws SQLException {
        String url = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:6543/postgres?user=postgres.enzuunnflobtybwsgspq&password=klpymH7O3RiQcde3";
        Connection c = DriverManager.getConnection(url);
        String sql = "INSERT INTO contas (nro_conta, saldo) VALUES (?, ?)";
        PreparedStatement statement = c.prepareStatement(sql);
        statement.setInt(1, numero);
        statement.setFloat(2, saldo);
        statement.executeUpdate();
        c.close();
    }

    public static void update(int numero, float saldo) throws SQLException {
        String url = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:6543/postgres?user=postgres.enzuunnflobtybwsgspq&password=klpymH7O3RiQcde3";
        Connection c = DriverManager.getConnection(url);
        String sql = "update contas set saldo = ? where nro_conta = ?";
        PreparedStatement statement = c.prepareStatement(sql);
        statement.setInt(2, numero);
        statement.setFloat(1, saldo);
        statement.executeUpdate();
        c.close();
    }

        public static void delete(int numero) throws SQLException {
        String url = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:6543/postgres?user=postgres.enzuunnflobtybwsgspq&password=klpymH7O3RiQcde3";
        Connection c = DriverManager.getConnection(url);
        String sql = "delete from contas where nro_conta = ?";
        PreparedStatement statement = c.prepareStatement(sql);
        statement.setInt(1, numero);
        statement.executeUpdate();
        c.close();
    }
}