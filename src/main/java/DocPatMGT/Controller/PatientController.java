package DocPatMGT.Controller;

import DocPatMGT.Entity.Patient;
import DocPatMGT.Entity.User;
import DocPatMGT.Model_DTO.UserModel;
import DocPatMGT.Response.DefaultResponse;
import DocPatMGT.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
//@Validated
public class PatientController {

    private final PatientService patientService;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
//        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public DefaultResponse savePatient(@Valid @RequestBody UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setMobile(userModel.getMobile());
//        user.setDtype("Patient");

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        List<String> errorMessage = result.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorMessage);
    }
}
