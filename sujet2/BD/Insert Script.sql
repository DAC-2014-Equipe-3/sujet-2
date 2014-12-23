INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
	VALUES ('Jmmartinezro@gmail.com', 'Jmmr', '1234', true, CURRENT_DATE, 'Martinez', 'Juan', CURRENT_DATE, 'Colombia', 'Male', 'Student', false);
INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
	VALUES ('jeanaymard@gmail.com', 'jeanaymard', 'test', true, '2014-12-01', 'Aymard', 'Jean', '1990-10-10', 'France', 'Male', 'Jobless', false);
INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
	VALUES ('mrcchambon@gmail.com', 'chambonm', 'bobby', true, '2014-12-18', 'Chambon', 'Marc', '1982-03-26', 'France', 'Male', 'Chemist', false);
INSERT INTO sujet2.Member (memberEmail, memberLogin, memberPassword, memberIsAdmin, memberJoiningDate, memberLastname, memberFirstname, memberBirthday, memberNationality, memberSex, memberProfession, memberIsSuppressed)
	VALUES ('marypoppins@gmail.com', 'mary', '', true, '2012-12-12', 'Poppins', 'Mary', '1870-11-9', 'France', 'Female', 'Actress', false);

INSERT INTO sujet2.ProjectCategory(categoryName, categoryDescription)
    VALUES ('logiciel','descriptionCategorieLogiciel');
INSERT INTO sujet2.ProjectCategory(categoryName, categoryDescription)
VALUES ('application','descriptionCategorieApplication');

INSERT INTO sujet2.Project(projectTitle,projectFundingGoal,projectCreationDate,
                    projectEndDate,projectDescription,projectCategory)
VALUES ('TitreExemple',10,'2014-10-09','2015-05-14','descriptionExemple',1);
INSERT INTO sujet2.Member_creates_Project(creatorId,projectId) VALUES (1,1);
INSERT INTO sujet2.Member_backs_Project(backerId,projectId,pledgedEuros,backingDate,Reward_rewardId)
VALUES (2,1,387,'2013-11-12',1);

INSERT INTO sujet2. Project(projectTitle,projectFundingGoal,projectCreationDate,
                    projectEndDate,projectDescription,projectCategory)
VALUES ('TitreExemple2',10,'2014-08-09','2015-06-07','descriptionExemple2',2);
INSERT INTO sujet2.Member_creates_Project(creatorId,projectId) VALUES (3,2);
INSERT INTO sujet2.Member_backs_Project(backerId,projectId,pledgedEuros,backingDate,Reward_rewardId)
VALUES (4,2,455,'2015-12-25',2);

INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice)
VALUES ('affiche','descriptionAffiche',45);
INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice)
VALUES ('carton','descriptionCarton',89);
/*UPDATE sujet2.Member_backs_Project SET Reward_rewardId=1 WHere projectId=1 ;
UPDATE sujet2.Member_backs_Project SET Reward_rewardId=2 WHere projectId=2 ;*/