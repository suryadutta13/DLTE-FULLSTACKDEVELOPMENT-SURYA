package bank.project.app;


import bank.project.dao.BankService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import project.bank.soap.Account;
import project.bank.soap.ListSuspendedAccRequest;
import project.bank.soap.ListSuspendedAccResponse;
import project.bank.soap.Message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//class for service end points
@Endpoint
public class ServiceEndPoints {
    private static final String url="http://soap.bank.project";
    private Logger logger= LoggerFactory.getLogger(ServiceEndPoints.class);

    @Autowired
    private BankService bankService;

    @PayloadRoot(namespace = url,localPart = "listSuspendedAccRequest")

    //method to list Soap api suspended account (end point)
    @ResponsePayload
    public ListSuspendedAccResponse listSuspendedAccResponse(@RequestPayload ListSuspendedAccRequest listSuspendedAccRequest){
        ListSuspendedAccResponse response=new ListSuspendedAccResponse();
        Message message = new Message();



        List<bank.project.dao.Account> jpaComponent = bankService.ListSuspendedAccounts(listSuspendedAccRequest.getUser());// pojo objects
        if(jpaComponent.isEmpty()){
            message.setStatus("NoAccounts");
            response.setServiceStatus(message);
        }
        else{
            List<Account> accountList=new ArrayList<>();// xml list of objects as of its empty

            Iterator<bank.project.dao.Account> it= jpaComponent.iterator();
            while(it.hasNext()){
                Account account=new Account();// XSD POJO
                BeanUtils.copyProperties(it.next(),account);
                accountList.add(account);
            }


            response.getSuspendedAccount().addAll(accountList);
        }


        return response;
    }


}
