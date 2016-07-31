/*
SQLyog Community v9.51 
MySQL - 5.1.54-community : Database - car_sales
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`car_sales` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `car_sales`;

/*Table structure for table `tbl_car` */

DROP TABLE IF EXISTS `tbl_car`;

CREATE TABLE `tbl_car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `make` varchar(20) DEFAULT NULL,
  `model` varchar(20) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `location` varchar(30) DEFAULT NULL,
  `year` varchar(10) DEFAULT NULL,
  `kilometers` varchar(20) DEFAULT NULL,
  `interior_color` varchar(20) DEFAULT NULL,
  `transmission` varchar(50) DEFAULT NULL,
  `body` varchar(20) DEFAULT NULL,
  `interior_design` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_car` */

insert  into `tbl_car`(`car_id`,`make`,`model`,`color`,`price`,`location`,`year`,`kilometers`,`interior_color`,`transmission`,`body`,`interior_design`) values (1,'Audi','Q3','White',80000,'Delhi','2015','83,321','Black','7 speed Sports Automatic Dual ','5 doors 5 seat SUV',NULL),(2,'BMW','Z4','Black',90000,'Noida','2014','83,321','White','7 speed Sports Automatic Dual ','5 doors 5 seat SUV',NULL),(3,'Ford','Figo','Silver',50000,'Pune','2013','83,321','Blue','7 speed Sports Automatic Dual ','5 doors 5 seat SUV',NULL),(4,'Honda','CRX','Black',45000,'Bangalore','2014','83,321','Black','7 speed Sports Automatic Dual ','5 doors 5 seat SUV',NULL);

/*Table structure for table `tbl_customer` */

DROP TABLE IF EXISTS `tbl_customer`;

CREATE TABLE `tbl_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `email_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_customer` */

insert  into `tbl_customer`(`customer_id`,`name`,`phone_number`,`email_id`) values (2,'Asif Iqbal','08447441789','asifiqbalspn@gmail.com'),(3,'Asif Iqbal','08447441789','asifiqbalspn@gmail.com'),(4,'Amir','88888888','amir@abc.com'),(5,'Farha','818181818','Farha@xyz.com'),(6,'Asif Iqbal','08447441789','asifiqbalspn@gmail.com'),(7,'','',''),(8,'','',''),(9,'','',''),(10,'','',''),(11,'','',''),(12,'','',''),(13,'','',''),(14,'Asif Iqbal','08447441789','asifiqbalspn@gmail.com');

/*Table structure for table `tbl_enquiry` */

DROP TABLE IF EXISTS `tbl_enquiry`;

CREATE TABLE `tbl_enquiry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL,
  KEY `id` (`id`),
  KEY `fk_enquiry_car` (`car_id`),
  KEY `fk_enquiry_customer` (`customer_id`),
  CONSTRAINT `fk_enquiry_customer` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`customer_id`),
  CONSTRAINT `fk_enquiry_car` FOREIGN KEY (`car_id`) REFERENCES `tbl_car` (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_enquiry` */

insert  into `tbl_enquiry`(`id`,`car_id`,`customer_id`,`message`) values (1,3,2,'Enquiry about this car.'),(2,4,3,'Enquiry'),(3,4,4,'amamama'),(4,4,5,'anananna'),(5,1,6,'ababa'),(6,4,7,''),(7,4,8,''),(8,4,9,''),(9,4,10,''),(10,4,11,''),(11,4,12,''),(12,3,13,''),(13,4,14,'aaaa');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
