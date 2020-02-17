题目描述
查找各个部门当前(to_date='9999-01-01')领导当前薪水详情以及其对应部门编号dept_no
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

https://www.nowcoder.com/practice/c63c5b54d86e4c6d880e4834bfd70c3b?tpId=82&tqId=29755&tPage=1&rp=&ru=%2Fta%2Fsql&qru=%2Fta%2Fsql%2Fquestion-ranking


select d.dept_no, s.* from dept_manager d
inner join salaries s on d.emp_no = s.emp_no
where s.to_date = '9999-01-01'
and d.to_date = '9999-01-01'

两个表的时间都要做限制,通过的条件必须是s表为主表?讨论中也没说清楚

select d.dept_no, s.* from salaries s
inner join dept_manager d on d.emp_no = s.emp_no
where s.to_date = '9999-01-01'
and d.to_date = '9999-01-01'

通过的代码居然是换了d.dept_no, s.*位置
select  s.*, d.dept_no from salaries s
inner join dept_manager d on d.emp_no = s.emp_no
where s.to_date = '9999-01-01'
and d.to_date = '9999-01-01'