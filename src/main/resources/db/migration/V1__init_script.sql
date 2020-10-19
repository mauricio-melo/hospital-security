CREATE TABLE users(
  idt_user  			        BIGINT AUTO_INCREMENT NOT NULL,
  email 					    VARCHAR(255) NOT NULL,
  password  	                VARCHAR(255) NOT NULL,
  flg_enabled                   TINYINT(1) NOT NULL,
  checker_code  	            VARCHAR(6) NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY user_pk (idt_user),
  UNIQUE (email)
);


CREATE TABLE profile(
  idt_profile			        BIGINT AUTO_INCREMENT NOT NULL,
  description 					VARCHAR(255) NOT NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY profile_pk (idt_profile),
  UNIQUE (description)
);


CREATE TABLE user_profile(
  idt_user_profile			    BIGINT AUTO_INCREMENT NOT NULL,
  idt_user 		                BIGINT NOT NULL,
  idt_profile 					BIGINT NOT NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY user_profile_pk (idt_user_profile),
  CONSTRAINT fk_up_user         FOREIGN KEY (idt_user) REFERENCES users (idt_user),
  CONSTRAINT fk_up_profile      FOREIGN KEY (idt_profile) REFERENCES profile (idt_profile),
  UNIQUE (idt_user, idt_profile)
);


CREATE TABLE specialty(
  idt_specialty			        BIGINT AUTO_INCREMENT NOT NULL,
  title 		                VARCHAR(255) NOT NULL,
  description 					VARCHAR(255) NOT NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY specialty_pk (idt_specialty),
  UNIQUE (title)
);


CREATE TABLE patient(
  idt_patient			        BIGINT AUTO_INCREMENT NOT NULL,
  idt_user 		                BIGINT NOT NULL,
  document 		                VARCHAR(255) NOT NULL,
  name   		                VARCHAR(255) NOT NULL,
  birth_date 	                DATE NOT NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY patient_pk (idt_patient),
  CONSTRAINT fk_pa_user         FOREIGN KEY (idt_user) REFERENCES users (idt_user),
  UNIQUE (document)
);


CREATE TABLE timetable(
  idt_timetable			        BIGINT AUTO_INCREMENT NOT NULL,
  hours   		                TIME NOT NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY timetable_pk (idt_timetable),
  UNIQUE (hours)
);


CREATE TABLE doctor(
  idt_doctor			        BIGINT AUTO_INCREMENT NOT NULL,
  idt_user 		                BIGINT NOT NULL,
  name 		                    VARCHAR(255) NOT NULL,
  crm   		                INT(11) NOT NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY doctor_pk (idt_doctor),
  CONSTRAINT fk_do_user         FOREIGN KEY (idt_user) REFERENCES users (idt_user),
  UNIQUE (idt_user),
  UNIQUE (crm)
);


CREATE TABLE doctor_specialty(
  idt_doctor_specialty			BIGINT AUTO_INCREMENT NOT NULL,
  idt_doctor 		            BIGINT NOT NULL,
  idt_specialty 	    		BIGINT NOT NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY doctor_specialty_pk (idt_doctor_specialty),
  CONSTRAINT fk_ds_doctor       FOREIGN KEY (idt_doctor) REFERENCES doctor (idt_doctor),
  CONSTRAINT fk_ds_specialty    FOREIGN KEY (idt_specialty) REFERENCES specialty (idt_specialty),
  UNIQUE (idt_doctor, idt_specialty)
);


CREATE TABLE schedule(
  idt_schedule			        BIGINT AUTO_INCREMENT NOT NULL,
  idt_specialty 		        BIGINT NOT NULL,
  idt_doctor 					BIGINT NOT NULL,
  idt_patient 					BIGINT NOT NULL,
  idt_timetable					BIGINT NOT NULL,
  date_appointment              DATE NOT NULL,
  dat_creation 	                DATETIME NOT NULL,
  dat_update 	                DATETIME NULL,
  PRIMARY KEY schedule_pk (idt_schedule),
  CONSTRAINT fk_sc_specialty    FOREIGN KEY (idt_specialty) REFERENCES specialty (idt_specialty),
  CONSTRAINT fk_sc_doctor       FOREIGN KEY (idt_doctor) REFERENCES doctor (idt_doctor),
  CONSTRAINT fk_sc_patient      FOREIGN KEY (idt_patient) REFERENCES patient (idt_patient),
  CONSTRAINT fk_sc_timetable    FOREIGN KEY (idt_timetable) REFERENCES timetable (idt_timetable),
  UNIQUE (idt_patient, idt_timetable, date_appointment)
);








