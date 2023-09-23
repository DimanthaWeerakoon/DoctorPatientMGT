package DocPatMGT.Model_DTO;

import DocPatMGT.Entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

    private User user;
    private PatientModel patientModel;
    private DoctorModel doctorModel;
    private String role;

}
