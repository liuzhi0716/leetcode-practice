题目描述
查找薪水涨幅超过15次的员工号emp_no以及其对应的涨幅次数t
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));


https://www.nowcoder.com/practice/6d4a4cff1d58495182f536c548fee1ae?tpId=82&tqId=29759&rp=0&ru=/ta/sql&qru=/ta/sql/question-ranking

select i.emp_no, i.t from (
  select emp_no, count(1) as t from salaries group by emp_no
)i
where t > 15