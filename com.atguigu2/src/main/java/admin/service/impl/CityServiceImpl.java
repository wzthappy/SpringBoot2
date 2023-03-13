package admin.service.impl;

import admin.bean.City;
import admin.mapper.CityMapper;
import admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

  @Autowired
  CityMapper cityMapper;

  @Override
  public City getById(Long id) {
    return cityMapper.getById(id);
  }

  @Override
  public void saveCity(City city) {
    cityMapper.insert(city);
  }
}
