package com.jeenl.controller;
import javax.xml.namespace.QName;  
import org.apache.axis2.AxisFault;  
import org.apache.axis2.addressing.EndpointReference;  
import org.apache.axis2.client.Options;  
import org.apache.axis2.rpc.client.RPCServiceClient;  
  
public class UserServiceTest {  
    public static void main(String args[]) throws AxisFault {  
        // 使用RPC方式调用WebService  
        RPCServiceClient serviceClient = new RPCServiceClient();  
        Options options = serviceClient.getOptions();  
        // 指定调用WebService的URL  
        EndpointReference targetEPR = new EndpointReference("http://localhost:8080/jeenl-web/services/userService");  
        options.setTo(targetEPR);  
          
        // 指定要调用的sayHelloToPerson方法及WSDL文件的命名空间  
        QName opAddEntry = new QName("http://impl.service.jeenl.com","login");  
        // 指定sayHelloToPerson方法的参数值  
        Object[] opAddEntryArgs = new Object[] { "username","password" };  
        // 指定sayHelloToPerson方法返回值的数据类型的Class对象  
        Class[] classest = new Class[] { String.class };  
        // 调用sayHelloToPerson方法并输出该方法的返回值  
//        serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs, classes);
        serviceClient.invokeRobust(opAddEntry, opAddEntryArgs);;
    }  
    
    public static void test(){
//		ctx = new AnnotationConfigApplicationContext(UserDaoImpl.class);
//		UserDao userDao=ctx.getBean("userDaoImpl",UserDaoImpl.class);
//		userDao.login("nl", "niu");
//		ctx = new AnnotationConfigApplicationContext(UserServiceImpl.class);
//		UserService userService=ctx.getBean("userServiceImpl",UserServiceImpl.class);
//		userService.login("nl", "niu");
    }
}  