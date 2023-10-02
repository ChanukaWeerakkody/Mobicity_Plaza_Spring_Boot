package lk.ijse.gdse.BackEnd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.BackEnd.dao.AdminDAO;
import lk.ijse.gdse.BackEnd.dto.AdminDTO;
import lk.ijse.gdse.BackEnd.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdminDTO checkAdminLogIn(String userName) {
        return modelMapper.map(adminDAO.searchAdminByUserName(userName), AdminDTO.class);
    }
}
