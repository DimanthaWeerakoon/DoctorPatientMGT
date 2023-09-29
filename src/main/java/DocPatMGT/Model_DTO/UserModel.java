package DocPatMGT.Model_DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String mobile;
    private PatientModel patientModel;
    private DoctorModel doctorModel;
    private String role;

}
