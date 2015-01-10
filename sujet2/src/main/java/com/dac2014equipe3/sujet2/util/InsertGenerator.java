package com.dac2014equipe3.sujet2.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Created by Monssef on 10/01/15.
 */
public class InsertGenerator {
    public static void generateInserts() {
        String query = "";
        Random r = new Random();
        int low = -1;
        int high = -1 ;
        int nbRandom = 0;

        query+="/**CREATION DES MEMBRES**/\n\n";

        for(int i = 1; i <= 20 ; i++){
            query += "INSERT INTO `sujet2`.`Member` (`memberId`, `memberEmail`, `memberLogin`, `memberPassword`, `memberIsAdmin`, "
                    + "`memberJoiningDate`, `memberLastname`, `memberFirstname`, `memberBirthday`, `memberNationality`, `memberAddress`, `memberSex`, "
                    + "`memberProfession`, `memberIsSuppressed`) VALUES ('"+i+"', 'user"+i+"@gmail.com', 'user"+i+"', '123456', '0', '2015-01-10', "
                    + "'TEST', 'User"+i+"', '1991-01-01', 'Française', 'Grenoble', 'M', 'Etudiant', '0');\n";
        }

        for(int i = 21; i <= 12 ; i++){
            query += "INSERT INTO `sujet2`.`Member` (`memberId`, `memberEmail`, `memberLogin`, `memberPassword`, `memberIsAdmin`, "
                    + "`memberJoiningDate`, `memberLastname`, `memberFirstname`, `memberBirthday`, `memberNationality`, `memberAddress`, `memberSex`, "
                    + "`memberProfession`, `memberIsSuppressed`) VALUES ('"+i+"', 'user"+i+"@gmail.com', 'user"+i+"', '123456', '1', '2015-01-10', "
                    + "'TEST', 'User"+i+"', '1991-01-01', 'Française', 'Grenoble', 'M', 'Etudiant', '0');\n";
        }

        query+="\n/**CREATION DES CATEGORIES**/\n\n";

        for(int i = 1; i <= 5 ; i++){
            query += "INSERT INTO sujet2.ProjectCategory(categoryName, categoryDescription) VALUES ('Categorie "+i+"','Description de la catégorie "+i+"');\n";
        }


        query+="\n/**CREATION DES PROJETS**/\n\n";

        low = 1;
        high = 5;

        for (int i = 1; i <= 20; i++) {
            nbRandom = r.nextInt(high-low) + low;
            query += "INSERT INTO sujet2.Project(projectTitle, projectFundingGoal, projectCreationDate, projectEndDate,projectDescription,projectCategory,projectIsSuppressed) "
                    + "VALUES ('Titre du projet "+i+"',"+100*i+",'2015-01-01','2015-12-12','Description du projet "+i+"',"+nbRandom+",0);\n";
        }

        query+="\n/**CREATION DES REWARDS**/\n\n";

        low = 1;
        high = 20;
        for (int i = 0; i <= 30; i++) {
            nbRandom = r.nextInt(high-low) + low;
            query += "INSERT INTO sujet2.Reward(rewardName, rewardDescription, rewardMinPrice,project_ProjectId) VALUES ('Reward "+i+"','Description du reward "+i+"',"+(i+1)*10+","+nbRandom+");\n";
        }

        query+="\n/**CREATION DES MEDIAS**/\n\n";

        low = 1;
        high = 20;
        for (int i = 1; i <= 30; i++) {
            nbRandom = r.nextInt(high-low) + low;
            query += "INSERT INTO `sujet2`.`Media` (`mediaId`, `mediaURL`, `mediaName`, `mediaDescription`, `Project_projectId`) VALUES ('"+i+"', 'www.google.fr', 'Nom du media', 'Description du media', '"+nbRandom+"');\n";
        }

        query+="\n/**CREATION DES MEMBERS CREATES PROJECT**/\n\n";

        int projectMember = 1;
        for (int i = 1; i <= 20; i++) {
            query += "INSERT INTO sujet2.Member_creates_Project(creatorId,projectId) VALUES ("+projectMember+","+i+");\n";
            i++;
            query += "INSERT INTO sujet2.Member_creates_Project(creatorId,projectId) VALUES ("+projectMember+","+i+");\n";
            projectMember++;;
        }

        query+="\n/**CREATION DES MEMBERS BACKS PROJECT**/\n\n";

        int projectBacker = 11;
        for (int i = 1; i <= 20; i++) {
            query += "INSERT INTO sujet2.Member_backs_Project(backerId,projectId,pledgedEuros,backingDate,Reward_rewardId) VALUES ("+projectBacker+","+i+","+(i+1)*10+",'2015-02-01',"+i+" );\n";
            i++;
            query += "INSERT INTO sujet2.Member_backs_Project(backerId,projectId,pledgedEuros,backingDate,Reward_rewardId) VALUES ("+projectBacker+","+i+","+(i+1)*10+",'2015-02-01',"+i+" );\n";
            projectBacker++;
        }

        Path source = Paths.get("insertScriptV2.sql");
        try {
            OutputStream output = Files.newOutputStream(source);
            PrintWriter pw = new PrintWriter(output);
            pw.println(query);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
