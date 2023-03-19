package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.models.dto.BillDto;
import com.msbills.models.dto.UserDto;
import com.msbills.repositories.BillRepository;
import com.msbills.repositories.FeignUsersRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

  private final BillRepository repository;
  private final FeignUsersRepository feignUsersRepository;


  public List<Bill> getAllBill() {
    return repository.findAll();
  }

  public Bill saveBill(Bill bill) {
    return repository.save(bill);
  }

  public Bill findByCustomer(String customer) {
    return repository.findByCustomerBill(customer).orElse(null);
  }

public BillDto findBillByUsername(String username) {
  List<UserDto> user = feignUsersRepository.findByUsername(username);
  UserDto userDto= new UserDto();
  userDto.setUsername(user.get(0).getUsername());
  userDto.setFirstName(user.get(0).getFirstName());
  userDto.setLastName(user.get(0).getFirstName());
  userDto.setEmail(user.get(0).getEmail());
  Bill bill= repository.findByCustomerBill(username).orElse(null);
  BillDto res= new BillDto();
  res.setIdBill(bill.getIdBill());
  res.setBillingDate(bill.getBillingDate());
  res.setTotalPrice(bill.getTotalPrice());
  res.setUser(userDto);
	return res;
}

}
