package sis.com.factory;

import sis.com.Dao.LoginDao;
import sis.com.Dao.StudentDao;
import sis.com.impl.LoginService;
import sis.com.impl.StudentDaoOrecleImpl;

public final class StudentFactory {
	
	public static StudentDao getStudentDao(){
		
		return new StudentDaoOrecleImpl();
	}
  public static LoginDao getLoginDao(){
	  return new LoginService();
  }
}
