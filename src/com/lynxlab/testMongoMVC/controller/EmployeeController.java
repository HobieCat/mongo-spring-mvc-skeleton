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
package com.lynxlab.testMongoMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lynxlab.testMongoMVC.dao.DAOFactory;
import com.lynxlab.testMongoMVC.dao.EmployeeDAO;
import com.lynxlab.testMongoMVC.dao.EmployeeRepository;
import com.lynxlab.testMongoMVC.dao.MongoDBDAOFactory;
import com.lynxlab.testMongoMVC.domain.Employee;

@Controller
/**
 * Employee Controller.
 *
 * This class will map a GET request to the "/" url to the users.jsp page It
 * will assume that a MongoDB collection has been populated, will load all
 * elements of the collection and build an HTML ordered list and pass it to the
 * view
 *
 * @author giorgio
 */
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	// which DAOFactory to use
	private final int useDAOFactory = DAOFactory.MONGODB;

	@RequestMapping(value = "/", method = RequestMethod.GET)

	/**
	 * Gets the Employee List and pass the ordered list to the view
	 *
	 * @return HTML formatted as a String
	 */
	public ModelAndView getEmployees() {
		/**
		 * DAOFactory Object is casted to MongoDBDAOFactory because we need to
		 * inject the Autowired repository
		 */
		DAOFactory theDAOFactory = DAOFactory.getDAOFactory(useDAOFactory);
		if (useDAOFactory == DAOFactory.MONGODB) {
			/**
			 * If using mongoDB, inject the repository object in DAOFactory
			 */
			((MongoDBDAOFactory) theDAOFactory).setRepository(repository);
		}
		/**
		 * gets EmployeeDAO
		 */
		EmployeeDAO employeeDAO = theDAOFactory.getEmployeeDAO();

		String outString = "<ol>";
		List<Employee> employeeList = employeeDAO.findAll();
		outString += "<li>size=" + employeeList.size() + "</li>";
		for (Employee e : employeeList) {
			outString += "<li>" + e.toString() + "</li>";
		}
		outString += "</ol>";

		return new ModelAndView("users", "userList", outString);
	}
}
