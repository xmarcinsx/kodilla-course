CREATE TABLE ISSUESLISTS
(
  ID   SERIAL PRIMARY KEY,
  NAME VARCHAR(100) CHARSET UTF8 NOT NULL UNIQUE
);

CREATE TABLE ISSUES
(
  ID                  SERIAL PRIMARY KEY,
  ISSUESLIST_ID  	    BIGINT UNSIGNED NOT NULL,
  SUMMARY        	    VARCHAR(10000) CHARSET UTF8,
  DESCRIPTION    	    VARCHAR(10000) CHARSET UTF8,
  USER_ID_ASSIGNEDTO  BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (ISSUESLIST_ID) REFERENCES ISSUESLISTS(ID),
  FOREIGN KEY (USER_ID_ASSIGNEDTO) REFERENCES USERS(ID)
);

INSERT INTO ISSUELIST (NAME)
    VALUES ("ToDo");
INSERT INTO ISSUELIST (NAME)
    VALUES ("In progress");
INSERT INTO ISSUELIST (NAME)
    VALUES ("Done");
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (1, "summary of 1 task to do" , "description of 1 task to do", 1);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (1, "summary of 2 task to do" , "description of 2 task to do", 2);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (1, "summary of 3 task to do" , "description of 3 task to do", 4);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (1, "summary of 4 task to do" , "description of 4 task to do", 3);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (1, "summary of 5 task to do" , "description of 5 task to do", 2);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (2, "summary of 1 task in progress" , "description of 1 task in progress", 1);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (2, "summary of 2 task in progress" , "description of 2 task in progress", 2);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (2, "summary of 3 task in progress" , "description of 3 task in progress", 4);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (2, "summary of 4 task in progress" , "description of 4 task in progress", 4);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (2, "summary of 5 task in progress" , "description of 5 task in progress", 3);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (3, "summary of 1 task done" , "description of 1 task in done", 1);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (3, "summary of 2 task done" , "description of 2 task in done", 3);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (3, "summary of 3 task done" , "description of 3 task in done", 4);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (3, "summary of 4 task done" , "description of 4 task in done", 2);
INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION,  USER_ID_ASSIGNEDTO )
    VALUES (3, "summary of 5 task done" , "description of 5 task in done", 2);

COMMIT;