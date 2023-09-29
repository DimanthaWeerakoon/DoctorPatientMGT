package DocPatMGT.Controller;

import DocPatMGT.Entity.Patient;
import DocPatMGT.Entity.User;
import DocPatMGT.Model_DTO.UserModel;
import DocPatMGT.Response.DefaultResponse;
import DocPatMGT.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/register")
    public DefaultResponse savePatient(@RequestBody UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setMobile(userModel.getMobile());

        Patient patient = new Patient();
        patient.setGender(userModel.getPatientModel().getGender());
        patient.setAge(userModel.getPatientModel().getAge());
        patient.setOrigin(userModel.getPatientModel().getOrigin());
        user.setRole(userModel.getRole());

        String roleName = userModel.getRole();

        try {
            patientService.saveUser(user, patient, roleName);
            return new DefaultResponse(200, "success", "Patient registration successful!");
        } catch (Exception e) {
            return new DefaultResponse(400, "failed", "Patient registration unsuccessful!");
        }
    }
}
