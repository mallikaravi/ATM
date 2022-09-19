package com.novare.atm.service;

/**
 * It is a Marker interface that has no methods or constants inside it. It
 * provides run-time type information about objects, so the compiler and JVM
 * have additional information about the object
 * 
 */
// This compleement the comment on IAccountService. If there any data or functions, then what stops me as another developer
// to enter your code and swith an object form IBaseService to IAccountService and viceversa, as they dont have any validation.
public interface IMainService extends IBaseService {

}
