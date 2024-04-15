
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HealthDataDao {

  public boolean createHealthData(HealthData healthData) {
    /* insert health data into database */
    boolean bool = false;

    String query = "INSERT INTO health_data (user_id, weight, height, steps, heart_rate, date) " +
        "VALUES (?, ?, ?, ?, ?, ?)";

    // Database logic to insert data using PREPARED Statement
    try {
      Connection con = DatabaseConnection.getCon();
      PreparedStatement statement = con.prepareStatement(query);
      statement.setInt(1, healthData.getUserId());
      statement.setDouble(2, healthData.getWeight());
      statement.setDouble(3, healthData.getHeight());
      statement.setInt(4, healthData.getSteps());
      statement.setInt(5, healthData.getHeartRate());
      statement.setString(6, healthData.getDate());
      int updatedRows = statement.executeUpdate();
      if (updatedRows != 0) {
        bool = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bool;
  }

  public HealthData getHealthDataById(int id) {
    /* get health data by id from database */
    int healthId = 0;
    int userId = 0;
    double weight = 0.0;
    double height = 0.0;
    int steps = 0;
    int heartRate = 0;
    String date = "";

    // Prepare the SQL query
    String query = "SELECT * FROM health_data WHERE id = ?";

    // Database logic to get data by ID Using Prepared Statement
    try {
        Connection con = DatabaseConnection.getCon();
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            healthId = rs.getInt("id");
            userId = rs.getInt("user_id");
            weight = rs.getDouble("weight");
            height = rs.getDouble("height");
            steps = rs.getInt("steps");
            heartRate = rs.getInt("heart_rate");
            date = rs.getString("date");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return new HealthData(healthId, userId, weight, height, steps, heartRate, date);
  }

  public List<HealthData> getHealthDataByUserId(int userId) { 
    /* get health data by user id from database */ 
    List healthDataList = new ArrayList<>();

    // Prepare the SQL query
    String query = "SELECT * FROM health_data WHERE user_id = ?";

    // Database logic to get data by ID Using Prepared Statement
    try {
        Connection con = DatabaseConnection.getCon();
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, userId);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
          HealthData healthData = new HealthData(
            rs.getInt("id"), 
            rs.getInt("user_id"), 
            rs.getDouble("weight"),
            rs.getDouble("height"), 
            rs.getInt("steps"),
            rs.getInt("heart_rate"), 
            rs.getString("date")
            );
          healthDataList.add(healthData);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return healthDataList;
  }
  
  public boolean updateHealthData(HealthData healthData) { 
    /* update health data in the database */
    boolean bool = false;
        // Prepare the SQL query
        String query = "UPDATE health_data " +
                "SET user_id = ?, weight = ?, height = ?, steps = ?, heart_rate = ?, date = ? " +
                "WHERE id = ?";

        // Database logic to get update user Using Prepared Statement
        try {
            Connection con = DatabaseConnection.getCon();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, healthData.getUserId());
            statement.setDouble(2, healthData.getWeight());
            statement.setDouble(3, healthData.getHeight());
            statement.setInt(4, healthData.getSteps());
            statement.setInt(5, healthData.getHeartRate());
            statement.setString(6, healthData.getDate());
            statement.setInt(7, healthData.getId());
            int updatedRows = statement.executeUpdate();
            if (updatedRows != 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool; 
  }
  public boolean deleteHealthData(int id) { 
    /* delete health data from the database */
    boolean bool = false;
    // Prepare the SQL query
    String query = "DELETE FROM health_data WHERE id = ?";

    // Database logic to delete user
    try {
        Connection con = DatabaseConnection.getCon();
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, id);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated != 0){
            bool = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return bool;
  }
}
