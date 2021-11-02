import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ll.mp.bean.Employee;
import com.ll.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ArTest {
    private ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper=ioc.getBean("employeeMapper",EmployeeMapper.class);

    /*
    * AR ≤Â»Î≤Ÿ◊˜
    * */
    @Test
    public void demo1(){
        Employee employee = new Employee();
        employee.setName("≤‚ ‘1");
        employee.setEmail("1@≤‚ ‘” œ‰");
        employee.setGender(1);
        employee.setAge(35);

        boolean result = employee.insert();
        System.out.println(result);
    }
    @Test
    public void demo2(){
        Employee employee = new Employee();
        employee.setId(6);
        employee.setName("–ﬁ∏ƒ1");
        employee.setEmail("1@–ﬁ∏ƒ” œ‰");
        employee.setGender(1);
        employee.setAge(35);

        boolean result = employee.updateById();
        System.out.println(result);
    }
    @Test
    public void demo3(){
        Employee employee =new Employee();
        Employee employee1 = employee.selectById(6);
        System.out.println(employee1);
    }
    @Test
    public void demo4(){
        Employee employee =new Employee();
        List<Employee> employees = employee.selectAll();
        System.out.println(employees);
    }
    @Test
    public void demo5(){
        Employee employee =new Employee();
        List<Employee> employees = employee.selectList(
                new EntityWrapper<Employee>()
                        .like("name","a")
        );
        System.out.println(employees);
        //≤È—Ø ˝¡ø
        int count = employee.selectCount(
                new EntityWrapper<Employee>()
                        .eq("gender", 0)
        );
        System.out.println(count);
    }
    @Test
    public void demo6(){
        Employee employee =new Employee();
        employee.setId(6);
        boolean employees = employee.deleteById();
        System.out.println(employees);
    }
}
