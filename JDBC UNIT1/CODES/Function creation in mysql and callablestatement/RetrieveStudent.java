    import java.sql.CallableStatement;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Types;

class RetrieveStudent {
        public static void main(String[] args) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");

                // Create a CallableStatement for the function
                String callSQL = "{? = CALL GetStudentName(?)}";
                CallableStatement cstmt = conn.prepareCall(callSQL);

                // Register the output parameter (name of the student)
                cstmt.registerOutParameter(1, Types.VARCHAR);
                // Set the input parameter (Student ID)
                cstmt.setInt(2, 1);

                // Execute the function
                cstmt.execute();

                // Retrieve the output
                String studentName = cstmt.getString(1);
                System.out.println("Student's name: " + studentName);
            } 
            catch (Exception e) {
                System.out.println(e);
            } 
        }
    }