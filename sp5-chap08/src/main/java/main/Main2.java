package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);

        MemberDao cps = 
                ctx.getBean(MemberDao.class);

        
        System.out.println(cps.countTest());
        System.out.println(cps.selectMemberTest2(1));
		ctx.close();

	}
}
