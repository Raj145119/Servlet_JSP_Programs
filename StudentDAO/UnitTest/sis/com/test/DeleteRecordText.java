package sis.com.test;

import sis.com.Dao.StudentDao;
import sis.com.factory.StudentFactory;

public class DeleteRecordText {

	public static void main(String[] args) {
    StudentDao studentDao=StudentFactory.getStudentDao();
   boolean del= studentDao.deleteRecord(1001);
   System.out.println(del);
	}

}
