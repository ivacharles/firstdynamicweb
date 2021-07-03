package edu.citytech.cst.s23826271.firstdynamicweb.businessObject;

import com.citytech.basicsecurity.SimpleEncryption;
import com.citytech.basicsecurity.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jbbwebsolutions.helper.EnvironmentUtility;
import com.jbbwebsolutions.helper.FileUtility;

import java.util.function.Function;

public class UserBO {

    private int loginAttempts = 0;
    public final static String studentSecurity = EnvironmentUtility.get("CST_4713_SECURITY");

    private static Function<String, User> mapFunction = e -> {
        Gson gson = new Gson();
        User user = gson.fromJson(e, User.class);
        return user;
    };

    public User getUserInfo(String userID){
        String fileName = studentSecurity + userID + ".json";
        User user = FileUtility.readAFile(fileName, mapFunction);
        return user;
    }

    public boolean isAuthenticated(String userID, String password){

        User user = getUserInfo(userID);

        if(user.isDisabled())
            return false;

        String encryptedPassword = user.getEncryptedPassword();
        boolean status = SimpleEncryption.verifyPassword(password, encryptedPassword);
        if(!status) {
            ++loginAttempts;
            user.setLoginAttempts(loginAttempts);
            if(loginAttempts >= 3)
                user.setDisabled(true);
            updateFile(user);
        }

        return status;
    }

    private void updateFile(User user) {
        String fileName = studentSecurity + user.getUserId() + ".json";
        GsonBuilder builder = new GsonBuilder();
        Gson prettyGson = builder.setPrettyPrinting().create();
        String jasonContent = prettyGson.toJson(prettyGson);
        FileUtility.writeContent(fileName, jasonContent);
    }
}
