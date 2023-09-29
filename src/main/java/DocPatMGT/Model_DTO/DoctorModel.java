package DocPatMGT.Model_DTO;

import DocPatMGT.Entity.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorModel {

    private String firstName;
    private String lastName;
    private String mobile;
    private String position;
    private String specializedArea;
    private String language;
}
