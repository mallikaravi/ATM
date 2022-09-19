package com.novare.atm.service;

/**
 * It is a Marker interface that has no methods or constants inside it. It
 * provides run-time type information about objects, so the compiler and JVM
 * have additional information about the object
 * 
 */
// Same as the others

/**
 * Same as the others.
 * The solution was to create an enum called eTypeOfService with the values:
 * ACCOUNT_SERVICE
 * MAIN_SERVICE
 * WELCOME_SERVICE
 *
 * And then on every screens that needs to check, you check if eTypeOfService is valid for the current situation
 */
public interface IUserService extends IBaseService {

}
