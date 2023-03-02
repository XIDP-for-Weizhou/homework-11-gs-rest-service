package com.example.restservice.Service;

import com.example.restservice.Date.DataBaseRepository;
import com.example.restservice.Date.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    DataBaseRepository dataBaseRepository;

    public HashMap<Long, EmployeeEntity> findAll() {
        if (dataBaseRepository.getEmployeeDataBase().size() == 0) {
            dataBaseRepository.init();
        }
        return dataBaseRepository.getEmployeeDataBase();
    }


    public EmployeeEntity findById(Long id) {
        return dataBaseRepository.getEmployeeDataBase().get(id);
    }

    public List<EmployeeEntity> findEmployeesByGender(String gender) {
        ArrayList<EmployeeEntity> employeeEntities = new ArrayList<>(dataBaseRepository.getEmployeeDataBase().values());
        return employeeEntities.stream().filter(i -> Objects.equals(i.getGender(), gender)).collect(Collectors.toList());

    }

    public List<EmployeeEntity> findByPage(int pageNem, int pageSize) {
        HashMap<Long, EmployeeEntity> employeeDataBase = dataBaseRepository.getEmployeeDataBase();
        ArrayList<EmployeeEntity> employeeEntities = new ArrayList<>();

        long startIndex = (long) (pageNem - 1) * pageSize + 1;
        long endIndex = (long) pageNem * pageSize;
        for (Long j = startIndex; j <= endIndex; j++) {
            if (employeeDataBase.containsKey(j)) {
                employeeEntities.add(employeeDataBase.get(j));
            }
        }

        return employeeEntities;
    }

    public EmployeeEntity create(EmployeeEntity employee) {
        ArrayList<EmployeeEntity> list = new ArrayList<>(dataBaseRepository.getEmployeeDataBase().values());
        Long currentId = list.get(list.size() - 1).getId();
        long id = currentId + 1;
        employee.setId(id);
        return dataBaseRepository.getEmployeeDataBase().put(employee.getId(), employee);
    }

    public boolean update(Long id, EmployeeEntity employee) {
        employee.setId(id);
        dataBaseRepository.getEmployeeDataBase().put(id, employee);
        return true;
    }

    public boolean delete(Long id) {
        dataBaseRepository.getEmployeeDataBase().remove(id);
        return true;
    }

    public void deleteByCompanyId(Long companyId) {
        ArrayList<EmployeeEntity> employeeEntities = new ArrayList<>(dataBaseRepository.getEmployeeDataBase().values());
        List<EmployeeEntity> list = employeeEntities.stream().filter(i -> Objects.equals(i.getCompanyId(), companyId)).toList();

        for (EmployeeEntity e :
                list) {
            delete(e.getId());
        }
    }
}
