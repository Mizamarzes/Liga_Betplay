DROP DATABASE IF EXISTS betplay;
CREATE DATABASE betplay;
USE betplay;

CREATE TABLE IF NOT EXISTS league (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS trainer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    country VARCHAR(100),
    experience INT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS stadium (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(255) NOT NULL,
    capacity INT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS team (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    stadium INT,
    trainer INT,
    league INT,
    CONSTRAINT FK_team_stadium_id FOREIGN KEY (stadium) REFERENCES stadium(id),
    CONSTRAINT FK_team_league_id FOREIGN KEY (league) REFERENCES league(id),
    CONSTRAINT FK_team_trainer_id FOREIGN KEY (trainer) REFERENCES trainer(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS team_award (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    team_id INT,
    award_date DATE,
    CONSTRAINT FK_team_award_team_id FOREIGN KEY (team_id) REFERENCES team(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS type_of_equipment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS equipment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type_id INT,
    quantity INT,
    team_id INT,
    acquisition_date DATE,
    CONSTRAINT FK_equipment_type_id FOREIGN KEY (type_id) REFERENCES type_of_equipment(id),
    CONSTRAINT FK_equipment_team_id FOREIGN KEY (team_id) REFERENCES team(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS team_equipment (
    team_id INT,
    equipment_id INT,
    PRIMARY KEY (team_id, equipment_id),
    CONSTRAINT FK_team_equipment_team_id FOREIGN KEY (team_id) REFERENCES team(id),
    CONSTRAINT FK_team_equipment_equipment_id FOREIGN KEY (equipment_id) REFERENCES equipment(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    nationality VARCHAR(100),
    position VARCHAR(50),
    shirt_number INT,
    team INT,
    CONSTRAINT FK_player_team_id FOREIGN KEY (team) REFERENCES team(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS player_award (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    player_id INT,
    award_date DATE,
    CONSTRAINT FK_player_award_player_id FOREIGN KEY (player_id) REFERENCES player(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS referee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    country VARCHAR(100),
    experience INT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS game (
    id INT AUTO_INCREMENT PRIMARY KEY,
    home_team INT,
    away_team INT,
    date DATE,
    time TIME,
    stadium INT,
    referee INT,
    league INT,
    CONSTRAINT FK_game_home_team_id FOREIGN KEY (home_team) REFERENCES team(id),
    CONSTRAINT FK_game_away_team_id FOREIGN KEY (away_team) REFERENCES team(id),
    CONSTRAINT FK_game_stadium_id FOREIGN KEY (stadium) REFERENCES stadium(id),
    CONSTRAINT FK_game_referee_id FOREIGN KEY (referee) REFERENCES referee(id),
    CONSTRAINT FK_game_league_id FOREIGN KEY (league) REFERENCES league(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS call_up (
    id INT AUTO_INCREMENT PRIMARY KEY,
    game_id INT,
    call_up_date DATE,
    additional_info TEXT,
    CONSTRAINT FK_call_up_game_id FOREIGN KEY (game_id) REFERENCES game(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS call_up_player (
    call_up_id INT,
    player_id INT,
    PRIMARY KEY(call_up_id, player_id),
    CONSTRAINT FK_call_up_player_call_up_id FOREIGN KEY (call_up_id) REFERENCES call_up(id) ON DELETE CASCADE,
    CONSTRAINT FK_call_up_player_player_id FOREIGN KEY (player_id) REFERENCES player(id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS goal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player INT,
    team INT,
    minute INT,
    game INT,
    CONSTRAINT FK_goal_player_id FOREIGN KEY (player) REFERENCES player(id),
    CONSTRAINT FK_goal_team_id FOREIGN KEY (team) REFERENCES team(id),
    CONSTRAINT FK_goal_game_id FOREIGN KEY (game) REFERENCES game(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS card (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player INT,
    game INT,
    type VARCHAR(20),
    minute INT,
    CONSTRAINT FK_card_player_id FOREIGN KEY (player) REFERENCES player(id),
    CONSTRAINT FK_card_game_id FOREIGN KEY (game) REFERENCES game(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS incident (
    id INT AUTO_INCREMENT PRIMARY KEY,
    game INT,
    description TEXT,
    minute INT,
    CONSTRAINT FK_incident_game_id FOREIGN KEY (game) REFERENCES game(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS result (
    id INT AUTO_INCREMENT PRIMARY KEY,
    game INT,
    home_team_goals INT,
    away_team_goals INT,
    CONSTRAINT FK_result_game_id FOREIGN KEY (game) REFERENCES game(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS injury (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player INT,
    type VARCHAR(50),
    severity VARCHAR(50),
    start_date DATE,
    end_date DATE,
    CONSTRAINT FK_injury_player_id FOREIGN KEY (player) REFERENCES player(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS performance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player INT,
    game INT,
    minutes_played INT,
    goals INT,
    assists INT,
    yellow_cards INT,
    red_cards INT,
    CONSTRAINT FK_performance_player_id FOREIGN KEY (player) REFERENCES player(id),
    CONSTRAINT FK_performance_game_id FOREIGN KEY (game) REFERENCES game(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS activity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT,
    duration INT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS training (
    id INT AUTO_INCREMENT PRIMARY KEY,
    team INT,
    date DATE,
    time TIME,
    location VARCHAR(255),
    activity INT, 
    CONSTRAINT FK_training_team_id FOREIGN KEY (team) REFERENCES team(id),
    CONSTRAINT FK_training_activity_id FOREIGN KEY (activity) REFERENCES activity(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS training_player (
    training_id INT,
    player_id INT,
    PRIMARY KEY (training_id, player_id),
    CONSTRAINT FK_training_player_training_id FOREIGN KEY (training_id) REFERENCES training(id),
    CONSTRAINT FK_training_player_player_id FOREIGN KEY (player_id) REFERENCES player(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS transfer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player INT,
    origin_team INT,
    destination_team INT,
    amount DECIMAL(10, 2),
    date DATE,
    CONSTRAINT FK_transfer_player_id FOREIGN KEY (player) REFERENCES player(id),
    CONSTRAINT FK_transfer_origin_team_id FOREIGN KEY (origin_team) REFERENCES team(id),
    CONSTRAINT FK_transfer_destination_team_id FOREIGN KEY (destination_team) REFERENCES team(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS permission (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    permission INT,
    CONSTRAINT FK_role_permission_id FOREIGN KEY (permission) REFERENCES permission(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role INT,
    CONSTRAINT FK_user_role_id FOREIGN KEY (role) REFERENCES role(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS sponsor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    amount DECIMAL(10, 2),
    start_date DATE,
    end_date DATE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS team_sponsor (
    team_id INT,
    sponsor_id INT,
    PRIMARY KEY (team_id, sponsor_id),
    CONSTRAINT FK_team_sponsor_team_id FOREIGN KEY (team_id) REFERENCES team(id),
    CONSTRAINT FK_team_sponsor_sponsor_id FOREIGN KEY (sponsor_id) REFERENCES sponsor(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS league_sponsor (
    league_id INT,
    sponsor_id INT,
    PRIMARY KEY (league_id, sponsor_id),
    CONSTRAINT FK_league_sponsor_league_id FOREIGN KEY (league_id) REFERENCES league(id),
    CONSTRAINT FK_league_sponsor_sponsor_id FOREIGN KEY (sponsor_id) REFERENCES sponsor(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS communication (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    publish_date DATE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS user_communication (
    user_id INT,
    communication_id INT,
    PRIMARY KEY (user_id, communication_id),
    CONSTRAINT FK_user_communication_user_id FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT FK_user_communication_communication_id FOREIGN KEY (communication_id) REFERENCES communication(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    game INT,
    buyer INT,
    purchase_date DATE,
    quantity INT,
    total_price DECIMAL(10, 2),
    location VARCHAR(100),
    CONSTRAINT FK_ticket_game_id FOREIGN KEY (game) REFERENCES game(id),
    CONSTRAINT FK_ticket_buyer_id FOREIGN KEY (buyer) REFERENCES user(id)
) ENGINE=InnoDB;

-- ############################## DEFAULT DATA ##################################Ç

INSERT INTO permission (id, description) VALUES 
        (1, 'Administrator Perms'), 
        (2, 'TechTeam Perms'), 
        (3, 'Referee Perms'), 
        (4, 'TeamDoctor Perms'), 
        (5, 'Journalist Perms'), 
        (6, 'Fan Perms'),
        (7, 'Super Admin Perms');

INSERT INTO role (id, name, permission) VALUES 
        (1, 'League Admin', 1),
        (2, 'Technical Team', 2),
        (3, 'Referee', 3),
        (4, 'Team Doctor', 4),
        (5, 'Journalist', 5),
        (6, 'Fan', 6),
        (7, 'Super Admin', 7);

INSERT INTO user (id, name, email, password, role) VALUES  
        (1, 'santilaguado', 'santi@gmail.com', 'santi123', 7),  
        (2, 'mizamarzes', 'mizamarzes@gmail.com', 'mizamarzes123', 7);

INSERT INTO stadium (id, name, location, capacity) VALUES
        (1, 'Estado Americo Montanini', 'Bucaramanga', 28000);

INSERT INTO league (id, name, country) VALUES
        (1, 'Liga BetPlay Colombia', 'Colombia');

INSERT INTO trainer (id, name, age, country, experience) VALUES
        (1, 'Carlos', 45, 'Colombia', 10);

INSERT INTO team (id, name, city, stadium, trainer, league) VALUES
        (1, 'Atletico Bucaramanga', 'Bucaramanga', 1, 1, 1);

-- Finish