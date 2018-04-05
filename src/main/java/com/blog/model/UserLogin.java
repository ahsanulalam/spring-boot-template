package com.blog.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Ahsan on 3/28/2018.
 */
@Entity
@Table(name = "user_login", schema = "dbo", catalog = "ahsan")
public class UserLogin {
    private Integer userId;
    private String userName;
    private Boolean emailConfirmation;
    private String status;
    private String password;
    private Boolean resetPassword;
    private String resetCode;
    private Date registrationDate;
    private UserType userTypeByUserTypeId;

    @Id
    @Column(name = "userId", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String emailId) {
        this.userName = emailId;
    }

    @Basic
    @Column(name = "emailConfirmation", nullable = false)
    public Boolean getEmailConfirmation() {
        return emailConfirmation;
    }

    public void setEmailConfirmation(Boolean emailConfirmation) {
        this.emailConfirmation = emailConfirmation;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 500)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "resetPassword", nullable = false)
    public Boolean getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(Boolean resetPassword) {
        this.resetPassword = resetPassword;
    }

    @Basic
    @Column(name = "resetCode", nullable = false, length = 10)
    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    @Basic
    @Column(name = "registrationDate", nullable = false)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLogin userLogin = (UserLogin) o;

        if (userId != null ? !userId.equals(userLogin.userId) : userLogin.userId != null) return false;
        if (userName != null ? !userName.equals(userLogin.userName) : userLogin.userName != null) return false;
        if (emailConfirmation != null ? !emailConfirmation.equals(userLogin.emailConfirmation) : userLogin.emailConfirmation != null)
            return false;
        if (status != null ? !status.equals(userLogin.status) : userLogin.status != null) return false;
        if (password != null ? !password.equals(userLogin.password) : userLogin.password != null) return false;
        if (resetPassword != null ? !resetPassword.equals(userLogin.resetPassword) : userLogin.resetPassword != null)
            return false;
        if (resetCode != null ? !resetCode.equals(userLogin.resetCode) : userLogin.resetCode != null) return false;
        if (registrationDate != null ? !registrationDate.equals(userLogin.registrationDate) : userLogin.registrationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (emailConfirmation != null ? emailConfirmation.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (resetPassword != null ? resetPassword.hashCode() : 0);
        result = 31 * result + (resetCode != null ? resetCode.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId", nullable = false)
    public UserType getUserTypeByUserTypeId() {
        return userTypeByUserTypeId;
    }

    public void setUserTypeByUserTypeId(UserType userTypeByUserTypeId) {
        this.userTypeByUserTypeId = userTypeByUserTypeId;
    }
}
