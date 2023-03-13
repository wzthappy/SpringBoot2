package admin.service;

import admin.bean.City;

public interface CityService {

  City getById(Long id);

  void saveCity(City city);
}
