package com.example.restservice.Service;

import com.example.restservice.Date.CompanyEntity;
import com.example.restservice.Date.DataBaseRepository;
import com.example.restservice.Date.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    @Autowired
    DataBaseRepository dataBaseRepository;
    @Autowired
    EmployeeService employeeService;

    public Map<Long, CompanyEntity> findAll() {
        if (dataBaseRepository.getCompanyDataBase().size() == 0) {
            dataBaseRepository.init();
        }
        return dataBaseRepository.getCompanyDataBase();
    }


    public CompanyEntity findById(Long id) {
        return dataBaseRepository.getCompanyDataBase().get(id);
    }

    public List<EmployeeEntity> findAllEmployees(Long id) {
        ArrayList<EmployeeEntity> employeeEntities = new ArrayList<>(dataBaseRepository.getEmployeeDataBase().values());
        return employeeEntities.stream().filter(i -> Objects.equals(i.getCompanyId(), id)).collect(Collectors.toList());

    }

    public List<CompanyEntity> findByPage(int pageNem, int pageSize) {
        HashMap<Long, CompanyEntity> companyDataBase = (HashMap<Long, CompanyEntity>) dataBaseRepository.getCompanyDataBase();
        ArrayList<CompanyEntity> companyEntities = new ArrayList<>();

        long startIndex = (long) (pageNem - 1) * pageSize + 1;
        long endIndex = (long) pageNem * pageSize;
        for (Long j = startIndex; j <= endIndex; j++) {
            if (companyDataBase.containsKey(j)) {
                companyEntities.add(companyDataBase.get(j));
            }
        }

        return companyEntities;
    }

    public CompanyEntity create(CompanyEntity company) {
        ArrayList<CompanyEntity> list = new ArrayList<>(dataBaseRepository.getCompanyDataBase().values());
        Long currentId = list.get(list.size() - 1).getId();
        long id = currentId + 1;
        company.setId(id);
        return dataBaseRepository.getCompanyDataBase().put(company.getId(), company);
    }

    public boolean update(Long id, CompanyEntity company) {
        company.setId(id);
        dataBaseRepository.getCompanyDataBase().put(id, company);
        return true;
    }

    public boolean delete(Long id) {
        dataBaseRepository.getCompanyDataBase().remove(id);
        employeeService.deleteByCompanyId(id);
        return true;
    }
}
