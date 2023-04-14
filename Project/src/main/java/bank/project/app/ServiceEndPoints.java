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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Endpoint
public class ServiceEndPoints {
    private static final String url="http://soap.bank.project";
    private Logger logger= LoggerFactory.getLogger(ServiceEndPoints.class);

    @Autowired
    private BankService bankService;

    @PayloadRoot(namespace = url,localPart = "listSuspendedAccRequest")
    @ResponsePayload
    public ListSuspendedAccResponse listSuspendedAccResponse(@RequestPayload ListSuspendedAccRequest listSuspendedAccRequest){
        ListSuspendedAccResponse response=new ListSuspendedAccResponse();


        List<bank.project.dao.Account> jpaComponent = bankService.ListSuspendedAccounts(listSuspendedAccRequest.getUser());// pojo objects
        List<Account> accountList=new ArrayList<>();// xml list of objects as of its empty

        Iterator<bank.project.dao.Account> it= jpaComponent.iterator();
        while(it.hasNext()){
            Account account=new Account();// XSD POJO
            BeanUtils.copyProperties(it.next(),account);
            accountList.add(account);
        }

//        serviceStatus.setStatus("SUCCESS");
//        serviceStatus.setMessage("Official's are fetched from Table");

//        response.setServiceStatus(serviceStatus);
        response.getSuspendedAccount().addAll(accountList);

        return response;
    }


}
