SELECT owner FROM ALL_TABLES WHERE table_name = 'DBESTELLUNG';
SELECT column_name, data_type FROM all_tab_columns WHERE table_name = 'DBESTELLUNG';
SELECT table_name FROM ALL_TABLES WHERE owner in (SELECT owner FROM ALL_TABLES WHERE table_name = 'DBESTELLUNG');
SELECT t.num_rows, table_name FROM all_tables t WHERE t.table_name in (SELECT ta.table_name FROM ALL_TABLES ta WHERE ta.owner = (SELECT tab.owner FROM ALL_TABLES tab WHERE tab.table_name = 'DBESTELLUNG'));
SELECT  a.constraint_name, a.column_name, c.table_name, b.column_name FROM all_cons_columns a JOIN all_cons_columns b ON a.constraint_name = b.constraint_name JOIN all_constraints c ON a.constraint_name = c.constraint_name WHERE c.constraint_type = 'R' AND a.table_name = 'DBESTELLUNG';
