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

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * DAO Factory for accessing Objects using mongoDB
 *
 * Implement all DAO methods described in DAOFactory here
 *
 * <b>NOTE</b>: A repository must be injected with a setRepository call
 *
 * @author giorgio
 *
 */
public class MongoDBDAOFactory extends DAOFactory {

	private MongoRepository<?, ?> repository;

	/**
	 * gets the EmployeeDAO
	 *
	 * @return MongoDBEmployeeDAO or null
	 */
	@Override
	public EmployeeDAO getEmployeeDAO() {
		if (repository != null) {
			return new MongoDBEmployeeDAO((EmployeeRepository) repository);
		}
		return null;
	}

	/**
	 * Injects the MongoRepository to be used
	 *
	 * @param r the repository to be injected
	 */
	public void setRepository(MongoRepository<?, ?> r) {
		repository = r;
	}

}
