package constants;

public class SafeDecSqlConstants {

    public static final String GET_USER = "Select * from users where email = ? and password = ?";

    public static final String GET_USER_DETAILS = "Select name, phoneNumber, emergencyContact1, emergencyContact2, masterCode, userId, email, address FROM users WHERE email = ?";

    public static final String INSERT_NEW_USER_DETAILS = "Insert into users(name, email, password, phoneNumber, emergencyContact1, emergencyContact2, masterCode, address) values(?, ?, ?, ?, ?, ?, ?, ?)";
}


// Database : MySQL

// Table Structure:
//
//  CREATE TABLE `users` (
//    `userID` int NOT NULL AUTO_INCREMENT,
//    `name` varchar(45) NOT NULL,
//    `email` varchar(45) NOT NULL,
//    `password` varchar(45) NOT NULL,
//    `phoneNumber` varchar(45) DEFAULT NULL,
//    `emergencyContact1` varchar(45) DEFAULT NULL,
//    `emergencyContact2` varchar(45) DEFAULT NULL,
//    `masterCode` varchar(45) DEFAULT NULL,
//    `address` varchar(100) DEFAULT NULL,
//    PRIMARY KEY (`userID`)
//  ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

