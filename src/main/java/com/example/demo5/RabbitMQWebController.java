package com.example.demo5;

import io.micrometer.common.util.StringUtils;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class RabbitMQWebController {
    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        Connector connector = new ConnectorProxy();
        connector.uploadFile("jkmk");

        Project project = new ProxyProject("http://git_hub.ru/realProject");
        project.run();



        InvocationHandler handler = new MyProxy();
        Class[] classes = new Class[]{Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null, classes, handler);
        proxy.getClass();
        proxy.toString();


        List<Employee> employeeList = new ArrayList<>();
        List<Employee> employeeList2 = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setEmpName("Ivaneeee");
        emp1.setSum(new BigDecimal(3000));
        emp1.setNum(20);

        Employee emp2 = new Employee();
        emp2.setEmpName("kana");
        emp2.setSum(new BigDecimal(3000));
        emp2.setNum(40);

        Employee emp8 = new Employee();
        emp8.setEmpName("kanarrr");
        emp8.setSum(new BigDecimal(11000));
        emp8.setNum(600);

        Employee emp3 = new Employee();
        emp3.setEmpName("Ivan");
        emp3.setSum(new BigDecimal(7000));
        emp3.setNum(80);

        Employee emp7 = new Employee();
        emp7.setEmpName("KKKK");
        emp7.setSum(null);
        emp7.setNum(90);

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList2.add(emp8);
        employeeList2.add(emp7);

        Employee dddd = employeeList.stream().filter(fff-> "kana".equals(fff.getEmpName())).findFirst().orElse(null);
        System.out.println("Azamateeeee " + dddd.getNum());





        Employeemain employeemain = new Employeemain();
        employeemain.setName("One");
        employeemain.setPinCode(333);
        employeemain.setEmployeeList(employeeList);
        Employeemain employeemain2 = new Employeemain();
        employeemain.setName("Two");
        employeemain2.setEmployeeList(employeeList2);
        employeemain2.setPinCode(456);

        List<Field> fields = Arrays.asList(Employeemain.class.getDeclaredFields());
        Field nameF = Employeemain.class.getDeclaredField("employeeList");
        Class<?> ccc = Class.forName("com.example.demo5.Employeemain");
        Field pinCode = Class.forName("com.example.demo5.Employeemain").getDeclaredField("pinCode");
        Method privateMethod = Employeemain.class.getDeclaredMethod("getPinCode");
        nameF.setAccessible(true);
        //privateMethod.setAccessible(true);
        pinCode.setAccessible(true);
        List<Employee> employeeList444 = (List<Employee>) nameF.get(employeemain2);


        System.out.println("FIELD " + pinCode.getInt(employeemain2));

        pinCode.set(employeemain2, 889);
        System.out.println("FIELD2 " + pinCode.getInt(employeemain2));



        List<Employeemain> employeemainList = new ArrayList<>();
        employeemainList.add(employeemain);
        employeemainList.add(employeemain2);


        int fff = employeemainList.stream().filter(Objects::nonNull)
                .map(Employeemain::getEmployeeList)
                .filter(Objects::nonNull)
                .mapToInt(List::size)
                .sum();

        int fff2 = employeemainList.stream().map(c-> c.getEmployeeList() == null ? 0 : c.getEmployeeList().size()).reduce(0, Integer::sum);

        System.out.println("fff " + fff);
        System.out.println("fff2 " + fff2);

        BigDecimal totalGrossWeightGoodsDelivered = employeemainList.stream().filter(Objects::nonNull)
                                                    .map(Employeemain::getEmployeeList)
                                                    .filter(Objects::nonNull)
                                                    //.flatMap(i->i.stream())
                                                      .flatMap(List::stream)
                                                    .map(Employee::getSum)
                                                    .filter(Objects::nonNull)
                                                    .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("total " + totalGrossWeightGoodsDelivered);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> num = numbers.stream().map(n -> n + 1);
        IntStream nnn = num.mapToInt(i -> i);
        System.out.println("total2 " + nnn.sum());
        List<Integer> increasedNumbers = numbers.stream()
                .map(n -> n + 1).collect(Collectors.toList());


        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

    private LocalDate getExpireDate(String expireDate){
        return expireDate != null ? LocalDate.parse(expireDate, DateTimeFormatter.ISO_LOCAL_DATE) : null;
    }

    public void printList(List<String> printList){

        for(int i = 0; i < printList.size(); i++){
            String item = printList.get(i);
            System.out.println(item);
        }
    }

    public static BigDecimal getRisFee(String text){
        if(!StringUtils.isBlank(text) && text.contains("RIS/")){
            String[] textArray = text.split("RIS/");
            System.out.println("KANA " + textArray.length);
            if(textArray.length >= 2){
                String[] risArray = textArray[1].trim().split(" ");
                System.out.println("KANA2 " + risArray[0]);
                return getNumberFromString(risArray[0]);
            }
        }
        return BigDecimal.ZERO;
    }

    static int factorial(int n) {
        System.out.println("Факториал33333: " + n);
        int result;

        if (n < 2) {
            return 1;
        }
        result = factorial(n - 1) * n;
        System.out.println("Факториал33333555: " + result);
        return result;
    }

    public static BigDecimal getNumberFromString(String str) {
        String numberValue = getNumbersStr(str);
        System.out.println("KANA3 " + numberValue);
        return !StringUtils.isBlank(numberValue) ? formatBigDecimal(numberValue) : BigDecimal.ZERO;
    }

    public static String getNumbersStr(String str) {
        return str.trim().replaceAll("[^\\d.]+", "");
    }
    public static BigDecimal formatBigDecimal(String amount) {
        try {
            return new BigDecimal(amount);
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }

    private class MyProxy implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("HANDLER " + method.getName());
            return null;
        }
    }
}
