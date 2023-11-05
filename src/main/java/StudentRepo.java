import java.sql.*;

public class StudentRepo {

    private Connection con;
    private Statement st;
    private PreparedStatement prst;

    private void setConnnection() {
        try {
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC_example",
                    "techpro", "password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void setStatement() {
        try {
            this.st = con.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setPreStatement(String sqlQuery) {
        try {
            this.prst = con.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTable(){

        setConnnection();
        setStatement();
        try {
            st.execute("CREATE TABLE IF NOT EXISTS  t_students(" +
                    "id SERIAL UNIQUE," +
                    "name VARCHAR(10) NOT NULL CHECK(LENGTH(name)>0)," +
                    "lastname VARCHAR(10) NOT NULL CHECK(LENGTH(lastname)>0)," +
                    "city VARCHAR(10) NOT NULL CHECK(LENGTH(city)>0)," +
                    "age INT NOT NULL CHECK(age>0))");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void save(Student std) {
        setConnnection();
        String sqlQuery = "INSERT INTO t_students(Name,lastname,city,age) VALUES(?,?,?,?)";
        setPreStatement(sqlQuery);
        try {
            prst.setString(1, std.getName());
            prst.setString(2, std.getLastname());
            prst.setString(3, std.getCity());
            prst.setInt(4, std.getAge());
            prst.executeUpdate();

            System.out.println("saved succesfully...");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public void getAll() {
        setConnnection();
        setStatement();
        try {
            ResultSet rst = st.executeQuery("SELECT * FROM t_students");
            System.out.println("-".repeat(10) + " Student List " + "-".repeat(10));
            while (rst.next()) {
                int stId = rst.getInt("id");
                String stName = rst.getString("name");
                String stLastName = rst.getString("lastname");
                String stCity = rst.getString("city");
                int stAge = rst.getInt("age");
                System.out.println(stId + " - " + stName + " - " + stLastName + " - " + stCity + " - " + stAge);

            }
            System.out.println("-".repeat(34));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                st.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public Student getById(int id) {

        setConnnection();
        String sqlQuery = "SELECT * FROM t_students WHERE id = ?";
        setPreStatement(sqlQuery);
        try {
            prst.setInt(1,id);
            ResultSet rslSet = prst.executeQuery();

            if (rslSet.next()){
                return new Student(
                        rslSet.getInt("id"),
                        rslSet.getString("name"),
                        rslSet.getString("lastname"),
                        rslSet.getString("city"),
                        rslSet.getInt("age")
                );
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

        return null;
    }

    public void delete(int id) {

        setConnnection();
        String sqlQuery = "DELETE FROM t_students WHERE id = ?";
        setPreStatement(sqlQuery);
        try {
            prst.setInt(1,id);
            int result = prst.executeUpdate();

            if (result>0){
                System.out.println("student deleted succesfully");
            }else {
                System.out.println("There is no student that has an ID you entered");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public void update(String name, String lastname, String city, int age, int id) {

        setConnnection();
        String sqlQuery = "UPDATE t_students SET name = ?, lastname = ?," +
                "city = ?, age = ? WHERE id = ?";
        setPreStatement(sqlQuery);
        try {

            prst.setString(1,name);
            prst.setString(2,lastname);
            prst.setString(3,city);
            prst.setInt(4,age);
            prst.setInt(5,id);
            int result = prst.executeUpdate();

            if (result>0){
                System.out.println("student updated succesfully");
            }else {
                System.out.println("There is no student that has an ID you entered");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
