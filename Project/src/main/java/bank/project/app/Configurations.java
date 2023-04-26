package bank.project.app;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
//Configuration for Soap Service
public class Configurations extends WsConfigurerAdapter {
    @Bean(name = "Account")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema accountSchema){
        DefaultWsdl11Definition schemaObject=new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("AccountPort");
        schemaObject.setTargetNamespace("http://soap.bank.project");
        schemaObject.setLocationUri("/Accountpoint");
        schemaObject.setSchema(AccountSchema());
        return schemaObject;
    }

    @Bean
    public XsdSchema AccountSchema(){
        return new SimpleXsdSchema(new ClassPathResource("Suspended.xsd"));
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet,"/Accountpoint/*");
    }
}
