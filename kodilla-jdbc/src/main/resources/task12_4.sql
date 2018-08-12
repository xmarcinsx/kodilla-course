SELECT L.NAME, I.SUMMARY, I.DESCRIPTION
    FROM ISSUESLISTS L, ISSUES I
    WHERE L.ID = I.ISSUESLIST_ID;

SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY, I.DESCRIPTION
    FROM USERS U, ISSUES I
    WHERE U.ID = I.USER_ID_ASSIGNEDTO;

SELECT U.ID, U.FIRSTNAME, U.LASTNAME, COUNT(I.ID) AS TASKS_NUMBER
    FROM USERS U, ISSUES I
    WHERE U.ID = I.USER_ID_ASSIGNEDTO
    GROUP BY U.ID
    HAVING COUNT(I.ID) > 0;