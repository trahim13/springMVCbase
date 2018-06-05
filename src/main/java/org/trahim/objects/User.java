package org.trahim.objects;

import javax.validation.constraints.Size;

public class User {
    @Size(min = 6, message = "Имя должно быть не короче 6 символов.")
    private String name;

    @Size(min = 6, max = 10, message = "Пароль должен быть от 6 до 10 символов.")
    private String password;

    private boolean admin;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
