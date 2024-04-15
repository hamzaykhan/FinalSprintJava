import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

    public List<User> getPatientsByDoctorId(int doctorId) {
        List<DoctorPatient> doctorPatientList = new ArrayList<>();
        List<User> patientList = new ArrayList<>();

        // Prepare the SQL query
        String query = "SELECT * FROM doctor_patient WHERE doctor_id = ?";

        // Database logic to get data by ID Using Prepared Statement
        try {
            Connection con = DatabaseConnection.getCon();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, doctorId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DoctorPatient doctorPatient = new DoctorPatient(
                        rs.getInt("doctor_id"),
                        rs.getInt("patient_id")
                );
                doctorPatientList.add(doctorPatient);
            }

            UserDao userDao = new UserDao();
            for (DoctorPatient doctorPatient: doctorPatientList) {
                patientList.add(userDao.getUserById(doctorPatient.getPatientId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;
    }
}
