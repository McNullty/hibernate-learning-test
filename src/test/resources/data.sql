INSERT INTO post (id, title) VALUES
 (1, 'Post 1')
,(2, 'Post 2')
,(3, 'Post 3')
;

INSERT INTO post_details (post_id, created_on, created_by) VALUES
 (1, CURRENT_DATE, 'Author 1')
,(2, CURRENT_DATE, 'Author 2')
;


INSERT INTO atable(id) VALUES
 (1)
,(2)
,(3)
;

INSERT INTO btable(id, a_table_id) VALUES
 (1, 1)
,(2, 1)
,(3, 1)
,(4, 2)
,(5, 2)
,(6, 3)
;

INSERT INTO ctable(id, b_table_id) VALUES
 (1, 1)
,(2, 1)
,(3, 1)
,(4, 2)
,(5, 2)
,(6, 3)
;