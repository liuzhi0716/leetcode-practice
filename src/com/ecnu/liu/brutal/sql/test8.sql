找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));


https://www.nowcoder.com/practice/ae51e6d057c94f6d891735a48d1c2397?tpId=82&tqId=29760&rp=0&ru=/ta/sql&qru=/ta/sql/question-ranking

select distinct(salary) from  salaries where to_date = '9999-01-01' order by salary desc