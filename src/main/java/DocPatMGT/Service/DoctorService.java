package DocPatMGT.Service;

import DocPatMGT.Entity.Doctor;
import DocPatMGT.Entity.Role;
import DocPatMGT.Entity.User;
import DocPatMGT.Repository.DoctorRepository;
import DocPatMGT.Repository.RoleRepository;
import DocPatMGT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class DoctorService {

    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public DoctorService(UserRepository userRepository, DoctorRepository doctorRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void saveUser(User user, Doctor doctor, String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role != null) {
            userRepository.save(user);
            user.getRoles().add(role);
            doctorRepository.save(doctor);
        }
    }
}
