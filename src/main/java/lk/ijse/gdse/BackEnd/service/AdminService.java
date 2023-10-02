package lk.ijse.gdse.BackEnd.service;

import lk.ijse.gdse.BackEnd.dto.AdminDTO;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface AdminService {
    AdminDTO checkAdminLogIn(String userName);
}
