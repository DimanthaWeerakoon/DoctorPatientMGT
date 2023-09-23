package DocPatMGT.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public Patient(String firstName, String lastName, String gender, String age, String mobile, String userPhoto, String origin, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.mobile = mobile;
        this.userPhoto = userPhoto;
        this.origin = origin;
        this.user = user;
    }

    public Patient(String firstName, String lastName, String gender, String age, String mobile, String userPhoto, String origin, String email, String encode, String username) {











    }
}
