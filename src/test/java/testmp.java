import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ll.mp.bean.Employee;
import com.ll.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testmp {
    private ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper=ioc.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    //≤Â»Î
    public  void demo1(){
        Employee employee=new Employee();
        employee.setName("≤‚ ‘1");
        employee.setEmail("≤‚ ‘1” œ‰");
        //employee.setGender(1);
       // employee.setAge(22);
        //≤Â»ÎµΩ ˝æ›ø‚
        Integer result = employeeMapper.insert(employee);
        System.out.println(result);
    }
    @Test
    public void demo2(){
        Employee employee=new Employee();
        employee.setId(5);
        employee.setName("≤‚ ‘3");
        employee.setEmail("≤‚ ‘3” œ‰");
//        employee.setGender(3);
//        employee.setAge(33);
//        Integer result = employeeMapper.updateById(employee);
        Integer result = employeeMapper.updateAllColumnById(employee);
        System.out.println(result);
    }

    @Test
    public void demo3(){
        Employee employee=new Employee();
        Employee result = employeeMapper.selectById(4);
        System.out.println(result);
    }

    @Test
    public void demo4(){
        Employee employee=new Employee();
        employee.setId(7);
        employee.setName("≤‚ ‘1");
        employee.setAge(11);
        Employee result = employeeMapper.selectOne(employee);
        System.out.println(result);
    }
    @Test
    public void demo5(){
        List<Integer> idList=new ArrayList<>();
        idList.add(4);
        idList.add(5);
        idList.add(6);
        List<Employee> employees = employeeMapper.selectBatchIds(idList);
        System.out.println(employees);
    }
    @Test
    public void demo6(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","Tom");
        map.put("gender",1);
        List<Employee> employees = employeeMapper.selectByMap(map);
        System.out.println(employees);
    }
    @Test
    public void demo7(){
        Integer integer = employeeMapper.deleteById(5);
        System.out.println(integer);
    }
    @Test
    public void demo8(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","≤‚ ‘2");
        map.put("email","≤‚ ‘2” œ‰");
        Integer result = employeeMapper.deleteByMap(map);
        System.out.println(result);
    }

    @Test
    public void demo9(){
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(7);
        Integer result = employeeMapper.deleteBatchIds(list);
        System.out.println(result);
    }
    @Test
    public void demo10(){
        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 2),
                new EntityWrapper<Employee>()
                        .between("age", 18, 50)
                        .eq("gender", 1)
                        .eq("name", "Tom"));
        System.out.println(employees);
    }
    @Test
    public void dome11(){
        List<Employee> employees = employeeMapper.selectList(
                new EntityWrapper<Employee>()
                        .eq("gender", 0)
                        .like("name", "¿œ ¶")
                        //.or()   //SELECT id AS id,`name`,email,gender,age FROM tbl_employee WHERE (gender = ? AND name LIKE ? OR email LIKE ?)
                        .orNew()    //SELECT id AS id,`name`,email,gender,age FROM tbl_employee WHERE (gender = ? AND name LIKE ?) OR (email LIKE ?)
                        .like("email", "a")
        );
        System.out.println(employees);
    }
    @Test
    public void demo12(){
        Employee employee=new Employee();
        employee.setName("–°√˜");
        employee.setEmail("–°√˜@≤‚ ‘” œ‰");
        employee.setGender(1);
        employeeMapper.update(employee,
                new EntityWrapper<Employee>()
                        .eq("name","Tom")
                        .eq("age",22)
        );
    }
    @Test
    public void demo13(){

        employeeMapper.delete(
                Condition.create()
                        .eq("name","Tom")
                        .eq("age",22)
        );
    }

    @Test
    public void testData() throws SQLException {
        DataSource dataSource=ioc.getBean("dataSource",DataSource.class);
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println("aaa:"+connection);
    }
}
