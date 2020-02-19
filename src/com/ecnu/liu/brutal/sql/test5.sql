题目描述
查找所有员工的last_name和first_name以及对应部门编号dept_no，也包括展示没有分配具体部门的员工
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

https://www.nowcoder.com/practice/dbfafafb2ee2482aa390645abd4463bf?tpId=82&tqId=29757&rp=0&ru=/ta/sql&qru=/ta/sql/question-ranking

select e.last_name, e.first_name, d.dept_no from employees e
left join dept_emp d on d.emp_no = e.emp_no