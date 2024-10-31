import java.sql.*;

class ResultSetMD {
    public static void main(String args[]) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student", "root", "1234");

            String sql = "SELECT id, name FROM info";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // Get metadata of the ResultSet
            ResultSetMetaData rsmd = rs.getMetaData();

            // Get the number of columns
            int columnCount = rsmd.getColumnCount();
            System.out.println("Total Columns: " + columnCount);

            // Loop through each column to display metadata
            for (int i=1; i<= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("  Name: " + rsmd.getColumnName(i));
                System.out.println("  Data Type: " + rsmd.getColumnTypeName(i));
                System.out.println("  Column Display Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("  Is Nullable: " + rsmd.isNullable(i));
                System.out.println();
            }

        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
