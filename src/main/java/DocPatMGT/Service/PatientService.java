package DocPatMGT.Service;

import DocPatMGT.Entity.Patient;
import DocPatMGT.Entity.Role;
import DocPatMGT.Entity.User;
import DocPatMGT.Repository.PatientRepository;
import DocPatMGT.Repository.RoleRepository;
import DocPatMGT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public PatientService(UserRepository userRepository, PatientRepository patientRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void saveUser(User user, Patient patient, String roleName){
        Role role = roleRepository.findByName(roleName);
        if (role != null){
            user.getRoles().add(role);
            userRepository.save(user);
        }
        patientRepository.save(patient);
    }
}
