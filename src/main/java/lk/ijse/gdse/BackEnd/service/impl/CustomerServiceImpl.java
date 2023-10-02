package lk.ijse.gdse.BackEnd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.BackEnd.dao.CustomerDAO;
import lk.ijse.gdse.BackEnd.dto.CustomerDTO;
import lk.ijse.gdse.BackEnd.entity.Customer;
import lk.ijse.gdse.BackEnd.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if(!customerDAO.existsById(dto.getFirstName())){
            customerDAO.save(mapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer id is exists!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if(customerDAO.existsById(id)){
            customerDAO.deleteById(id);
        }else{
            throw new RuntimeException("Customer id is not found!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if(customerDAO.existsById(dto.getFirstName())){
            customerDAO.save(mapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("Customer id is not found!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (customerDAO.existsById(id)) {
            return mapper.map(customerDAO.findById(id).get(), CustomerDTO.class);
        }else{
            throw new RuntimeException("Customer id is not found!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerDAO.findAll();
        return mapper.map(all,new TypeToken<CustomerDTO>(){}.getType());
    }


}
