package lk.ijse.gdse.BackEnd.api;

import lk.ijse.gdse.BackEnd.dto.AdminDTO;
import lk.ijse.gdse.BackEnd.service.AdminService;
import lk.ijse.gdse.BackEnd.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping(params = {"userName"})
    public ResponseUtil loginAdmin(@RequestParam String userName){
        AdminDTO adminDTO = adminService.checkAdminLogIn(userName);
        return new ResponseUtil(200,"Login Success!",adminDTO);
    }
}
