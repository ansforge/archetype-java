
SET MODE PostgreSQL;

-- to import SQL,  the SQL command must on ONE line

-- PERSONNE
INSERT INTO CPSSG.PERSONNE (ID_PERSONNE,ID_RPPS,NOM_PATRONYMIQUE,PRENOM_A,PRENOM_B,PRENOM_C,DATE_NAISSANCE,ANONYME,PORTEUR_CARTE_TEST,TSTAMP) VALUES (226,NULL,'VANKENHOVE','ALICE','JEANNE',NULL,NULL,NULL,NULL,NULL),(2815,NULL,'PHILIPPIDES','CHRISTINE',NULL,NULL,NULL,NULL,NULL,NULL),(4289,'10001568806','TIROUVANZIAM','THERESE','FATIMA',NULL,TIMESTAMP '1950-08-13 00:00:00.000000','0',NULL,TIMESTAMP '2011-06-23 07:35:40.248000'),(8739,'10002655230','BESCOND','HERVE',NULL,NULL,TIMESTAMP '1950-05-29 00:00:00.000000','0',NULL,TIMESTAMP '2011-12-24 09:06:43.747000'),(12163,NULL,'VIEHE','JOCELYNE',NULL,NULL,NULL,NULL,NULL,NULL);
