获取所有员工当前的manager，如果当前的manager是自己的话结果不显示，当前表示to_date='9999-01-01'。
结果第一列给出当前员工的emp_no,第二列给出其manager对应的manager_no。
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));


https://www.nowcoder.com/practice/e50d92b8673a440ebdf3a517b5b37d62?tpId=82&tqId=29763&rp=0&ru=/ta/sql&qru=/ta/sql/question-ranking

select e.emp_no, m.emp_no as manager_no from dept_emp e
inner join dept_manager m on e.dept_no = m.dept_no
where e.emp_no not in (
  select emp_no from dept_manager
)
and e.to_date = '9999-01-01'
and m.to_date = '9999-01-01'




参考简便解答：

select de.emp_no, dm.emp_no
from dept_emp as de left join dept_manager as dm
on de.dept_no = dm.dept_no
where de.to_date = '9999-01-01' and dm.to_date = '9999-01-01' and de.emp_no <> dm.emp_no
order by de.emp_no;