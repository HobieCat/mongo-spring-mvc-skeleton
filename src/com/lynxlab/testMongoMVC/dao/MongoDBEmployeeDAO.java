/**
 * Copyright 2015 Giorgio Consorti <g.consorti@lynxlab.com>
 *
 * This file is part of mongo-spring-mvc-skeleton.
 *
 * mongo-spring-mvc-skeleton is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mongo-spring-mvc-skeleton is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * mongo-spring-mvc-skeleton. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.lynxlab.testMongoMVC.dao;

import java.util.List;

import com.lynxlab.testMongoMVC.domain.Employee;

/**
 * Employee DAO implementation using mongodb
 *
 * All data access is delegated to the spring EmployeeRepository injected by the
 * controller in the MongoDBDAOFactory class
 *
 * @author giorgio
 */
public class MongoDBEmployeeDAO implements EmployeeDAO {

	private EmployeeRepository employeeRepository;

	public MongoDBEmployeeDAO(EmployeeRepository repository) {
		employeeRepository = repository;
	}

	@Override
	public Employee create(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public Employee update(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
