题目描述
获取所有部门当前manager的当前薪水情况，给出dept_no, emp_no以及salary，当前表示to_date='9999-01-01'
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

https://www.nowcoder.com/practice/4c8b4a10ca5b44189e411107e1d8bec1?tpId=82&tqId=29761&rp=0&ru=/ta/sql&qru=/ta/sql/question-ranking


select d.dept_no, d.emp_no, s.salary from dept_manager d
inner join  salaries s on d.emp_no = s.emp_no
where s.to_date = '9999-01-01' and d.to_date = '9999-01-01'


同一个人可能在两个部门待过,所以带上d.to_date = '9999-01-01'