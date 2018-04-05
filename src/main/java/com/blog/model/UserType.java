package com.blog.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Ahsan on 3/28/2018.
 */
@Entity
@Table(name = "user_type", schema = "dbo", catalog = "ahsan")
public class UserType {
    private Integer userTypeId;
    private String type;
    private Collection<UserLogin> userLoginsByUserTypeId;

    @Id
    @Column(name = "userTypeId", nullable = false)
    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserType userType = (UserType) o;

        if (userTypeId != null ? !userTypeId.equals(userType.userTypeId) : userType.userTypeId != null) return false;
        if (type != null ? !type.equals(userType.type) : userType.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userTypeId != null ? userTypeId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userTypeByUserTypeId")
    public Collection<UserLogin> getUserLoginsByUserTypeId() {
        return userLoginsByUserTypeId;
    }

    public void setUserLoginsByUserTypeId(Collection<UserLogin> userLoginsByUserTypeId) {
        this.userLoginsByUserTypeId = userLoginsByUserTypeId;
    }
}
