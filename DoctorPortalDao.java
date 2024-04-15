

import java.util.List;

public class DoctorPortalDao {
    private UserDao userDao;
    private HealthDataDao healthDataDao;
    private PatientDao patientDao;

   // Complete all these methods and add more as needed

    public DoctorPortalDao() {
        userDao = new UserDao();
        healthDataDao = new HealthDataDao();
    }

    public Doctor getDoctorById(int doctorId) {
        Doctor doctor = null;
        try {
            doctor = (Doctor) userDao.getUserById(doctorId);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Invalid doctor id");
        }
        return doctor;
    }

    public List<User> getPatientsByDoctorId(int doctorId) {
        // Implement this method
        return patientDao.getPatientsByDoctorId(doctorId);
    }

    public List<HealthData> getHealthDataByPatientId(int patientId) {
        // Implement this method
        return healthDataDao.getHealthDataByUserId(patientId);
    }
}

