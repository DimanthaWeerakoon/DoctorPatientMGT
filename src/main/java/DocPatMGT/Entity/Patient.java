package DocPatMGT.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Patient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String age;
    private String mobile;
    private String userPhoto;
    private String origin;
    private String records;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
