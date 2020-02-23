查找所有已经分配部门的员工的last_name和first_name以及dept_no
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

题目:https://www.nowcoder.com/practice/6d35b1cd593545ab985a68cd86f28671?tpId=82&tqId=29756&tPage=1&rp=&ru=/ta/sql&qru=/ta/sql/question-ranking

错解:
select e.last_name, e.first_name, d.dept_no from employees e
left join dept_emp d on d.emp_no = e.emp_no

区别可参考:https://blog.csdn.net/weixin_33738555/article/details/91689609
正解:
select e.last_name, e.first_name, d.dept_no from employees e
 join dept_emp d on d.emp_no = e.emp_no
或(应该是等同的)
select e.last_name, e.first_name, d.dept_no from employees e, dept_emp d
where d.emp_no = e.emp_no