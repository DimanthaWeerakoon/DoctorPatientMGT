//package DocPatMGT.Controller;
//
//import DocPatMGT.Entity.Doctor;
//import DocPatMGT.Entity.User;
//import DocPatMGT.Model_DTO.UserModel;
//import DocPatMGT.Response.DefaultResponse;
//import DocPatMGT.Service.DoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/doctor")
//public class DoctorController {
//
//    private final DoctorService doctorService;
//
//    @Autowired
//    public DoctorController(DoctorService doctorService) {
//        this.doctorService = doctorService;
//    }
//
////    @PostMapping("/register")
////    public DefaultResponse saveDoctor(@RequestBody UserModel userModel) {
////        User user = new User(userModel.getEmail(), userModel.getUsername(), userModel.getPassword()
////                , userModel.getFirstName(), userModel.getLastName(), userModel.getMobile(), userModel.getRole());
////        Doctor doctor = new Doctor(userModel.getDoctorModel().getPosition(), userModel.getDoctorModel().getSpecializedArea()
////                , userModel.getDoctorModel().getLanguage());
//////        user.setEmail(userModel.getEmail());
//////        user.setUsername(userModel.getUsername());
//////        user.setPassword(userModel.getPassword());
//////        user.setRole(userModel.getRole());
//////        user.setFirstName(userModel.getFirstName());
//////        user.setLastName(userModel.getLastName());
//////        user.setMobile(userModel.getMobile());
//////        doctor.setPosition(userModel.getDoctorModel().getPosition());
//////        doctor.setSpecializedArea(userModel.getDoctorModel().getSpecializedArea());
//////        doctor.setLanguage(userModel.getDoctorModel().getLanguage());
//
////        String roleName = userModel.getRole();
////
////        try {
////            doctorService.saveUser(user, doctor, roleName);
////            return new DefaultResponse(200, "success", "Doctor registration successful!");
////        } catch (Exception e) {
////            return new DefaultResponse(400, "failed", "Doctor registration unsuccessful!");
////        }
////    }
//}
