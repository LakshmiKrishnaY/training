DELIMITER //

CREATE PROCEDURE GetAllEmployees()
BEGIN
	SELECT *  FROM emp;
END //

DELIMITER ;