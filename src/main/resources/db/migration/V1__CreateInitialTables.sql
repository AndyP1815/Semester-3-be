-- 01_user.sql
CREATE TABLE _user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    password VARCHAR(255),
    profilePicture VARCHAR(255)
);

-- 03_category.sql
CREATE TABLE _category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(255),
    imageUrl VARCHAR(255)
);

-- 06_chat.sql
CREATE TABLE _chat (
    id INT PRIMARY KEY AUTO_INCREMENT
);

-- 14_work_service.sql
CREATE TABLE work_service (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(255)
);

-- 15_work_service_images.sql
CREATE TABLE work_service_images (
    id INT PRIMARY KEY AUTO_INCREMENT,
    image_url VARCHAR(255),
    work_service_id INT,
    FOREIGN KEY (work_service_id) REFERENCES work_service (id)
);

-- 02_provider.sql
CREATE TABLE _provider (
    id INT PRIMARY KEY AUTO_INCREMENT,
    service_id INT,
    description VARCHAR(255),
    user_id INT,
    FOREIGN KEY (service_id) REFERENCES work_service (id),
    FOREIGN KEY (user_id) REFERENCES _user (id)
);

-- 04_message.sql
CREATE TABLE _message (
    id INT PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(255),
    date DATE,
    chat_id INT,
    FOREIGN KEY (chat_id) REFERENCES _chat (id)
);

-- 05_job.sql
CREATE TABLE _job (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    name VARCHAR(255),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES _user (id)
);

-- 07_notifications.sql
CREATE TABLE _notifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    message VARCHAR(255),
    timeStamp DATE,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES _user (id)
);

-- 08_accept_notifications.sql
CREATE TABLE accept_notifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    acceptance BOOLEAN,
    notifications_id INT,
    FOREIGN KEY (notifications_id) REFERENCES _notifications (id)
);

-- 09_chat_notifications.sql
CREATE TABLE chat_notifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    accept_notifications_id INT,
    chat_id INT,
    FOREIGN KEY (accept_notifications_id) REFERENCES accept_notifications (id),
    FOREIGN KEY (chat_id) REFERENCES _chat (id)
);

-- 10_job_notifications.sql
CREATE TABLE job_notifications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    accept_notifications_id INT,
    job_id INT,
    FOREIGN KEY (job_id) REFERENCES _job (id),
    FOREIGN KEY (accept_notifications_id) REFERENCES accept_notifications (id)
);

-- 11_order.sql
CREATE TABLE _order (
    id INT PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(255),
    user_id INT,
    workProvider_id INT,
    FOREIGN KEY (user_id) REFERENCES _user (id),
    FOREIGN KEY (workProvider_id) REFERENCES _provider (id)
);

-- 12_job_order.sql
CREATE TABLE job_order (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    job_id INT,
    FOREIGN KEY (job_id) REFERENCES _job (id),
    FOREIGN KEY (order_id) REFERENCES _order (id)
);

-- 13_order_notification.sql
CREATE TABLE order_notification (
    id INT PRIMARY KEY AUTO_INCREMENT,
    accept_notifications_id INT,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES _order (id),
    FOREIGN KEY (accept_notifications_id) REFERENCES accept_notifications (id)
);

-- 16_work_service_category.sql
CREATE TABLE work_service_category (
    work_service_id INT,
    category_id INT,
    FOREIGN KEY (work_service_id) REFERENCES work_service (id),
    FOREIGN KEY (category_id) REFERENCES _category (id)
);

-- 17_service_order.sql
CREATE TABLE service_order (
    id INT PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(255),
    work_service_id INT,
    FOREIGN KEY (work_service_id) REFERENCES work_service (id)
);

-- 18_user_chat.sql
CREATE TABLE user_chat (
    user_id INT,
    chat_id INT,
    PRIMARY KEY (user_id, chat_id),
    FOREIGN KEY (user_id) REFERENCES _user (id),
    FOREIGN KEY (chat_id) REFERENCES _chat (id)
);
