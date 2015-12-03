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

/**
 * DAOFactory Abstract Class
 *
 * Here you must define which types of DAO are suppported and an abstract class
 * for each DAO you may need
 *
 * @author giorgio
 */
public abstract class DAOFactory {
	// DAO types supported, only mongoDB for time being
	public static final int MONGODB = 1;

	// A method for each DAO
	public abstract EmployeeDAO getEmployeeDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MONGODB:
			return new MongoDBDAOFactory();
		default:
			return null;
		}
	}

}
