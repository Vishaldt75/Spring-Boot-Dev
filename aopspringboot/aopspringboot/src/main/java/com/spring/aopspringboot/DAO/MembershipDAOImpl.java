package com.spring.aopspringboot.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addMembers() {
        System.out.println(getClass() + " - DOING MY DB Work : Adding MembershipDAO\n");
        return true;
    }

    @Override
    public void goToSleep() {

        System.out.println(getClass() + " - Going to Sleep\n");

    }
}
