INSERT INTO post (id, title) VALUES
 (1, 'Post 1')
,(2, 'Post 2')
;

INSERT INTO post_details (post_id, created_on, created_by) VALUES
 (1, CURRENT_DATE, 'Author 1')
,(2, CURRENT_DATE, 'Author 2')
;
