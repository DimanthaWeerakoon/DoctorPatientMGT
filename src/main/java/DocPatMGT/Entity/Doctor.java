package DocPatMGT.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Doctor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String position;
    private String specializedArea;
    private String doctorPhoto;
    private boolean status;
    private String language;
    private String qualifications;
    private String tasks;
    private double ratings;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
