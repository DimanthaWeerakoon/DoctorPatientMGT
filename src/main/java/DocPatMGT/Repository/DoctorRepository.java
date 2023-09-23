package DocPatMGT.Repository;

import DocPatMGT.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
