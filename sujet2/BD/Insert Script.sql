/**CREATION DE MEMBRES**/
INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
	VALUES ('Jmmartinezro@gmail.com', 'Jmmr', '1234567', true, CURRENT_DATE, 'Martinez', 'Juan', CURRENT_DATE, 'Colombie', 'M', 'Student', false);
INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
	VALUES ('jeanaymard@gmail.com', 'jeanaymard', '1234567', true, '2014-12-01', 'Aymard', 'Jean', '1990-10-10', 'France', 'M', 'Jobless', false);
INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
	VALUES ('mrcchambon@gmail.com', 'chambonm', '1234567', true, '2014-12-18', 'Chambon', 'Marc', '1982-03-26', 'France', 'M', 'Chemist', false);
INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
	VALUES ('marypoppins@gmail.com', 'mary', '1234567', true, '2012-12-12', 'Poppins', 'Mary', '1870-11-9', 'France', 'F', 'Actress', false);
INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
VALUES ('toto@gmail.com', 'toto', '1234567', false, '2012-12-14', 'toto', 'titi', '1999-11-9', 'France', 'F', 'Teacher', false);

/**CREATION DE CATEGORIES**/
INSERT INTO sujet2.ProjectCategory(categoryName, categoryDescription)
VALUES ('logiciel','plateforme windows');
INSERT INTO sujet2.ProjectCategory(categoryName, categoryDescription)
VALUES ('application','Version iphone et android');
INSERT INTO sujet2.ProjectCategory(categoryName, categoryDescription)
VALUES ('web','Connu de tous');
INSERT INTO sujet2.ProjectCategory(categoryName, categoryDescription)
VALUES ('mobile','Trés utilisé aujourdhui');

/**CREATION DE PROJETS**/
INSERT INTO sujet2.Project(projectTitle,projectFundingGoal,projectCreationDate,
projectEndDate,projectDescription,projectCategory,projectIsSuppressed,projectIsClosed)
VALUES ('TitreExemple',10,'2014-10-09','2015-05-14','descriptionExemple',1,0,1);
INSERT INTO sujet2.Project(projectTitle,projectFundingGoal,projectCreationDate,
projectEndDate,projectDescription,projectCategory,projectIsSuppressed,projectIsClosed)
VALUES ('TitreExemple2',10,'2014-08-09','2015-06-07','descriptionExemple2',2,1,0);
INSERT INTO sujet2.Project(projectTitle,projectFundingGoal,projectCreationDate,
projectEndDate,projectDescription,projectCategory,projectIsSuppressed,projectIsClosed)
VALUES ('TitreExemple3',10,'2014-05-14','2015-11-29','descriptionExemple3',3,0,0);
INSERT INTO sujet2. Project(projectTitle,projectFundingGoal,projectCreationDate,
projectEndDate,projectDescription,projectCategory,projectIsSuppressed,projectIsClosed)
VALUES ('TitreExemple4',10,'2014-01-19','2015-03-04','descriptionExemple4',4,0,0);
INSERT INTO sujet2.Project(projectTitle,projectFundingGoal,projectCreationDate,
projectEndDate,projectDescription,projectCategory,projectIsSuppressed,projectIsClosed)
VALUES ('Compilateur',10,'2013-01-19','2015-06-04','langage c++ avec architecture ...',1,1,0);

/**CREATION DE REWARDS**/
INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice,project_ProjectId)
VALUES ('affiche','descriptionAffiche',45,1);
INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice,project_ProjectId)
VALUES ('carton','descriptionCarton',89,2);
INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice,project_ProjectId)
VALUES ('flye1r','descriptionFlyer',142,3);
INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice,project_ProjectId)
VALUES ('flyer2','descriptionFlyer',142,4);
INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice,project_ProjectId)
VALUES ('flyer3','descriptionFlyer',142,5);
INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice,project_ProjectId)
VALUES ('flyer5','descriptionFlyer',142,3);
INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice,project_ProjectId)
VALUES ('flyer5','descriptionFlyer',142,1);

INSERT INTO sujet2.Member_creates_Project(creatorId,projectId) VALUES (1,1);
INSERT INTO sujet2.Member_backs_Project(backerId,projectId,pledgedEuros,backingDate,Reward_rewardId)
VALUES (2,1,387,'2013-11-12',1 );

INSERT INTO sujet2.Member_creates_Project(creatorId,projectId) VALUES (1,2);
INSERT INTO sujet2.Member_backs_Project(backerId,projectId,pledgedEuros,backingDate,Reward_rewardId)
VALUES (4,2,455,'2015-12-25',2);

INSERT INTO sujet2.Member_creates_Project(creatorId,projectId) VALUES (4,3);
INSERT INTO sujet2.Member_backs_Project(backerId,projectId,pledgedEuros,backingDate,Reward_rewardId)
VALUES (5,3,64,'2015-02-27',3);

INSERT INTO sujet2.Member_creates_Project(creatorId,projectId) VALUES (4,4);
INSERT INTO sujet2.Member_backs_Project(backerId,projectId,pledgedEuros,backingDate,Reward_rewardId)
VALUES (5,4,64,'2015-02-27',3);

